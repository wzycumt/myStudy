package org.myStudy.enums;

/**
 * 状态枚举 0-无效 1-有效
 * @author WZY
 */
public enum BaseStatusEnum implements IEnum {
	INVALID(0, "无效"), VALID(1, "有效");

	private int vlaue;
	private String description;

	private BaseStatusEnum(int vlaue, String description) {
		this.vlaue = vlaue;
		this.description = description;
	}

	public int getValue() {
		return vlaue;
	}

	public String getDescription() {
		return description;
	}
	
	public static BaseStatusEnum stateOf(int index) {
		for (BaseStatusEnum item : values()) {
			if (item.getValue() == index) {
				return item;
			}
		}
		return null;
	}
}