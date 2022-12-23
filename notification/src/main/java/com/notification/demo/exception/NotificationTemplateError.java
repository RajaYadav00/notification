package com.notification.demo.exception;

import lombok.Getter;

@Getter
public class NotificationTemplateError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotificationTemplateError(String message) {
		super(message);
	}

}
