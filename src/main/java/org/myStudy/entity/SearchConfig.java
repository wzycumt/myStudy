package org.myStudy.entity;

import java.util.List;

import org.myStudy.enums.BaseStatusEnum;

/**
 * 查询配置实体
 * @author WZY
 */
public class SearchConfig extends BaseEntity {

	private String code;
	private String description;
	private BaseStatusEnum status;
	private String remark;
	
	private List<SearchConfigField> fields;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BaseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(BaseStatusEnum status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	//扩展
	public String getStatusDes() {
		return getStatus().getDescription();
	}

	public List<SearchConfigField> getFields() {
		return fields;
	}

	public void setFields(List<SearchConfigField> fields) {
		this.fields = fields;
	}

}
