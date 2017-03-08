package org.myStudy.service;

import java.util.List;

import org.myStudy.dto.PageQuery;
import org.myStudy.entity.User;

public interface IUserService {
	
	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 */
	public User getById(int id);
	
	/**
	 * 获取所有
	 * @return
	 * @throws Exception 
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
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	public long add(User entity) throws Exception;
	
	/**
	 * 编辑
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	public int edit(User entity) throws Exception;
	
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
