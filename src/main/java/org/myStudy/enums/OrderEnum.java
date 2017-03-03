package org.myStudy.enums;

/**
 * sql排序方式 0-升序 1-降序
 * @author WZY
 */
public enum OrderEnum implements IEnum {
	ASC(0, "升序"), DESC(1, "降序");

	private int vlaue;
	private String description;

	private OrderEnum(int vlaue, String description) {
		this.vlaue = vlaue;
		this.description = description;
	}

	public int getValue() {
		return vlaue;
	}

	public String getDescription() {
		return description;
	}
	
	public static OrderEnum stateOf(int index) {
		for (OrderEnum item : values()) {
			if (item.getValue() == index) {
				return item;
			}
		}
		return null;
	}
}
