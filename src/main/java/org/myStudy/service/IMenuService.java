package org.myStudy.service;

import java.util.List;

import org.myStudy.entity.Menu;

/**
 * 菜单服务接口层
 * @author WZY
 */
public interface IMenuService extends IBaseService<Menu> {
	
	List<Menu> getMenuTreeByParentId(int parentId);
	
}
