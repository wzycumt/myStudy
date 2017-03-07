package org.myStudy.service;

import java.util.List;

import org.myStudy.dto.Datatables;
import org.myStudy.dto.PageQuery1;
import org.myStudy.entity.User;

public interface IUserService {
	
	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 */
	public User getById(int id);
	
	/**
	 * @return
	 * @throws Exception 
	 */
	public List<User> getAll();

	/**
	 * 获取分页列表
	 * @param query
	 * @return
	 */
	public Datatables<User> getPageList(PageQuery1 query);
	
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
