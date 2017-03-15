package org.myStudy.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.myStudy.enums.BaseStatusEnum;

/**
 * 用户实体
 * @author WZY
 */
public class User extends BaseEntity {

	private String userName;
	private String password;
	private String nickname;
	private String realName;
	private String phone;
	private String email;
	private BaseStatusEnum status;
	private String remark;
	
	//用户权限
	private List<Role> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BaseStatusEnum getStatus() {
    	if (status == null) {
    		status = BaseStatusEnum.INVALID;
    	}
		return status;
	}

	public void setStatus(BaseStatusEnum status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	//扩展
	public String getStatusDes() {
		return getStatus().getDescription();
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	//获取用户的角色名称
	public Set<String> getRolesName() {
		List<Role> roles = getRoles();
		Set<String> set = new HashSet<String>();
		if (roles != null && !roles.isEmpty()) {
			for (Role role : roles) {
				set.add(role.getName());
			}
		}
		return set;
	}
}
