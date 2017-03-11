package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IRoleDao;
import org.myStudy.dto.PageQuery;
import org.myStudy.entity.Role;
import org.myStudy.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色服务实现层
 * @author WZY
 */
@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	public Role getById(Integer id) {
		return roleDao.selectById(id);
	}

	public List<Role> getAll() {
		return roleDao.selectAll();
	}

	public List<Role> getPageList(PageQuery query) {
		return roleDao.selectPageList(query);
	}

	public int getPageListTotal(PageQuery query) {
		return roleDao.selectPageListTotal(query);
	}

	public int deleteById(Integer id) {
		return roleDao.deleteById(id);
	}

	public int add(Role entity) throws Exception {
		roleDao.insert(entity);
		return entity.getId();
	}

	public int addSelective(Role entity) throws Exception {
		roleDao.insertSelective(entity);
		return entity.getId();
	}

	public int edit(Role entity) throws Exception {
		return roleDao.update(entity);
	}

	public int editSelective(Role entity) throws Exception {
		return roleDao.updateSelective(entity);
	}

}
