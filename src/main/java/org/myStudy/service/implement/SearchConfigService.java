package org.myStudy.service.implement;

import java.util.List;

import org.myStudy.dao.ISearchConfigDao;
import org.myStudy.dto.Query;
import org.myStudy.dto.QueryFilter.OperatorEnum;
import org.myStudy.entity.SearchConfig;
import org.myStudy.enums.BaseStatusEnum;
import org.myStudy.service.ISearchConfigFieldService;
import org.myStudy.service.ISearchConfigService;
import org.myStudy.utility.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询配置服务层
 * @author WZY
 */
@Service
public class SearchConfigService implements ISearchConfigService {
	
	@Autowired
	private ISearchConfigDao searchConfigDao;
	@Autowired
	private ISearchConfigFieldService searchConfigFieldService;

	@Override
	public SearchConfig getById(int id) {
		return searchConfigDao.getById(id);
	}

	@Override
	public List<SearchConfig> getList(Query query) {
		return searchConfigDao.getList(query);
	}

	@Override
	public List<SearchConfig> getList() {
		return searchConfigDao.getList();
	}

	@Override
	public int deleteById(int id) throws Exception {
		return searchConfigDao.deleteById(id);
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
	public int add(SearchConfig entity) throws Exception {
		//校验
		if (StringUtility.isNullOrEmpty(entity.getCode())) {
			throw new Exception("编码不能为空");
		}
		entity.setStatus(BaseStatusEnum.VALID);
		searchConfigDao.add(entity);
		return entity.getId();
	}

	@Override
	public int edit(SearchConfig entity) throws Exception {
		//校验
		if (StringUtility.isNullOrEmpty(entity.getCode())) {
			throw new Exception("编码不能为空");
		}
		SearchConfig dbEntity = searchConfigDao.getById(entity.getId());
		if (dbEntity == null) {
			throw new Exception("实体不存在");
		}
		dbEntity.setCode(entity.getCode());
		dbEntity.setDescription(entity.getDescription());
		dbEntity.setStatus(entity.getStatus());
		dbEntity.setRemark(entity.getRemark());
		return searchConfigDao.edit(dbEntity);
	}

	@Override
	public int editSelective(SearchConfig entity) throws Exception {
		return searchConfigDao.editSelective(entity);
	}

	public SearchConfig getByIdWithChildren(int id) {
		SearchConfig entity = searchConfigDao.getById(id);
		if (entity != null) {
			entity.setFields(searchConfigFieldService.getBySearchConfigId(id));
		}
		return entity;
	}

	public SearchConfig getByCode(String code) {
		if (!StringUtility.isNullOrEmpty(code)) {
			Query query = new Query();
			query.addQueryFilter("code", OperatorEnum.EQUALS, code);
			List<SearchConfig> list = getList(query);
			if (list != null && !list.isEmpty())
				return list.get(0);
		}
		return null;
	}

	public SearchConfig getByCodeWithChildren(String code) {
		SearchConfig entity = getByCode(code);
		if (entity != null) {
			entity.setFields(searchConfigFieldService.getBySearchConfigId(entity.getId()));
		}
		return entity;
	}
}
