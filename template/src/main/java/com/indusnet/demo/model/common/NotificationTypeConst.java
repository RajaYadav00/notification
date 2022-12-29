package com.indusnet.demo.model.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum NotificationTypeConst {

	EMAIL("email"), SMS("sms"), WHATSAPP("whatsapp"), INAPP("inapp"), CUSTOMIZED("customized");

	private String getMessage;

	private NotificationTypeConst(String msg) {
		this.getMessage = msg;
	}

}
