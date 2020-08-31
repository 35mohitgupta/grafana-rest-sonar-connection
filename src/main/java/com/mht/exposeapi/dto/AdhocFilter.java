package com.mht.exposeapi.dto;

public class AdhocFilter {

	private String key;
	private String operator;
	private Object value;
	private String condition;
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
