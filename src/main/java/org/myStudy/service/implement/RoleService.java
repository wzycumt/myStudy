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
		return roleDao.getById(id);
	}

	public List<Role> getAll() {
		return roleDao.getAll();
	}

	public List<Role> getPageList(PageQuery query) {
		return roleDao.getPageList(query);
	}

	public int getPageListTotal(PageQuery query) {
		return roleDao.getPageListTotal(query);
	}

	public int deleteById(Integer id) {
		return roleDao.deleteById(id);
	}

	public int add(Role entity) throws Exception {
		roleDao.add(entity);
		return entity.getId();
	}

	public int addSelective(Role entity) throws Exception {
		roleDao.addSelective(entity);
		return entity.getId();
	}

	public int edit(Role entity) throws Exception {
		return roleDao.edit(entity);
	}

	public int editSelective(Role entity) throws Exception {
		return roleDao.editSelective(entity);
	}

}
