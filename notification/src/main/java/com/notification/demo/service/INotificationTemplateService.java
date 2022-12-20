package com.notification.demo.service;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.SuccessResponseModel;
@Validated
public interface INotificationTemplateService {
	public SuccessResponseModel saveNotificationTemplate(@Valid NotificationTemplate notificationTemp);

}
