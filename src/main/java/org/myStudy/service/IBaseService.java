package org.myStudy.service;

import java.util.List;

import org.myStudy.dto.Query;

/**
 * 服务层基础接口
 * @author WZY
 * @param <T>
 */
public interface IBaseService<T> {
	
	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 */
	T getById(int id);

	/**
	 * 获取List
	 * @param query
	 * @return
	 */
	List<T> getList(Query query);

	List<T> getList();
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception TODO
	 */
	int deleteById(int id) throws Exception;
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @throws Exception TODO
	 */
	String deleteBatch(String ids) throws Exception;
	
	/**
	 * 添加
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	int add(T entity) throws Exception;
	
	/**
	 * 编辑
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	int edit(T entity) throws Exception;
	
	int editSelective(T entity) throws Exception;
}
