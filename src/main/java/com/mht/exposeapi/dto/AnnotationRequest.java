package com.mht.exposeapi.dto;

public class AnnotationRequest {

	private Range range;
	private RangeRaw rangeRaw;
	private Annotation annotation;
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
	public Annotation getAnnotation() {
		return annotation;
	}
	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result + ((rangeRaw == null) ? 0 : rangeRaw.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnotationRequest other = (AnnotationRequest) obj;
		if (annotation == null) {
			if (other.annotation != null)
				return false;
		} else if (!annotation.equals(other.annotation))
			return false;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		if (rangeRaw == null) {
			if (other.rangeRaw != null)
				return false;
		} else if (!rangeRaw.equals(other.rangeRaw))
			return false;
		return true;
	}
	
}
