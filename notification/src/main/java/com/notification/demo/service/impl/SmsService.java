package com.notification.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.notification.demo.config.TwilioConfig;
import com.notification.demo.model.NotificationTemplateModel;
import com.notification.demo.model.SmsWhatsappModel;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.ISmsService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService implements ISmsService {
	
	@Autowired
	NotificationTemplateServiceImpl notificationTemplateServiceImpl;
	
	@Autowired
	TwilioConfig tConfig;
	
	/**
	 * In this method the logic of how to send sms using twilio is written.
	 * and this method returns the success response with the message
	 */
	@Override
	public SuccessResponseModel sendSms(SmsWhatsappModel sms) {
		NotificationTemplateModel template = notificationTemplateServiceImpl.getTemplate(sms.getNotificationTemplateId());

		sms.getNotifyTo().forEach(user -> {
			String msg = template.getMessageBody().replace("{{#cusname}}", user.getName());
			Message.creator(new PhoneNumber(user.getPhone()), new PhoneNumber(tConfig.getTrialNumber()), msg).create();

		});
		return SuccessResponseModel.builder().statusCode(HttpStatus.ACCEPTED.value())
				.message("The Sms-notification is generated").messageTypeId(sms.getNotificationTemplateId()).build();
	}

}
