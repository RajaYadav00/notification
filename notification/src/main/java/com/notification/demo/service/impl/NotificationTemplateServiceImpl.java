package com.notification.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
		
		
		notificationTemp.setNotificationType(NotificationTypeConst.valueOf(notificationTemp.getNotificationType().toUpperCase()).getGetMessage());
		notificationTemp.setType(NotificationTypeConst.valueOf(notificationTemp.getType().toUpperCase()).getGetMessage());
		
		iNotificationTemplateRepo.save(notificationTemp);
		
		
		
		return SuccessResponseModel.builder().messsage("Template is successfully added to the system")		 													.templateId(notificationTemp.getId()).status(HttpStatus.OK.value()).build();
	}
	
	public NotificationTemplate getTemplate(Integer id)
	{
		return iNotificationTemplateRepo.getTemplateById(id);
	}

}
