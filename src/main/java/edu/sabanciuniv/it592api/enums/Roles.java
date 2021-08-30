package edu.sabanciuniv.it592api.enums;

public enum Roles {
	NONE(0),
	ELECTRIC(1),
	MECHANIC(2),
	MANAGER(3),
	OTHER(4);
	
	private final int code;
	
	private Roles(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}
