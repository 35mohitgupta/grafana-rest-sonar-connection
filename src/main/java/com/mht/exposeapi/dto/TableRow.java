package com.mht.exposeapi.dto;

import java.util.List;

public class TableRow {
	private List<Object> rowData;

	public List<Object> getRowData() {
		return rowData;
	}

	public void setRowData(List<Object> rowData) {
		this.rowData = rowData;
	}

	@Override
	public String toString() {
		return "TableRow [rowData=" + rowData + "]";
	}
	
}
