package org.myStudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myStudy.dto.Query;
import org.myStudy.entity.User;

public interface IUserDao extends IBaseDao<User> {

    int addUserRole(@Param("userId") int userId, @Param("roleIds") List<Integer> roleIds);

    int deleteUserRole(@Param("userId") int userId, @Param("query") Query query);

}