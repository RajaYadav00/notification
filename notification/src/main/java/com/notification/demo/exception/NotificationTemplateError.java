package com.notification.demo.exception;

import lombok.Getter;

@Getter
public class NotificationTemplateError extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String path;

	public NotificationTemplateError(String message) {
		super(message);
	}
	
	public NotificationTemplateError(String message,String path) {
		super(message);
		this.path=path;
	}

	
}
