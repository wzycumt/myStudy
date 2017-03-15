package org.myStudy.dto;

import java.util.ArrayList;
import java.util.List;

import org.myStudy.enums.IEnum;

/**
 * SQL查询过滤、排序组合类
 * @author WZY
 */
public class Query {

	private List<QueryFilter> queryFilters;
	private List<SortColumn> sortColumns;

	private boolean isPaged; //是否分页
	private int offset;
	private int limit;

	public List<QueryFilter> getQueryFilters() {
		return queryFilters;
	}

	public void setQueryFilters(List<QueryFilter> queryFilters) {
		this.queryFilters = queryFilters;
	}

	public List<SortColumn> getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(List<SortColumn> sortColumns) {
		this.sortColumns = sortColumns;
	}

	/**
	 * 是否分页
	 * @return
	 */
	public boolean isPaged() {
		return isPaged;
	}

	public void setPaged(boolean isPaged) {
		this.isPaged = isPaged;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void addQueryFilter(String columnName, OperatorEnum operator, Object value) {
		if (queryFilters == null)
			queryFilters = new ArrayList<QueryFilter>();
		queryFilters.add(new QueryFilter(columnName, operator, value));
	}

	public void addSortColumn(String columnName, boolean isDescend) {
		if (sortColumns == null)
			sortColumns = new ArrayList<SortColumn>();
		sortColumns.add(new SortColumn(columnName, isDescend));
	}

	public void addSortColumn(String columnName, boolean isDescend, boolean camelCaseToUnderscore) {
		if (sortColumns == null)
			sortColumns = new ArrayList<SortColumn>();
		sortColumns.add(new SortColumn(columnName, isDescend, camelCaseToUnderscore));
	}

	/**
	 * 查询条件过滤类
	 * @author WZY
	 */
	public class QueryFilter {

		private String columnName;
		private OperatorEnum operator;
		private Object value;

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public OperatorEnum getOperator() {
			return operator;
		}

		public void setOperator(OperatorEnum operator) {
			this.operator = operator;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public QueryFilter(String columnName, OperatorEnum operator, Object value) {
			this.columnName = columnName;
			this.operator = operator;
			this.value = value;
		}
	}

	/**
	 * 排序类
	 * @author WZY
	 */
	public class SortColumn {

		private String columnName;
		private boolean isDescend = false;
		private boolean camelCaseToUnderscore = false;

		public SortColumn(String columnName, boolean isDescend) {
			this.columnName = columnName;
			this.isDescend = isDescend;
		}

		public SortColumn(String columnName, boolean isDescend, boolean camelCaseToUnderscore) {
			this.columnName = columnName;
			this.isDescend = isDescend;
			this.camelCaseToUnderscore = camelCaseToUnderscore;
		}

		public String getColumnName() {
			if (camelCaseToUnderscore)
				return toUnderscoreName(columnName);
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public boolean isDescend() {
			return isDescend;
		}

		public void setDescend(boolean isDescend) {
			this.isDescend = isDescend;
		}

		public boolean isCamelCaseToUnderScore() {
			return camelCaseToUnderscore;
		}

		public void setCamelCaseToUnderScore(boolean camelCaseToUnderscore) {
			this.camelCaseToUnderscore = camelCaseToUnderscore;
		}
		
		/**
		 * 将驼峰式命名的字符串转换为下划线大写方式。如果传入null，则返回null。</br>
		 * 例如：helloWorld->HELLO_WORLD
		 * @param name 转换前的驼峰式命名的字符串
		 * @return 转换后下划线大写方式命名的字符串
		 */
		private String toUnderscoreName(String name) {
			if (name == null)
				return null;
		    StringBuilder result = new StringBuilder();
		    if (name.length() > 0) {
		        // 将第一个字符处理成大写
		        result.append(name.substring(0, 1).toUpperCase());
		        // 循环处理其余字符
		        for (int i = 1; i < name.length(); i++) {
		            String s = name.substring(i, i + 1);
		            // 在大写字母前添加下划线
		            if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
		                result.append("_");
		            }
		            // 其他字符直接转成大写
		            result.append(s.toUpperCase());
		        }
		    }
		    return result.toString();
		}
	}

	/**
	 * 运算符枚举
	 * @author WZY
	 */
	public enum OperatorEnum implements IEnum {
		LIKE(0, "like"),
		EQUAL(1, "="),
		UNEQUAL(2, "<>"),
		LESS_THAN(3, "<"),
		LESS_THAN_OR_EQUAL(4, "<="),
		GREATER_THAN(5,">"),
		GREATER_THAN_OR_EQUAL(6, ">="),
		IN(7, "in"),
		NOT_IN(8, "not in"),
		IS_NULL(9, "is null"),
		IS_NOT_NULL(10, "is not null");

		private int vlaue;
		private String description;

		private OperatorEnum(int vlaue, String description) {
			this.vlaue = vlaue;
			this.description = description;
		}

		public int getValue() {
			return vlaue;
		}

		public String getDescription() {
			return description;
		}
	}
}
