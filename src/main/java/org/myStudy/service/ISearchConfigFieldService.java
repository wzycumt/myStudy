package org.myStudy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myStudy.dto.Query;
import org.myStudy.entity.SearchConfigField;

public interface ISearchConfigFieldService extends IBaseService<SearchConfigField> {

	List<SearchConfigField> getBySearchConfigId(int id);
	
	public int addBatch(@Param("entities") List<SearchConfigField> entities);
	
	public int deleteByConfigId(@Param("searchConfigId") int searchConfigId, @Param("query") Query query);

}
