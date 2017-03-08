package org.myStudy.dao;

import java.util.List;

import org.myStudy.dto.PageQuery;

public interface IBaseDao<T> {

    T selectById(Integer id);

    List<T> selectAll();

	/**
	 * 获取分页列表
	 * @param query
	 * @return
	 */
	List<T> selectPageList(PageQuery query);
	
	/**
	 * 获取分页查询结果的总数
	 * @param query
	 * @return
	 */
	int selectPageListTotal(PageQuery query);
    
    int deleteById(Integer id);

    int insert(T entity);

    int insertSelective(T entity);

    int update(T entity);

    int updateSelective(T entity);
}
