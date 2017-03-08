package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IUserDao;
import org.myStudy.dto.PageQuery;
import org.myStudy.entity.User;
import org.myStudy.enums.BaseStatusEnum;
import org.myStudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	public User getById(int id) {
		return userDao.getById(id);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}

	public List<User> getPageList(PageQuery query) {
		return userDao.getPageList(query);
	}

	public int getPageListTotal(PageQuery query) {
		return userDao.getPageListTotal(query);
	}

	public long add(User user) throws Exception {
		//校验
		if (user.getUserName() == null || user.getUserName().trim().equals("")) {
			throw new Exception("用户名不能为空");
		}
		if (user.getNickname() == null || user.getNickname().trim().equals("")) {
			user.setNickname(user.getUserName());
		}
		user.setPassword(user.getUserName());
		user.setStatus(BaseStatusEnum.VALID);
		userDao.add(user);
		return user.getId();
	}

	public int edit(User user) throws Exception {
		//校验
		if (user.getUserName() == null || user.getUserName().trim().equals("")) {
			throw new Exception("用户名不能为空");
		}
		if (user.getNickname() == null || user.getNickname().trim().equals("")) {
			user.setNickname(user.getUserName());
		}
		User entity = userDao.getById(user.getId());
		entity.setUserName(user.getUserName());
		entity.setNickname(user.getNickname());
		entity.setRealName(user.getRealName());
		entity.setPhone(user.getPhone());
		entity.setEmail(user.getEmail());
		entity.setStatus(user.getStatus());
		entity.setRemark(user.getRemark());
		return userDao.edit(user);
	}

	public int delete(int id) {
		return userDao.delete(id);
	}

	public int deleteAll(String ids) {
		return userDao.deleteAll(ids);
	}

}
