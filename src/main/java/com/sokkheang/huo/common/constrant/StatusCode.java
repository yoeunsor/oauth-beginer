package com.sokkheang.huo.common.constrant;

public enum StatusCode {

	Active	("1","Active"),
	Deavtive("2","Deactive"),
	Block	("3","Block"),
	Timeout	("4","Timeout");
	
	private final String value;
	private final String description;
	
	private StatusCode(String value, String description) {
		this.value = value;
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	
}
