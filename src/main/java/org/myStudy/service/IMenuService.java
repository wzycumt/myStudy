package org.myStudy.service;

import java.util.List;

import org.myStudy.entity.Menu;

/**
 * 菜单服务接口层
 * @author WZY
 */
public interface IMenuService extends IBaseService<Menu> {
	
	List<Menu> getMenuTreeByParentId(int parentId);

	/**
	 * 根据角色id获取关联菜单
	 * @param id
	 * @return
	 */
	List<Menu> getListByRoleId(int id);
	
}
