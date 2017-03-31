package org.myStudy.service.implement;

import java.util.Date;
import java.util.List;

import org.myStudy.dao.IMessageDao;
import org.myStudy.dto.Query;
import org.myStudy.entity.Message;
import org.myStudy.enums.BaseStatusEnum;
import org.myStudy.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private IMessageDao messageDao;

	public Message getById(int id) {
		return messageDao.getById(id);
	}
	
	public List<Message> getList(Query query) {
		return messageDao.getList(query);
	}

	public List<Message> getList() {
		return messageDao.getList();
	}
	
	public List<Message> getListWithNum(Query query) {
		return messageDao.getListWithNum(query);
	}

	public int deleteById(int id) throws Exception {
		return messageDao.deleteById(id);
	}

	public String deleteBatch(String ids) throws Exception {
		StringBuilder sBuilder = new StringBuilder();
		if (ids == null || ids.length() == 0) {
			throw new Exception("ID不能为空");
		}
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			try {
				deleteById(Integer.parseInt(id));
			} catch (Exception e) {
				sBuilder.append(e.getMessage());
			}
		}
		return sBuilder.toString();
	}

	public int add(Message entity) throws Exception {
		if (entity.getName() == null || entity.getName().trim().isEmpty())
			throw new Exception("留言人不能为空");
		if (entity.getContent() == null || entity.getContent().trim().isEmpty())
			throw new Exception("留言内容不能为空");
		entity.setStatus(BaseStatusEnum.VALID);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(entity.getCreateTime());
		entity.setVersion(0);
		messageDao.add(entity);
		return entity.getId();
	}

	public int edit(Message entity) throws Exception {
		return messageDao.edit(entity);
	}

	public int editSelective(Message entity) throws Exception {
		return messageDao.editSelective(entity);
	}

}
