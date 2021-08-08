package edu.sabanciuniv.it592api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectError {

	private int status;
	private String message;
	private long timeStamp;
	
	public ProjectError() {	}

	public ProjectError(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	
	
}
