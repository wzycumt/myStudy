package org.myStudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myStudy.dto.Query;
import org.myStudy.entity.SearchConfigField;

public interface ISearchConfigFieldDao extends IBaseDao<SearchConfigField> {
	
	public int addBatch(@Param("entities") List<SearchConfigField> entities);
	
	public int deleteByConfigId(@Param("searchConfigId") int searchConfigId, @Param("query") Query query);

}
