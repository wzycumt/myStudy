package org.myStudy.dto;

/**
 * 分页查询条件
 * @author WZY
 */
public class PageQuery {

	private int offset;
	private int limit;
	private String sort;
	private String order;
	private String search;

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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	/**
	 * 转为SQL查询过滤、排序组合对象
	 * @return
	 */
	public Query toQuery() {
		Query query = new Query();
		if (sort != null && !sort.isEmpty()) {
			boolean isDescend = "desc".equals(order);
			query.addSortColumn(sort, isDescend);
		}
		if (offset != 0 || limit != 0) {
			query.setPaged(true);
			query.setOffset(offset);
			query.setLimit(limit);
		}
		return query;
	}
}
