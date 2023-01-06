package com.notification.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class EmailPojo {
	
	private String otp;
	
	private String otpid;
}