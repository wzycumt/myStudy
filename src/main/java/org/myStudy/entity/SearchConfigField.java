package org.myStudy.entity;

import org.myStudy.enums.FieldTypeEnum;

/**
 * 查询配置字段实体
 * @author WZY
 */
public class SearchConfigField extends BaseEntity {

	private int searchConfigId;
	private String displayName;
	private String fieldName;
	private FieldTypeEnum fieldType;
	private String fieldReference;
	private boolean isDefault;
	private int orderNum;

	public int getSearchConfigId() {
		return searchConfigId;
	}

	public void setSearchConfigId(int searchConfigId) {
		this.searchConfigId = searchConfigId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public FieldTypeEnum getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldTypeEnum fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldReference() {
		return fieldReference;
	}

	public void setFieldReference(String fieldReference) {
		this.fieldReference = fieldReference;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

}