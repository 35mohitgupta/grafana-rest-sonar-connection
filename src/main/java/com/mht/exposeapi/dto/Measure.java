package com.mht.exposeapi.dto;

import java.util.List;

public class Measure {

	private String metric;
	private List<MeasureHistory> history;
	public String getMetric() {
		return metric;
	}
	public void setMetric(String metric) {
		this.metric = metric;
	}
	public List<MeasureHistory> getHistory() {
		return history;
	}
	public void setHistory(List<MeasureHistory> history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "Measure [metric=" + metric + ", history=" + history + "]";
	}
	
}
