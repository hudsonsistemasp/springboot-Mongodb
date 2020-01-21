package com.mongdb.mongodbTest.resource.exceptions;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.http.HttpStatus;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Instant timeStamp;
	private HttpStatus status;
	private String errorException;
	private String message;
	private String path;

	public StandardError() {
	}

	public StandardError(Instant timeStamp, HttpStatus status, String errorException, String message, String path) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.errorException = errorException;
		this.message = message;
		this.path = path;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}


	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrorException() {
		return errorException;
	}

	public void setErrorException(String errorException) {
		this.errorException = errorException;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
