package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IMenuDao;
import org.myStudy.dto.Query;
import org.myStudy.entity.Menu;
import org.myStudy.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单服务实现层
 * @author WZY
 */
@Service
public class MenuService implements IMenuService {
	
	@Autowired
	private IMenuDao menuDao;

	public Menu getById(int id) {
		return menuDao.getById(id);
	}

	public List<Menu> getList(Query query) {
		return menuDao.getList(query);
	}

	public List<Menu> getList() {
		return menuDao.getList();
	}

	public int deleteById(int id) throws Exception {
		return menuDao.deleteById(id);
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

	public int add(Menu entity) throws Exception {
		if (entity.getName() == null || entity.getName().trim().equals("")) {
			throw new Exception("名称不能为空");
		}
		menuDao.add(entity);
		return entity.getId();
	}

	public int edit(Menu entity) throws Exception {
		if (entity.getName() == null || entity.getName().trim().equals("")) {
			throw new Exception("名称不能为空");
		}
		Menu dbEntity = menuDao.getById(entity.getId());
		if (dbEntity == null) {
			throw new Exception("实体不存在");
		}
		dbEntity.setName(entity.getName());
		dbEntity.setUrl(entity.getUrl());
		dbEntity.setOrderNum(entity.getOrderNum());
		dbEntity.setStatus(entity.getStatus());
		dbEntity.setRemark(entity.getRemark());
		return menuDao.edit(entity);
	}

	public int editSelective(Menu entity) throws Exception {
		return menuDao.editSelective(entity);
	}

	public List<Menu> getMenuTreeByParentId(int id) {
		List<Menu> rootMenus = menuDao.getChildrenByParentId(id);
		for(Menu menu : rootMenus){
			List<Menu> children = this.getMenuTreeByParentId(menu.getId());
			menu.setChildren(children);
		}
		return rootMenus;
	}
	
	public List<Menu> getListByRoleId(int roleId) {
		return menuDao.getListByRoleId(roleId);
	}
}
