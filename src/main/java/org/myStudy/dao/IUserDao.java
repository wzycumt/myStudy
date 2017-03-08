package org.myStudy.dao;

import java.util.List;

import org.myStudy.dto.PageQuery;
import org.myStudy.entity.User;

/**
 * 用户数据访问层
 * @author WZY
 */
public interface IUserDao {

	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 */
	public User getById(int id);

	/**
	 * 获取所有
	 * @return
	 */
	public List<User> getAll();

	/**
	 * 获取分页列表
	 * @param query
	 * @return
	 */
	public List<User> getPageList(PageQuery query);
	
	/**
	 * 获取分页查询结果的总数
	 * @param query
	 * @return
	 */
	public int getPageListTotal(PageQuery query);
	
	/**
	 * 添加
	 * @param message
	 * @return
	 */
	public int add(User entity);

	/**
	 * 编辑
	 * @param message
	 * @return
	 */
	public int edit(User entity);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int id);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteAll(String ids);
}
