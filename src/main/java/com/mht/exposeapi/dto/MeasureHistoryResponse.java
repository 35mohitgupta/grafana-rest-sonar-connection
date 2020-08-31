package com.mht.exposeapi.dto;

import java.util.List;

import org.json.JSONObject;

public class MeasureHistoryResponse {

//	private JSONObject paging;
	private List<Measure> measures;

	@Override
	public String toString() {
		return "MeasureHistoryResponse [measures=" + measures + "]";
	}

	public List<Measure> getMeasures() {
		return measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	} 
	
}
