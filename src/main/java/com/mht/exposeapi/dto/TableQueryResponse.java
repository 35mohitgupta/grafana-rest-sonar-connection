package com.mht.exposeapi.dto;

import java.util.List;

public class TableQueryResponse {

	private List<TableColumn> columns;
	private List<TableRow> rows;
	@Override
	public String toString() {
		return "TableQueryResponse [columns=" + columns + ", rows=" + rows + "]";
	}
	public List<TableColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<TableColumn> columns) {
		this.columns = columns;
	}
	public List<TableRow> getRows() {
		return rows;
	}
	public void setRows(List<TableRow> rows) {
		this.rows = rows;
	}
}
