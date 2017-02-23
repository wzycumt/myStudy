package org.myStudy.service.implement;

import java.util.Date;
import java.util.List;

import org.myStudy.dao.MessageDao;
import org.myStudy.entity.Message;
import org.myStudy.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MessageDao messageDao;

	public Message getById(Long id) {
		return messageDao.getById(id);
	}

	public List<Message> getAll(int offset, int limit) {
		return messageDao.getAll(offset, limit);
	}

	public long add(Message message) throws Exception {
		if (message.getName() == null || message.getName().trim().isEmpty())
			throw new Exception("留言人不能为空");
		if (message.getContent() == null || message.getContent().trim().isEmpty())
			throw new Exception("留言内容不能为空");
		message.setStatus(1);
		message.setCreateTime(new Date());
		message.setUpdateTime(message.getCreateTime());
		message.setVersion(0);
		try {
			messageDao.add(message);
			return message.getId();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int edit(Message message) {
		return messageDao.edit(message);
	}

	public int delete(Long id) {
		return messageDao.delete(id);
	}

	public int deleteAll(String ids) {
		return messageDao.deleteAll(ids);
	}

}
