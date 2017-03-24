package org.myStudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myStudy.dto.Query;
import org.myStudy.entity.RelUserRole;

public interface IRelUserRoleDao extends IBaseDao<RelUserRole> {
	
	public int addBatch(@Param("entities") List<RelUserRole> entities);
	
	public int deleteByUserId(@Param("userId") int userId, @Param("query") Query query);
	
	public int deleteByRoleId(@Param("roleId") int roleId, @Param("query") Query query);
	
}