package com.notification.demo.service;

import com.notification.demo.model.SmsWhatsappModel;
import com.notification.demo.model.common.SuccessResponseModel;

public interface IWhatsAppService {

	/**
	 * 
	 * @param whatsapp this variable holds the details of whatsapp message and how to send
	 * @return it return the success response if message is send successfully
	 */
	public SuccessResponseModel sendWhatsAppNotification(SmsWhatsappModel whatsapp);

}
