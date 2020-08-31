package com.mht.exposeapi.dto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MeasureHistory {

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
	private ZonedDateTime date;
	private Double value;
	
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MeasureHistory [date=" + date + ", value=" + value + "]";
	}
	
}
