package com.notification.demo.service;

import com.notification.demo.model.common.SmsPojo;

public interface ISmsService {
	
	public void sendSms(SmsPojo sms ,String responseOtp);

}
