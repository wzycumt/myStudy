package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IRoleDao;
import org.myStudy.dto.Query;
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

	public Role getById(int id) {
		return roleDao.getById(id);
	}

	public List<Role> getAll() {
		return roleDao.getAll();
	}
	
	public List<Role> getList(Query query) {
		if (query == null)
			return null;
		return roleDao.getList(query);
	}

	public int getListTotal(Query query) {
		return roleDao.getListTotal(query);
	}

	public int deleteById(int id) throws Exception {
		return roleDao.deleteById(id);
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

	public int add(Role entity) throws Exception {
		if (entity == null)
			throw new Exception("实体不能为空");
		if (entity.getName() == null || entity.getName().equals(""))
			throw new Exception("角色名称不能为空");
		roleDao.add(entity);
		return entity.getId();
	}

	public int edit(Role entity) throws Exception {
		return roleDao.edit(entity);
	}

	public int editSelective(Role entity) throws Exception {
		return roleDao.editSelective(entity);
	}

}
