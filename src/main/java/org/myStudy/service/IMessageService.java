package org.myStudy.service;

import java.util.List;

import org.myStudy.dto.Query;
import org.myStudy.entity.Message;

/**
 * 留言业务接口
 * @author WZY
 */
public interface IMessageService extends IBaseService<Message> {
	
	List<Message> getListWithNum(Query query);
	
}
