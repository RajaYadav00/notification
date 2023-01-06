package com.notification.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.google.gson.Gson;
import com.notification.demo.exception.NotificationTemplateError;
import com.notification.demo.model.NotificationTemplateModel;
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
	public SuccessResponseModel saveNotificationTemplate(NotificationTemplateModel notificationTemp) {
		try {
			iNotificationTemplateRepo.save(notificationTemp);
		} catch (Exception e) {
			throw new NotificationTemplateError(e.getCause().getMessage());
		}
		return SuccessResponseModel.builder().message("Template is successfully added to the system")
				.messageTypeId(notificationTemp.getId()).statusCode(HttpStatus.OK.value()).build();
	}

	/**
	 * this method is used to find list of all the template from database
	 */
	@Override
	public SuccessResponseModel getAllNotificationTemplateFromDatabase() {

		List<NotificationTemplateModel> templates = iNotificationTemplateRepo.findAll();

		String response = gson.toJson(templates);

		return SuccessResponseModel.builder().message(":List of templates :".concat(response))
				.messageTypeId(null).statusCode(HttpStatus.OK.value()).build();

	}

	/**
	 * This method is used to replace the existing notificationTemplate with new one
	 */
	@Override
	public SuccessResponseModel replaceNotificationTemplate(Integer id, NotificationTemplateModel notificationTemplate) {

		Optional<NotificationTemplateModel> opttemplate = iNotificationTemplateRepo.findById(id);
		if (opttemplate.isPresent()) {
			iNotificationTemplateRepo.save(notificationTemplate);
		} else {
			throw new NotificationTemplateError("template not found having id :" + id);
		}

		return SuccessResponseModel.builder().message("Template is successfully changed").messageTypeId(null)
				.statusCode(HttpStatus.OK.value()).build();
	}

	@Override
	public SuccessResponseModel deleteNotificationTemplate(Integer id) {
		
		iNotificationTemplateRepo.deleteById(id);
		return SuccessResponseModel.builder().message("Template is successfully changed").messageTypeId(null)
				.statusCode(HttpStatus.OK.value()).build();
	}

	/**
	 * this method is used to find the template from database with help of id
	 * 
	 * @param id it is the Id of template to be find
	 * @return it returns the Notification Template
	 */
	public NotificationTemplateModel getTemplate(Integer id) {
		Optional<NotificationTemplateModel> opt = iNotificationTemplateRepo.findById(id);
		if (!opt.isPresent()) {
			throw new NotificationTemplateError("Notification template is not present having Id :" + id);
		}
		return opt.get();
	}

}
