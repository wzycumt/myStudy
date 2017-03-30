package org.myStudy.dto;

import org.myStudy.enums.IEnum;
import org.myStudy.utility.StringUtility;

/**
 * 查询条件过滤类
 * @author WZY
 */
public class QueryFilter {

	private String columnName;
	private OperatorEnum operator;
	private Object value;

	public QueryFilter() {
		
	}

	public QueryFilter(String columnName, OperatorEnum operator, Object value) {
		if (columnName.contains("_"))
			this.columnName = columnName;
		else
			this.columnName = StringUtility.toUnderscoreName(columnName);
		this.operator = operator;
		this.value = value;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		if (columnName.contains("_"))
			this.columnName = columnName;
		else
			this.columnName = StringUtility.toUnderscoreName(columnName);
	}

	public OperatorEnum getOperator() {
		return operator;
	}

	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "QueryFilter [columnName=" + columnName + ", operator=" + operator + ", value=" + value + "]";
	}

	/**
	 * 运算符枚举
	 * @author WZY
	 */
	public enum OperatorEnum implements IEnum {
		LIKE(0, "like"),
		EQUALS(1, "="),
		UNEQUAL(2, "<>"),
		LESS_THAN(3, "<"),
		LESS_THAN_OR_EQUAL(4, "<="),
		GREATER_THAN(5,">"),
		GREATER_THAN_OR_EQUAL(6, ">="),
		IN(7, "in"),
		NOT_IN(8, "not in"),
		IS_NULL(9, "is null"),
		IS_NOT_NULL(10, "is not null");

		private int vlaue;
		private String description;

		private OperatorEnum(int vlaue, String description) {
			this.vlaue = vlaue;
			this.description = description;
		}

		public int getValue() {
			return vlaue;
		}

		public String getDescription() {
			return description;
		}
	}
}
