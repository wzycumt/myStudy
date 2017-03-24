package org.myStudy.service;

import org.myStudy.entity.Role;

/**
 * 角色服务接口层
 * @author WZY
 */
public interface IRoleService extends IBaseService<Role> {

	/**
	 * 保存角色授权
	 * @param roleId
	 * @param menuIds
	 * @return
	 * @throws Exception 
	 */
	int saveAuthority(Integer roleId, String menuIds) throws Exception;

}
