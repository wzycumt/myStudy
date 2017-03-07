package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IUserDao;
import org.myStudy.dto.Datatables;
import org.myStudy.dto.PageQuery1;
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

	public Datatables<User> getPageList(PageQuery1 query) {
		Datatables<User> datatables = new Datatables<User>();
		datatables.setDraw(query.getDraw());
		datatables.setData(userDao.getPageList(query));
		datatables.setRecordsFiltered(datatables.getData().size());
		datatables.setRecordsTotal(datatables.getData().size());
		return datatables;
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
		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			throw new Exception("密码不能为空");
		}
		if (user.getNickname() == null || user.getNickname().trim().equals("")) {
			user.setNickname(user.getUserName());
		}
		return userDao.edit(user);
	}

	public int delete(int id) {
		return userDao.delete(id);
	}

	public int deleteAll(String ids) {
		return userDao.deleteAll(ids);
	}

}
