package com.notification.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.notification.demo.model.NotificationTemplateModel;
import com.notification.demo.model.common.LoggingResponseModel;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.INotificationTemplateService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v0.0.1/notification/")
@Slf4j
public class NotificationTempController {

	// This is use to serialize JSON object to java object an vice-versa
	@Autowired
	Gson gson;

	@Autowired
	INotificationTemplateService inotificationService;

	/**
	 * This method will take the details of template in String and send it to the
	 * service layer
	 * @param template It has the details of the template which we get when front
	 *                 end
	 * @return it will return the success response if template is saved successfully
	 */
	@PostMapping(value = "/saveNotificationTemplate")
	public ResponseEntity<SuccessResponseModel> saveTemplate(@RequestBody String template) {

		LoggingResponseModel msgStart = LoggingResponseModel.builder().statusCode(HttpStatus.ACCEPTED)
				.message("started at template saving").build();
		log.info(gson.toJson(msgStart));

		SuccessResponseModel response = inotificationService
				.saveNotificationTemplate(gson.fromJson(template, NotificationTemplateModel.class));

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * This method is used to get the list of template stored in the database
	 * 
	 * @return it returns the success response with the list of template
	 */

	@GetMapping(value = "/getListOfNotificationTemplate")
	public ResponseEntity<SuccessResponseModel> getListOfTemplates() {

		LoggingResponseModel msgStart = LoggingResponseModel.builder().message("Started getting list of template saved")
				.build();
		log.info(gson.toJson(msgStart));

		SuccessResponseModel responseTemplate = inotificationService.getAllNotificationTemplateFromDatabase();
		return ResponseEntity.ok(responseTemplate);

	}

	/**
	 * This method is used to update the existing template
	 * 
	 * @param id       it is used to find the template to update
	 * @param template it has the details of template to be updated
	 * @return it returns the success response if template updated successfully
	 */
	@PutMapping(value = "/changeNotificationTemplateById/{id}")
	public ResponseEntity<SuccessResponseModel> changeTemplateById(@PathVariable("id") Integer id,
			@RequestBody String template) {

		LoggingResponseModel msgStart = LoggingResponseModel.builder().message("Started changing the templates")
				.build();
		log.info(gson.toJson(msgStart));

		SuccessResponseModel responseTemplate = inotificationService.replaceNotificationTemplate(id,
				gson.fromJson(template, NotificationTemplateModel.class));
		return ResponseEntity.ok(responseTemplate);

	}

	/**
	 * @param id this is the id template to be deleted from database
	 * @return it return the success response with message if data is deleted
	 *         successfully
	 */
	@DeleteMapping(value = "/deleteNotificationTemplate/{id}")
	public ResponseEntity<SuccessResponseModel> deleteNotificationTemplateById(@RequestParam(value = "id") Integer id) {

		LoggingResponseModel msgStart = LoggingResponseModel.builder()
				.message("Started deleting the notificationTemplate").build();
		log.info(gson.toJson(msgStart));

		SuccessResponseModel responseTemplate = inotificationService.deleteNotificationTemplate(id);
		return ResponseEntity.ok(responseTemplate);
	}
}
