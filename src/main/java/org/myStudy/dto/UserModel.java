package org.myStudy.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.myStudy.entity.User;

/**
 * @author WZY
 */
public class UserModel {

	private User user;
	private List<Integer> roleIds;
	private Map<Integer, String> dicRoleList;
	
	public UserModel() {
		
	}

	public User getUser() {
		if (user == null)
			return new User();
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getRoleIds() {
		if (roleIds == null)
			return new ArrayList<Integer>();
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public Map<Integer, String> getDicRoleList() {
		return dicRoleList;
	}

	public void setDicRoleList(Map<Integer, String> dicRoleList) {
		this.dicRoleList = dicRoleList;
	}

	@Override
	public String toString() {
		return "UserModel [user=" + user + ", roleIds=" + roleIds + ", dicRoleList=" + dicRoleList + "]";
	}

}
