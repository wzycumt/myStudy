package org.myStudy.dao;

import java.util.List;

import org.myStudy.dto.Query;
import org.myStudy.entity.Message;

/**
 * 留言板数据访问层
 * @author WZY
 */
public interface IMessageDao extends IBaseDao<Message> {
	
	List<Message> getListWithNum(Query query);
	
}
