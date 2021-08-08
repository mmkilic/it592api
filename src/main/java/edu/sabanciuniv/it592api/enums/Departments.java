package edu.sabanciuniv.it592api.enums;

public enum Departments {
	NONE(0),
	ENGINEERING(1),
	TENDERING(2),
	PROJECT(3),
	OTHER(4);
	
	private final int code;
	
	private Departments(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}
