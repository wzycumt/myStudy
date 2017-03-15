package org.myStudy.dao;

import java.util.List;

import org.myStudy.dto.PageQuery;
import org.myStudy.dto.Query;

public interface IBaseDao<T> {

    T getById(Integer id);

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
    
    int deleteById(Integer id);

    int add(T entity);

    int addSelective(T entity);

    int edit(T entity);

    int editSelective(T entity);
}
