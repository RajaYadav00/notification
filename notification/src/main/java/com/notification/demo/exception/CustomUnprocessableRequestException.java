package com.notification.demo.exception;

public class CustomUnprocessableRequestException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomUnprocessableRequestException(String message) {
	        super(message);
	    }
}
