package com.indusnet.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.indusnet.demo.exception.NotificationTemplateError;
import com.indusnet.demo.model.NotificationTemplate;
import com.indusnet.demo.model.common.SuccessResponseModel;
import com.indusnet.demo.repository.INotificationTemplateRepository;
import com.indusnet.demo.service.INotificationTemplateService;

@Service
public class NotificationTemplateServiceImpl implements INotificationTemplateService {

	@Autowired
	INotificationTemplateRepository iNotificationTemplateRepo;

	@Override
	public SuccessResponseModel saveNotificationTemplate(NotificationTemplate notificationTemp) {

		try {
			iNotificationTemplateRepo.save(notificationTemp);
		} catch (Exception e) {
			throw new NotificationTemplateError(e.getCause().getMessage());
		}

		return SuccessResponseModel.builder().messsage("Template is successfully added to the system")
				.templateId(notificationTemp.getId()).status(HttpStatus.OK.value()).build();
	}

	public NotificationTemplate getTemplate(Integer id) {
		Optional<NotificationTemplate> opt = iNotificationTemplateRepo.findById(id);
		if (!opt.isPresent()) {
			throw new NotificationTemplateError("Notification template is not present having Id :" + id);
		}
		return opt.get();
	}
}
