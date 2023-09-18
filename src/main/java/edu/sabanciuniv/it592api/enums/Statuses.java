package edu.sabanciuniv.it592api.enums;

public enum Statuses {
	NONE(0),
	ACTIVE(1),
	ONTIME(2),
	DELAY(3),
	CANCELED(4);
	
	private final int code;
	
	private Statuses(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}
