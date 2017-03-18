package org.myStudy.enums;

/**
 * 字段类型枚举
 * @author WZY
 */
public enum FieldTypeEnum implements IEnum {
	VARCHAR(0, "文本"),
	NUMBER(1, "数字"),
	BOOLEAN(2, "布尔"),
	DATETIME(3, "日期"),
	ENUMERATION(4, "枚举"),
	DICTIONARY(5, "字典");

	private int vlaue;
	private String description;

	private FieldTypeEnum(int vlaue, String description) {
		this.vlaue = vlaue;
		this.description = description;
	}

	public int getValue() {
		return vlaue;
	}

	public String getDescription() {
		return description;
	}
	
	public static FieldTypeEnum stateOf(int index) {
		for (FieldTypeEnum item : values()) {
			if (item.getValue() == index) {
				return item;
			}
		}
		return null;
	}

}
