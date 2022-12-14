package com.notification.demo.service;

import com.notification.demo.model.SmsModule;
import com.notification.demo.model.common.SuccessResponseModel;

public interface ISmsService {
	
	public SuccessResponseModel sendSms(SmsModule sms);

}
