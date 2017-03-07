package org.myStudy.dto;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BootstrapTable<T> {
	
	private int total;
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String toJsonString() {
		ObjectMapper json = new ObjectMapper();
		try {
			return json.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}
}
