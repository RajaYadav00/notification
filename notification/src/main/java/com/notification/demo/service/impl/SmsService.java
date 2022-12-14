package com.notification.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.notification.demo.config.TwilioConfig;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.SmsModule;
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

	@Override
	public SuccessResponseModel sendSms(SmsModule sms) {

		NotificationTemplate template = notificationTemplateServiceImpl.getTemplate(sms.getNotificationTemplateId());
		String msg = template.getMessageBody();

		sms.getNotifyTo().forEach(user -> {

			Message message = Message
					.creator(new PhoneNumber(user.getPhone()), new PhoneNumber(tConfig.getTrialNumber()), "happy birthDay").create();

		});

		return SuccessResponseModel.builder().status(HttpStatus.ACCEPTED.value())
				.messsage("The Sms-notification is generated").templateId(sms.getNotificationTemplateId()).build();
	}

}
