package org.myStudy.dao;

import org.apache.ibatis.annotations.Param;
import org.myStudy.entity.User;

public interface IUserDao extends IBaseDao<User> {
	
	User getByIdWithRoles(@Param("id") int id);

}