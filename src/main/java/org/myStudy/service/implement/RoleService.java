package org.myStudy.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.myStudy.dao.IRelRoleMenuDao;
import org.myStudy.dao.IRoleDao;
import org.myStudy.dto.Query;
import org.myStudy.dto.Query.OperatorEnum;
import org.myStudy.entity.RelRoleMenu;
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
	@Autowired
	private IRelRoleMenuDao relRoleMenuDao;

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

	public int saveAuthority(Integer roleId, String menuIds) throws Exception {
		if (roleId == null || roleId == 0)
			throw new Exception("角色ID不能为空");
		//先删除不在menuIds之内的角色菜单关系
		Query query = new Query();
		if (menuIds != null && !menuIds.isEmpty())
			query.addQueryFilter("menuId", OperatorEnum.NOT_IN, menuIds);
		relRoleMenuDao.deleteByRoleId(roleId, query);
		//再批量插入新的角色菜单关系
		if (menuIds != null && !menuIds.isEmpty()) {
			String[] menuIdArr = menuIds.split(",");
			List<RelRoleMenu> relList = new ArrayList<RelRoleMenu>();
			for (int i = 0; i < menuIdArr.length; i++) {
				relList.add(new RelRoleMenu(roleId, Integer.parseInt(menuIdArr[i])));
			}
			relRoleMenuDao.addBatch(relList);
		}
		return 1;
	}

}
