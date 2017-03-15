package org.myStudy.service;

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

}
