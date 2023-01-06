package com.notification.demo.service;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.notification.demo.model.SmsWhatsappModule;
import com.notification.demo.model.common.SuccessResponseModel;
/**
 * This interface is uses for SMS service
 * @author Raja Ram Yadav
 *
 */
@Validated
public interface ISmsService {
	

	/**
	 * 
	 * @param sms This variable hold the details of sms 
	 * @return it will return the success response with message
	 */
	public SuccessResponseModel sendSms(@Valid SmsWhatsappModule sms);

}
