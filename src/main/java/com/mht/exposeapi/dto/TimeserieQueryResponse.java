package com.mht.exposeapi.dto;

import java.util.List;

public class TimeserieQueryResponse {

	private String target;
	private List<List<Object>> datapoints;
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List<List<Object>> getDatapoints() {
		return datapoints;
	}
	public void setDatapoints(List<List<Object>> datapoints) {
		this.datapoints = datapoints;
	}
	@Override
	public String toString() {
		return "TimeserieQueryResponse [target=" + target + ", datapoints=" + datapoints + "]";
	}
	
}
