package com.notification.demo.service.impl;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.notification.demo.exception.NotificationTemplateError;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.repository.INotificationTemplateRepository;
import com.notification.demo.service.INotificationTemplateService;
@Service
@Validated
public class NotificationTemplateServiceImpl implements INotificationTemplateService {
	@Autowired
	INotificationTemplateRepository iNotificationTemplateRepo;
	
	@Override
	public SuccessResponseModel saveNotificationTemplate(@Valid NotificationTemplate notificationTemp) {
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
