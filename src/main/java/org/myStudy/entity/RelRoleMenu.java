package org.myStudy.entity;

/**
 * 角色菜单关系实体
 * @author WZY
 */
public class RelRoleMenu extends BaseEntity {

	private Integer roleId;
	private Integer menuId;

	public RelRoleMenu(Integer roleId, Integer menuId) {
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}