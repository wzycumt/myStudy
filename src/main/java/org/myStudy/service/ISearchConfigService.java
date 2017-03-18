package org.myStudy.service;

import org.myStudy.entity.SearchConfig;

public interface ISearchConfigService extends IBaseService<SearchConfig> {

	/**
	 * 根据ID获取查询配置及字段信息
	 * @param id
	 * @return
	 */
	SearchConfig getByIdWithChildren(int id);

	/**
	 * 根据编码获取查询配置
	 * @param id
	 * @return
	 */
	SearchConfig getByCode(String code);

	/**
	 * 根据编码获取查询配置及字段信息
	 * @param id
	 * @return
	 */
	SearchConfig getByCodeWithChildren(String code);

}
