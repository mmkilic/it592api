package edu.sabanciuniv.it592api.exception;

public class ProjectNotFoundException extends RuntimeException{

	public ProjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectNotFoundException(String message) {
		super(message);
	}

	public ProjectNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
}
