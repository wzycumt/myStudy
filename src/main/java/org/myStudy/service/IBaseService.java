package org.myStudy.service;

import java.util.List;

import org.myStudy.dto.PageQuery;
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
	T getById(Integer id);
	
	/**
	 * 获取所有
	 * @return
	 * @throws Exception 
	 */
	List<T> getAll();

	/**
	 * 获取分页列表
	 * @param query
	 * @return
	 */
	List<T> getPageList(PageQuery query);
	
	List<T> getList(Query query);
	
	/**
	 * 获取分页查询结果的总数
	 * @param query
	 * @return
	 */
	int getPageListTotal(PageQuery query);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception TODO
	 */
	int deleteById(Integer id) throws Exception;
	
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
	
	int addSelective(T entity) throws Exception;
	
	/**
	 * 编辑
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	int edit(T entity) throws Exception;
	
	int editSelective(T entity) throws Exception;
}
