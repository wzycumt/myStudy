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

	public User selectById(Integer id) {
		return userDao.selectById(id);
	}

	public List<User> selectAll() {
		return userDao.selectAll();
	}

	public List<User> selectPageList(PageQuery query) {
		return userDao.selectPageList(query);
	}

	public int selectPageListTotal(PageQuery query) {
		return userDao.selectPageListTotal(query);
	}

	public int deleteById(Integer id) {
		return userDao.deleteById(id);
	}

	public long insert(User user) throws Exception {
		//校验
		if (user.getUserName() == null || user.getUserName().trim().equals("")) {
			throw new Exception("用户名不能为空");
		}
		if (user.getNickname() == null || user.getNickname().trim().equals("")) {
			user.setNickname(user.getUserName());
		}
		user.setPassword(user.getUserName());
		user.setStatus(BaseStatusEnum.VALID);
		userDao.insert(user);
		return user.getId();
	}

	public long insertSelective(User entity) throws Exception {
		return userDao.insertSelective(entity);
	}

	public int update(User user) throws Exception {
		//校验
		if (user.getUserName() == null || user.getUserName().trim().equals("")) {
			throw new Exception("用户名不能为空");
		}
		if (user.getNickname() == null || user.getNickname().trim().equals("")) {
			user.setNickname(user.getUserName());
		}
		User entity = userDao.selectById(user.getId());
		entity.setUserName(user.getUserName());
		entity.setNickname(user.getNickname());
		entity.setRealName(user.getRealName());
		entity.setPhone(user.getPhone());
		entity.setEmail(user.getEmail());
		entity.setStatus(user.getStatus());
		entity.setRemark(user.getRemark());
		return userDao.update(user);
	}

	public long updateSelective(User entity) throws Exception {
		return userDao.updateSelective(entity);
	}

}
