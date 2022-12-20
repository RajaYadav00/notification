package com.notification.demo.service;

import com.notification.demo.model.SmsWhatsappModule;
import com.notification.demo.model.common.SuccessResponseModel;

public interface IWhatsAppService {
	
	
	public SuccessResponseModel sendWhatsAppNotification(SmsWhatsappModule whatsapp);

}
