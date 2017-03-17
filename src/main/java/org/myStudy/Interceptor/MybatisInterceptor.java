package org.myStudy.Interceptor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.myStudy.entity.BaseEntity;
import org.myStudy.utility.ApplycationUtility;

@Intercepts({ 
	@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }),
	@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class })
})
public class MybatisInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 拦截StatementHandler的prepare方法，实现分页
		if (invocation.getTarget() instanceof RoutingStatementHandler) {
			doPage(invocation);
		}

		// 拦截Executor的update方法
		// 当插入或更新实体时，为creator或updatePerson赋值
		if (invocation.getTarget() instanceof CachingExecutor) {
			setProperty(invocation);
		}
		
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

	/**
	 * 拦截StatementHandler的prepare方法
	 * 实现分页
	 * @param invocation
	 */
	private void doPage(Invocation invocation) {
		RoutingStatementHandler statementHandler = (RoutingStatementHandler)invocation.getTarget();    
        StatementHandler delegate = (StatementHandler) ReflectUtilily.getFieldValue(statementHandler, "delegate");    
        BoundSql boundSql = delegate.getBoundSql();  
        Object obj = boundSql.getParameterObject();  
        if (obj instanceof Page<?>) {    
        	Page<?> page = (Page<?>) obj;
            //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
            MappedStatement mappedStatement = (MappedStatement)ReflectUtilily.getFieldValue(delegate, "mappedStatement");
            //拦截到的prepare方法参数是一个Connection对象
            Connection connection = (Connection)invocation.getArgs()[0];
            //获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
            String sql = boundSql.getSql();
            //给当前的page参数对象设置总记录数
            this.setTotalRecord(page, mappedStatement, connection);
            //获取分页Sql语句
            String pageSql = this.getPageSql(page, sql);
            //利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
            ReflectUtilily.setFieldValue(boundSql, "sql", pageSql);
        } 
	}

	/**
	 * 给当前的参数对象page设置总记录数
	 * @param page Mapper映射语句对应的参数对象
	 * @param mappedStatement Mapper映射语句
	 * @param connection 当前的数据库连接
	 */
	private void setTotalRecord(Page<?> page, MappedStatement mappedStatement, Connection connection) {
		// 获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
		// delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
		BoundSql boundSql = mappedStatement.getBoundSql(page);
		// 获取到我们自己写在Mapper映射语句中对应的Sql语句
		String sql = boundSql.getSql();
		// 通过查询Sql语句获取到对应的计算总记录数的sql语句
		String countSql = this.getCountSql(sql);
		// 通过BoundSql获取对应的参数映射
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		// 利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
		BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
		// 通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
		// 通过connection建立一个countSql对应的PreparedStatement对象。
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			// 通过parameterHandler给PreparedStatement对象设置参数
			parameterHandler.setParameters(pstmt);
			// 之后就是执行获取总记录数的Sql语句和获取结果了。
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				// 给当前的参数page对象设置总记录数
				page.setTotalRecord(totalRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据原Sql语句获取对应的查询总记录数的Sql语句
	 * @param sql
	 * @return
	 */
	private String getCountSql(String sql) {
		int index = sql.indexOf("from");
		return "select count(1) " + sql.substring(index);
	}

	/**
	 * 根据page对象获取对应的分页查询Sql语句，这里只做了两种数据库类型，Mysql和Oracle 其它的数据库都 没有进行分页
	 * @param page 分页对象
	 * @param sql 原sql语句
	 * @return
	 */
	private String getPageSql(Page<?> page, String sql) {
		StringBuffer sqlBuffer = new StringBuffer(sql);
		// 计算第一条记录的位置，Mysql中记录的位置是从0开始的。
		// System.out.println("page:"+page.getPage()+"-------"+page.getRows());
		int offset = (page.getPage() - 1) * page.getRows();
		sqlBuffer.append(" limit ").append(offset).append(",").append(page.getRows());
		return sqlBuffer.toString();
	}

	/**
	 * 拦截Executor的update方法
	 * 当插入或更新实体时，为creator或updatePerson赋值
	 * @param invocation
	 */
	private void setProperty(Invocation invocation) {
		Object[] args = invocation.getArgs();
		if (args != null && args.length == 2) {
			Object arg0 = args[0];
			Object arg1 = args[1];
			// 根据第一个参数判断是否给“操作属性”赋值。
			if (arg0 instanceof MappedStatement && arg1 instanceof BaseEntity) {
				MappedStatement ms = (MappedStatement) arg0;
				BaseEntity entity = (BaseEntity) arg1;
				SqlCommandType sqlCommandType = ms.getSqlCommandType();
				int currentUserId = ApplycationUtility.getCurrentUserId(); //当前登录用户Id
				if (sqlCommandType == SqlCommandType.INSERT) {
					entity.setCreator(currentUserId);
					entity.setUpdatePerson(currentUserId);
				} else if (sqlCommandType == SqlCommandType.UPDATE) {
					entity.setUpdatePerson(currentUserId);
				}
			}
		}
	}
	
	/**
	 * 利用反射进行操作的一个工具类
	 */
	private static class ReflectUtilily {
		/**
		 * 利用反射获取指定对象的指定属性
		 * @param obj 目标对象
		 * @param fieldName 目标属性
		 * @return 目标属性的值
		 */
		private static Object getFieldValue(Object obj, String fieldName) {
			Object result = null;
			Field field = ReflectUtilily.getField(obj, fieldName);
			if (field != null) {
				field.setAccessible(true);
				try {
					result = field.get(obj);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return result;
		}

		/**
		 * 利用反射获取指定对象里面的指定属性
		 * @param obj 目标对象
		 * @param fieldName 目标属性
		 * @return 目标字段
		 */
		private static Field getField(Object obj, String fieldName) {
			Field field = null;
			for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
				try {
					field = clazz.getDeclaredField(fieldName);
					break;
				} catch (NoSuchFieldException e) {
					// 这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
				}
			}
			return field;
		}

		/**
		 * 利用反射设置指定对象的指定属性为指定的值
		 * @param obj 目标对象
		 * @param fieldName 目标属性
		 * @param fieldValue 目标值
		 */
		private static void setFieldValue(Object obj, String fieldName, String fieldValue) {
			Field field = ReflectUtilily.getField(obj, fieldName);
			if (field != null) {
				try {
					field.setAccessible(true);
					field.set(obj, fieldValue);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
