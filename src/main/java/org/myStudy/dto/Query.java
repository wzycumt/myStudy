package org.myStudy.dto;

import java.util.ArrayList;
import java.util.List;

import org.myStudy.dto.QueryFilter.OperatorEnum;
import org.myStudy.dto.QuerySort.SortOrderEnum;
import org.myStudy.enums.IEnum;

/**
 * SQL查询过滤、排序组合类
 * @author WZY
 */
public class Query {

	private List<QueryFilter> queryFilters;
	private List<QuerySort> sortColumns;

//	private SidePaginationEnum sidePagination; //分页方式：server-服务器端分页，client-客户端分页，其他-不分页
	private boolean paged;
	private int pageNumber;
	private int pageSize;
	
	private int total; //分页查询的结果总数

	public List<QueryFilter> getQueryFilters() {
		return queryFilters;
	}

	public void setQueryFilters(List<QueryFilter> queryFilters) {
		this.queryFilters = queryFilters;
	}

	public List<QuerySort> getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(List<QuerySort> sortColumns) {
		this.sortColumns = sortColumns;
	}

	public boolean isPaged() {
		return paged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void addQueryFilter(String columnName, OperatorEnum operator, Object value) {
		if (queryFilters == null)
			queryFilters = new ArrayList<QueryFilter>();
		queryFilters.add(new QueryFilter(columnName, operator, value));
	}

	public void addSortColumn(String columnName, SortOrderEnum sortOrder) {
		if (sortColumns == null)
			sortColumns = new ArrayList<QuerySort>();
		sortColumns.add(new QuerySort(columnName, sortOrder));
	}

	/**
	 * 运算符枚举
	 * @author WZY
	 */
	public enum SidePaginationEnum implements IEnum {
		CLIENT(0, "客户端分页"),
		SERVER(1, "服务器端分页");

		private int vlaue;
		private String description;

		private SidePaginationEnum(int vlaue, String description) {
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
