package org.myStudy.dto;

import java.util.ArrayList;
import java.util.List;

import org.myStudy.enums.IEnum;

/**
 * SQL查询过滤、排序组合类
 * @author WZY
 */
public class Query {

	private List<QueryFilter> queryFilters;
	private List<SortColumn> sortColumns;

	private boolean isPaged; //是否分页
	private int offset;
	private int limit;

	public List<QueryFilter> getQueryFilters() {
		return queryFilters;
	}

	public void setQueryFilters(List<QueryFilter> queryFilters) {
		this.queryFilters = queryFilters;
	}

	public List<SortColumn> getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(List<SortColumn> sortColumns) {
		this.sortColumns = sortColumns;
	}

	/**
	 * 是否分页
	 * @return
	 */
	public boolean isPaged() {
		return isPaged;
	}

	public void setPaged(boolean isPaged) {
		this.isPaged = isPaged;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void addQueryFilter(String columnName, OperatorEnum operator, Object value) {
		if (queryFilters == null)
			queryFilters = new ArrayList<QueryFilter>();
		queryFilters.add(new QueryFilter(columnName, operator, value));
	}

	public void addSortColumn(String columnName, boolean isDescend) {
		if (sortColumns == null)
			sortColumns = new ArrayList<SortColumn>();
		sortColumns.add(new SortColumn(columnName, isDescend));
	}

	/**
	 * 查询条件过滤类
	 * @author WZY
	 */
	public class QueryFilter {

		private String columnName;
		private OperatorEnum operator;
		private Object value;

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
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

		public QueryFilter(String columnName, OperatorEnum operator, Object value) {
			this.columnName = columnName;
			this.operator = operator;
			this.value = value;
		}
	}

	/**
	 * 排序类
	 * @author WZY
	 */
	public class SortColumn {

		private String columnName;
		private boolean isDescend;

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public boolean isDescend() {
			return isDescend;
		}

		public void setDescend(boolean isDescend) {
			this.isDescend = isDescend;
		}

		public SortColumn(String columnName, boolean isDescend) {
			this.columnName = columnName;
			this.isDescend = isDescend;
		}
	}

	/**
	 * 运算符枚举
	 * @author WZY
	 */
	public enum OperatorEnum implements IEnum {
		LIKE(0, "like"),
		EQUAL(1, "="),
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
