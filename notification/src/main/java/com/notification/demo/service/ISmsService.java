package com.notification.demo.service;

import com.notification.demo.model.SmsWhatsappModule;
import com.notification.demo.model.common.SuccessResponseModel;

public interface ISmsService {

	public SuccessResponseModel sendSms(SmsWhatsappModule sms);

}