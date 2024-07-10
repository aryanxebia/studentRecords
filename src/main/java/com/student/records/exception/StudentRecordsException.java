package com.student.records.exception;

import org.springframework.http.HttpStatus;

public class StudentRecordsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8686366681733975821L;

	private HttpStatus httpStatus;
	private String message;

	public StudentRecordsException(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
