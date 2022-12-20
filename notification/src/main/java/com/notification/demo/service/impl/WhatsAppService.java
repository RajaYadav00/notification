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
		
		NotificationTemplate template = notificationTemplateServiceImpl.getTemplate(whatsapp.getNotificationTemplateId());
		whatsapp.getNotifyTo().forEach(user -> {
			
			String msg = template.getMessageBody().replace("{{#cusname}}", user.getName());
			
			System.out.println(tConfig.getTrialNumber());
			Message message=Message.creator(
					new com.twilio.type.PhoneNumber("whatsapp:"+tConfig.getTrialNumber()),
					new com.twilio.type.PhoneNumber("whatsapp:"+user.getPhone()),
					"Backup plan").create();
			System.out.println(tConfig.getTrialNumber());
			
//	        Message message = Message.creator( 
//	        new com.twilio.type.PhoneNumber("whatsapp:+918299262502"), 
//	        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
//	        "Hello! This is an editable text message. You are free to change it and write whatever you like.")      
//	    .create();
			
//			Message message1=Message.creator(new PhoneNumber("whatsapp: +918299262502"),new PhoneNumber("whatsapp:+14155238886"), "Backup plan").create();
			
			

		});
		
		
		
		return SuccessResponseModel.builder().status(HttpStatus.ACCEPTED.value())
				.messsage("The whatsApp-notification is generated").templateId(whatsapp.getNotificationTemplateId()).build();
	}

}
