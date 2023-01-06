package com.notification.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.notification.demo.config.TwilioConfig;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.SmsWhatsappModule;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.IWhatsAppService;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class WhatsAppService implements IWhatsAppService {

	@Autowired
	NotificationTemplateServiceImpl notificationTemplateServiceImpl;
	@Autowired
	TwilioConfig tConfig;

	@Override
	public SuccessResponseModel sendWhatsAppNotification(SmsWhatsappModule whatsapp) {

		NotificationTemplate template = notificationTemplateServiceImpl
				.getTemplate(whatsapp.getNotificationTemplateId());
		whatsapp.getNotifyTo().forEach(user -> {

			String msg = template.getMessageBody().replace("{{#cusname}}", user.getName());

			 Message.creator(new com.twilio.type.PhoneNumber("whatsapp:" + tConfig.getTrialNumber()),
					new com.twilio.type.PhoneNumber("whatsapp:" + user.getPhone()), msg).create();
		});

		return SuccessResponseModel.builder().status(HttpStatus.ACCEPTED.value())
				.messsage("The whatsApp-notification is generated").templateId(whatsapp.getNotificationTemplateId())
				.build();
	}

}
