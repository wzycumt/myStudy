package org.myStudy.enums;

public enum OrderEnum {
	ASC(0, "升序"),
	DESC(1, "降序");
	
	private int order;
	private String orderDes;
	
	private OrderEnum(int order, String orderDes) {
		this.order = order;
		this.orderDes = orderDes;
	}

	public int getOrder() {
		return order;
	}

	public String getOrderDes() {
		return orderDes;
	}

	public static OrderEnum stateOf(int index) {
		for (OrderEnum order : values()) {
			if (order.getOrder() == index) {
				return order;
			}
		}
		return null;
	}
}
