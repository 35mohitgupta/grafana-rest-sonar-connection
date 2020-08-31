package com.mht.exposeapi.dto;

import java.util.List;

public class QueryRequest {

	private Integer planId;
	private Range range;
	private RangeRaw rangeRaw;
	private String interval;
	private Long intervalMs;
	private String format;
	private Integer maxDataPoints;
	private List<Target> targets;
	private List<AdhocFilter> adhocFilters;
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public Range getRange() {
		return range;
	}
	public void setRange(Range range) {
		this.range = range;
	}
	public RangeRaw getRangeRaw() {
		return rangeRaw;
	}
	public void setRangeRaw(RangeRaw rangeRaw) {
		this.rangeRaw = rangeRaw;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public Long getIntervalMs() {
		return intervalMs;
	}
	public void setIntervalMs(Long intervalMs) {
		this.intervalMs = intervalMs;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Integer getMaxDataPoints() {
		return maxDataPoints;
	}
	public void setMaxDataPoints(Integer maxDataPoints) {
		this.maxDataPoints = maxDataPoints;
	}
	public List<Target> getTargets() {
		return targets;
	}
	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
	public List<AdhocFilter> getAdhocFilters() {
		return adhocFilters;
	}
	public void setAdhocFilters(List<AdhocFilter> adhocFilters) {
		this.adhocFilters = adhocFilters;
	}
	
}
