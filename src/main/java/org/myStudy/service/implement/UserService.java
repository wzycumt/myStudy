package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IUserDao;
import org.myStudy.dto.PageQuery;
import org.myStudy.entity.User;
import org.myStudy.enums.BaseStatusEnum;
import org.myStudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现层
 * @author WZY
 */
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

	public int insert(User entity) throws Exception {
		//校验
		if (entity.getUserName() == null || entity.getUserName().trim().equals("")) {
			throw new Exception("用户名不能为空");
		}
		if (entity.getNickname() == null || entity.getNickname().trim().equals("")) {
			entity.setNickname(entity.getUserName());
		}
		entity.setPassword(entity.getUserName());
		entity.setStatus(BaseStatusEnum.VALID);
		userDao.insert(entity);
		return entity.getId();
	}

	public int insertSelective(User entity) throws Exception {
		userDao.insertSelective(entity);
		return entity.getId();
	}

	public int update(User entity) throws Exception {
		//校验
		if (entity.getUserName() == null || entity.getUserName().trim().equals("")) {
			throw new Exception("用户名不能为空");
		}
		if (entity.getNickname() == null || entity.getNickname().trim().equals("")) {
			entity.setNickname(entity.getUserName());
		}
		User dbEntity = userDao.selectById(entity.getId());
		if (dbEntity == null) {
			throw new Exception("实体不存在");
		}
		dbEntity.setUserName(entity.getUserName());
		dbEntity.setNickname(entity.getNickname());
		dbEntity.setRealName(entity.getRealName());
		dbEntity.setPhone(entity.getPhone());
		dbEntity.setEmail(entity.getEmail());
		dbEntity.setStatus(entity.getStatus());
		dbEntity.setRemark(entity.getRemark());
		return userDao.update(dbEntity);
	}

	public int updateSelective(User entity) throws Exception {
		return userDao.updateSelective(entity);
	}

}
