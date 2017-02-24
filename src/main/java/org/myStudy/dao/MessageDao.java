package org.myStudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myStudy.Enum.OrderEnum;
import org.myStudy.entity.Message;

/**
 * 留言板数据访问层
 * @author WZY
 */
public interface MessageDao {
	
	/**
	 * 根据ID获取留言信息
	 * @param id
	 * @return
	 */
	public Message getById(Long id);
	
	/**
	 * 获取所有留言信息
	 * @param offset
	 * @param limit
	 * @param sort 排序字段
	 * @param order 排序类别（升序/降序）
	 * @return
	 */
	public List<Message> getAll(@Param("offset") int offset, @Param("limit") int limit, @Param("sort") String sort, @Param("order") OrderEnum order);
	
	/**
	 * 添加
	 * @param message
	 * @return
	 */
	public int add(Message message);
	
	/**
	 * 编辑
	 * @param message
	 * @return
	 */
	public int edit(Message message);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteAll(String ids);
}
