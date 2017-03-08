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
	User selectById(Integer id);
	
	/**
	 * 获取所有
	 * @return
	 * @throws Exception 
	 */
	List<User> selectAll();

	/**
	 * 获取分页列表
	 * @param query
	 * @return
	 */
	List<User> selectPageList(PageQuery query);
	
	/**
	 * 获取分页查询结果的总数
	 * @param query
	 * @return
	 */
	int selectPageListTotal(PageQuery query);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	
	/**
	 * 添加
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	long insert(User entity) throws Exception;
	
	long insertSelective(User entity) throws Exception;
	
	/**
	 * 编辑
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	int update(User entity) throws Exception;
	
	long updateSelective(User entity) throws Exception;
}
