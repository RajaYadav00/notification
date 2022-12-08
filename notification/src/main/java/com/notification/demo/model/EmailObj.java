package com.notification.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class EmailObj {
	
	private String otp;
	private String otpid;

}