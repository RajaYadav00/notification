package com.notification.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.google.gson.Gson;
import com.notification.demo.exception.NotificationTemplateError;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.repository.INotificationTemplateRepository;
import com.notification.demo.service.INotificationTemplateService;

@Service
@Validated
public class NotificationTemplateServiceImpl implements INotificationTemplateService {

	// This is use to serialize JSON object to java object an vice-versa
	@Autowired
	Gson gson;

	@Autowired
	INotificationTemplateRepository iNotificationTemplateRepo;

	/**
	 * This constructor is used for Unit testing
	 * 
	 * @param iNotificationTemplateRepo2 This will get from unit testing class to
	 *                                   initialize the iNotificationTemplateRepo
	 */
	public NotificationTemplateServiceImpl(INotificationTemplateRepository iNotificationTemplateRepo2) {
		this.iNotificationTemplateRepo = iNotificationTemplateRepo2;
	}

	/**
	 * this method is used to save the template in database
	 */
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

	/**
	 * this method is used to find list of all the template from database
	 */
	@Override
	public SuccessResponseModel getAllTemplateFromDatabase() {

		List<NotificationTemplate> templates = iNotificationTemplateRepo.findAll();

		String response = gson.toJson(templates);

		return SuccessResponseModel.builder().messsage(":List of templates :".concat(response.toString()))
				.templateId(null).status(HttpStatus.OK.value()).build();

	}

	/**
	 * This method is used to replace the existing notificationTemplate with new one
	 */
	@Override
	public SuccessResponseModel replaceTemplate(Integer id, NotificationTemplate notificationTemplate) {

		Optional<NotificationTemplate> opttemplate = iNotificationTemplateRepo.findById(id);
		if (opttemplate.isPresent()) {
			iNotificationTemplateRepo.save(notificationTemplate);
		} else {
			throw new NotificationTemplateError("template not found having id :" + id);
		}

		return SuccessResponseModel.builder().messsage("Template is successfully changed").templateId(null)
				.status(HttpStatus.OK.value()).build();
	}

	/**
	 * this method is used to find the template from database with help of id
	 * 
	 * @param id it is the Id of template to be find
	 * @return it returns the Notification Template
	 */
	public NotificationTemplate getTemplate(Integer id) {
		Optional<NotificationTemplate> opt = iNotificationTemplateRepo.findById(id);
		if (!opt.isPresent()) {
			throw new NotificationTemplateError("Notification template is not present having Id :" + id);
		}
		return opt.get();
	}

}
