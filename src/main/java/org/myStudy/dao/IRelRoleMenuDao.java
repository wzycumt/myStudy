package org.myStudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myStudy.dto.Query;
import org.myStudy.entity.RelRoleMenu;

public interface IRelRoleMenuDao extends IBaseDao<RelRoleMenu> {
	
	public int addBatch(@Param("entities") List<RelRoleMenu> entities);
	
	public int deleteByRoleId(@Param("roleId") int roleId, @Param("query") Query query);
	
	public int deleteByMenuId(@Param("menuId") int menuId, @Param("query") Query query);
}