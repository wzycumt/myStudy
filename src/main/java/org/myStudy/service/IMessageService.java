package org.myStudy.service;

import java.util.List;

import org.myStudy.entity.Message;

/**
 * 留言业务接口
 * @author WZY
 */
public interface IMessageService {
	
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
	 * @return
	 */
	public List<Message> getAll(int offset, int limit);
	
	/**
	 * 添加
	 * @param message
	 * @return
	 * @throws Exception 
	 */
	public long add(Message message) throws Exception;
	
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
