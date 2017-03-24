package org.myStudy.entity;

/**
 * 用户角色关系实体
 * @author WZY
 */
public class RelUserRole extends BaseEntity {

    private Integer userId;
    private Integer roleId;

    public RelUserRole(Integer userId, Integer roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}