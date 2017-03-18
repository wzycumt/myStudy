package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.ISearchConfigFieldDao;
import org.myStudy.dto.Query;
import org.myStudy.dto.Query.OperatorEnum;
import org.myStudy.entity.SearchConfigField;
import org.myStudy.service.ISearchConfigFieldService;
import org.myStudy.utility.ValidateUtility;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchConfigFieldService implements ISearchConfigFieldService {
	
	@Autowired
	private ISearchConfigFieldDao searchConfigFieldDao;

	@Override
	public SearchConfigField getById(int id) {
		return searchConfigFieldDao.getById(id);
	}

	@Override
	public List<SearchConfigField> getAll() {
		return searchConfigFieldDao.getAll();
	}

	@Override
	public List<SearchConfigField> getList(Query query) {
		return searchConfigFieldDao.getList(query);
	}

	@Override
	public int getListTotal(Query query) {
		return searchConfigFieldDao.getListTotal(query);
	}

	@Override
	public int deleteById(Integer id) throws Exception {
		return searchConfigFieldDao.deleteById(id);
	}

	@Override
	public String deleteBatch(String ids) throws Exception {
		StringBuilder sBuilder = new StringBuilder();
		if (ids == null || ids.length() == 0) {
			throw new Exception("ID不能为空");
		}
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			try {
				deleteById(Integer.parseInt(id));
			} catch (Exception e) {
				sBuilder.append(e.getMessage());
			}
		}
		return sBuilder.toString();
	}

	@Override
	public int add(SearchConfigField entity) throws Exception {
		//校验
		if (entity.getSearchConfigId() == 0) 
			throw new Exception("查询配置ID不能为0");
		if (ValidateUtility.isNullOrEmpty(entity.getDisplayName()))
			throw new Exception("显示名称不能为空");
		if (ValidateUtility.isNullOrEmpty(entity.getFieldName()))
			throw new Exception("字段名称不能为空");
		searchConfigFieldDao.add(entity);
		return entity.getId();
	}

	@Override
	public int edit(SearchConfigField entity) throws Exception {
		//校验
		if (entity.getSearchConfigId() == 0) 
			throw new Exception("查询配置ID不能为0");
		if (ValidateUtility.isNullOrEmpty(entity.getDisplayName()))
			throw new Exception("显示名称不能为空");
		if (ValidateUtility.isNullOrEmpty(entity.getFieldName()))
			throw new Exception("字段名称不能为空");
		SearchConfigField dbEntity = searchConfigFieldDao.getById(entity.getId());
		if (dbEntity == null) {
			throw new Exception("实体不存在");
		}
		dbEntity.setDisplayName(entity.getDisplayName());
		dbEntity.setFieldName(entity.getFieldName());
		dbEntity.setFieldType(entity.getFieldType());
		dbEntity.setFieldReference(entity.getFieldReference());
		dbEntity.setDefault(entity.isDefault());
		dbEntity.setOrder(entity.getOrder());
		return searchConfigFieldDao.edit(dbEntity);
	}

	@Override
	public int editSelective(SearchConfigField entity) throws Exception {
		return searchConfigFieldDao.editSelective(entity);
	}

	@Override
	public List<SearchConfigField> getBySearchConfigId(int id) {
		if (id > 0) {
			Query query = new Query();
			query.addQueryFilter("searchConfigId", OperatorEnum.EQUAL, id);
			return searchConfigFieldDao.getList(query);
		}
		return null;
	}

}
