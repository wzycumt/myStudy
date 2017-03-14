package org.myStudy.dao;

import java.util.List;

import org.myStudy.entity.Menu;

public interface IMenuDao extends IBaseDao<Menu> {

	List<Menu> getChildrenByParentId(int id);

}