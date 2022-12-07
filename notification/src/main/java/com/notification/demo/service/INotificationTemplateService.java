package com.notification.demo.service;


import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.SuccessResponseModel;


public interface INotificationTemplateService {
	
	public SuccessResponseModel saveNotificationTemplate(NotificationTemplate notificationTemp);

}
