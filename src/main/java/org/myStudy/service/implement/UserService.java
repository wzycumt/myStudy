package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IUserDao;
import org.myStudy.dto.Query;
import org.myStudy.dto.Query.OperatorEnum;
import org.myStudy.entity.User;
import org.myStudy.enums.BaseStatusEnum;
import org.myStudy.service.IUserService;
import org.myStudy.utility.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现层
 * @author WZY
 */
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
	
	public List<User> getList(Query query) {
		return userDao.getList(query);
	}

	public int getListTotal(Query query) {
		return userDao.getListTotal(query);
	}

	public int deleteById(int id) throws Exception {
		return userDao.deleteById(id);
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
	
	public int add(User entity) throws Exception {
		//校验
		if (entity.getUserName() == null || entity.getUserName().trim().equals(""))
			throw new Exception("用户名不能为空");
		if (getByUserName(entity.getUserName()) != null)
			throw new Exception("用户名重复，请选择其他用户名");
		if (entity.getNickname() == null || entity.getNickname().trim().equals("")) {
			entity.setNickname(entity.getUserName());
		}
		entity.setPassword(entity.getUserName());
		entity.setStatus(BaseStatusEnum.VALID);
		return entity.getId();
	}
	
	@Transactional
	public int add(User entity, List<Integer> roleIds) throws Exception {
		add(entity);
		if (roleIds != null && !roleIds.isEmpty()) {
			userDao.addUserRole(entity.getId(), roleIds);
		}
		return entity.getId();
	}

	public int edit(User entity) throws Exception {
		//校验
		if (entity.getUserName() == null || entity.getUserName().trim().equals(""))
			throw new Exception("用户名不能为空");
		User user = getByUserName(entity.getUserName());
		if (user != null && user.getId() != entity.getId())
			throw new Exception("用户名重复，请选择其他用户名");
		if (entity.getNickname() == null || entity.getNickname().trim().equals("")) {
			entity.setNickname(entity.getUserName());
		}
		User dbEntity = userDao.getById(entity.getId());
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
		return userDao.edit(dbEntity);
	}
	
	@Transactional
	public int edit(User entity, List<Integer> roleIds) throws Exception {
		int res = edit(entity);
		Query query = new Query();
		query.addQueryFilter("roleId", OperatorEnum.NOT_IN, StringUtility.join(roleIds, ","));
		userDao.deleteUserRole(entity.getId(), query);
		if (roleIds != null && !roleIds.isEmpty()) {
			userDao.addUserRole(entity.getId(), roleIds);
		}
		return res;
	}

	public int editSelective(User entity) throws Exception {
		return userDao.editSelective(entity);
	}

	public User getByUserName(String loginName) {
		Query query = new Query();
		query.addQueryFilter("user_name", OperatorEnum.EQUAL, loginName);
		List<User> list = userDao.getList(query);
		if (list != null && !list.isEmpty())
			return list.get(0);
		return null;
	}

}
