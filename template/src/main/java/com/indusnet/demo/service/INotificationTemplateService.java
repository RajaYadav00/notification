package com.indusnet.demo.service;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.indusnet.demo.model.NotificationTemplate;
import com.indusnet.demo.model.common.SuccessResponseModel;

/**
 * this interface have following methods
 * 
 * @author Raja Ram Yadav
 */
@Validated
public interface INotificationTemplateService {
	
	/**
	 * @param notificationTemp it hold the details of notification template
	 * @return  it return the success response if template is saved successfully
	 */
	public SuccessResponseModel saveNotificationTemplate(@Valid NotificationTemplate notificationTemp);

}
