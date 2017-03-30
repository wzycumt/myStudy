package org.myStudy.dto;

import java.util.Map;

import org.myStudy.entity.User;

/**
 * @author WZY
 */
public class UserModel {

	private User user;
	private Map<Integer, String> dicRoleList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<Integer, String> getDicRoleList() {
		return dicRoleList;
	}

	public void setDicRoleList(Map<Integer, String> dicRoleList) {
		this.dicRoleList = dicRoleList;
	}

}
