package org.myStudy.service;

import org.myStudy.entity.User;

/**
 * 用户服务接口层
 * @author WZY
 */
public interface IUserService extends IBaseService<User> {
	
	User getById(int id, boolean withRoles);

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
	int addWithRoles(User user) throws Exception;

	/**
	 * 编辑用户及用户角色关系
	 * @return
	 * @throws Exception 
	 */
	int editWithRoles(User user) throws Exception;

}
