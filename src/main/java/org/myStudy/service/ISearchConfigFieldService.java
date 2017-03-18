package org.myStudy.service;

import java.util.List;

import org.myStudy.entity.SearchConfigField;

public interface ISearchConfigFieldService extends IBaseService<SearchConfigField> {

	List<SearchConfigField> getBySearchConfigId(int id);

}
