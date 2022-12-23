package com.notification.demo.model.common;

import lombok.Getter;

@Getter
public enum NotificationTypeConst {
 
	EMAIL("email"),
	SMS("sms"),
	WHATSAPP("whatsapp"),
	INAPP("inapp"),
	CUSTOMIZED("customized");
	
	
	private String getMessage;
	
	private NotificationTypeConst(String msg) {
		this.getMessage=msg;
	}
	

}
