package com.notification.demo.model.common;

import lombok.Getter;

@Getter
public enum NotificationType {
 
	EMAIL("email"),
	SMS("sms"),
	WHATSAPP("whatsapp"),
	INAPP("inapp");
	
	private String getMessage;
	
	private NotificationType(String msg) {
		this.getMessage=msg;
	}
	

}
