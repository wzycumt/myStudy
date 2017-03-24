package org.myStudy.dao;

import java.util.List;

import org.myStudy.entity.Menu;

public interface IMenuDao extends IBaseDao<Menu> {

	List<Menu> getChildrenByParentId(int id);

	/**
	 * 根据角色id获取关联菜单
	 * @param id
	 * @return
	 */
	List<Menu> getListByRoleId(int roleId);

}