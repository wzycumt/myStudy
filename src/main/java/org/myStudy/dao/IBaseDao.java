package org.myStudy.dao;

import java.util.List;

import org.myStudy.dto.Query;

public interface IBaseDao<T> {

    T getById(Integer id);

	/**
	 * 获取List
	 * @param query
	 * @return
	 */
	List<T> getList(Query query);

	List<T> getList();
    
    int deleteById(Integer id);

    int add(T entity);

    int edit(T entity);

    int editSelective(T entity);
}
