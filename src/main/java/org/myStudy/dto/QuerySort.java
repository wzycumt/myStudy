package org.myStudy.dto;

import org.myStudy.enums.IEnum;
import org.myStudy.utility.StringUtility;

/**
 * 排序类
 * @author WZY
 */
public class QuerySort {

	private String columnName;
	private SortOrderEnum sortOrder;

	public QuerySort() {
		
	}

	public QuerySort(String columnName, SortOrderEnum sortOrder) {
		if (columnName.contains("_"))
			this.columnName = columnName;
		else
			this.columnName = StringUtility.toUnderscoreName(columnName);
		this.sortOrder = sortOrder;
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

	public SortOrderEnum getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrderEnum sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * 运算符枚举
	 * @author WZY
	 */
	public enum SortOrderEnum implements IEnum {
		ASC(0, "升序"),
		DESC(1, "降序");

		private int vlaue;
		private String description;

		private SortOrderEnum(int vlaue, String description) {
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
