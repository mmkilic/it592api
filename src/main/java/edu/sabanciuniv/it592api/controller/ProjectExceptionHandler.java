package edu.sabanciuniv.it592api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.sabanciuniv.it592api.entity.ProjectError;
import edu.sabanciuniv.it592api.exception.ProjectNotFoundException;

@ControllerAdvice
public class ProjectExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ProjectError> handleException(ProjectNotFoundException exc){
		
		ProjectError err = new ProjectError();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(exc.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ProjectError>(err, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ProjectError> handleException(Exception exc){
		
		ProjectError err = new ProjectError();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(exc.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ProjectError>(err, HttpStatus.BAD_REQUEST);
	}
	
}
