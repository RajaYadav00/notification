package com.notification.demo.exception;

import lombok.Getter;

@Getter
public class EmailException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	private String path;

	public EmailException(String msg) {
		super(msg);
		
	}
	
	public EmailException(String message,String path) {
		super(message);
		this.path=path;
		
	}
}
