package edu.sabanciuniv.it592api.enums;

public enum Roles {
	NONE(0),
	DESIGNER(1),
	MANAGER(2),
	OTHER(3);
	
	private final int code;
	
	private Roles(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}
