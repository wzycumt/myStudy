package org.myStudy.service;

import java.util.List;

import org.myStudy.entity.User;

/**
 * 用户服务接口层
 * @author WZY
 */
public interface IUserService extends IBaseService<User> {

	/**
	 * 根据用户名获取用户
	 * @param loginName
	 * @return
	 */
	User getByUserName(String loginName);

	/**
	 * 添加用户及用户角色关系
	 * @return
	 * @throws Exception 
	 */
	int add(User user, List<Integer> roleIds) throws Exception;

	/**
	 * 编辑用户及用户角色关系
	 * @return
	 * @throws Exception 
	 */
	int edit(User user, List<Integer> roleIds) throws Exception;

}
