package com.notification.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.notification.demo.exception.NotificationTemplateError;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.NotificationTypeConst;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.repository.INotificationTemplateRepository;
import com.notification.demo.service.INotificationTemplateService;

@Service
public class NotificationTemplateServiceImpl implements INotificationTemplateService {

	@Autowired
	INotificationTemplateRepository iNotificationTemplateRepo;
	
	@Override
	public SuccessResponseModel saveNotificationTemplate(NotificationTemplate notificationTemp) {
		
		System.out.println(notificationTemp.getNotificationType());
		
		notificationTemp.setNotificationType(NotificationTypeConst.valueOf(notificationTemp.getNotificationType().toUpperCase()).getGetMessage());
		notificationTemp.setType(NotificationTypeConst.valueOf(notificationTemp.getType().toUpperCase()).getGetMessage());
		
		
		NotificationTemplate savedTemplate=iNotificationTemplateRepo.save(notificationTemp);
		
		if(savedTemplate==null) {
			throw new NotificationTemplateError("Notification template is not saved");
		}
		
		
		return SuccessResponseModel.builder().messsage("Template is successfully added to the system")
				 													.templateId(notificationTemp.getId()).status(HttpStatus.OK.value()).build();
	}

}
