package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.IMenuDao;
import org.myStudy.dto.PageQuery;
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

	public Menu getById(Integer id) {
		return menuDao.getById(id);
	}

	public List<Menu> getAll() {
		return menuDao.getAll();
	}

	public List<Menu> getPageList(PageQuery query) {
		return menuDao.getPageList(query);
	}

	public int getPageListTotal(PageQuery query) {
		return menuDao.getPageListTotal(query);
	}

	public int deleteById(Integer id) {
		return menuDao.deleteById(id);
	}

	public int add(Menu entity) throws Exception {
		if (entity.getName() == null || entity.getName().trim().equals("")) {
			throw new Exception("名称不能为空");
		}
		menuDao.add(entity);
		return entity.getId();
	}

	public int addSelective(Menu entity) throws Exception {
		if (entity.getName() == null || entity.getName().trim().equals("")) {
			throw new Exception("名称不能为空");
		}
		menuDao.addSelective(entity);
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
		dbEntity.setSerialNum(entity.getSerialNum());
		dbEntity.setStatus(entity.getStatus());
		dbEntity.setRemark(entity.getRemark());
		return menuDao.edit(entity);
	}

	public int editSelective(Menu entity) throws Exception {
		return menuDao.editSelective(entity);
	}

}
