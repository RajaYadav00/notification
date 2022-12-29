package com.indusnet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.indusnet.demo.model.NotificationTemplate;
import com.indusnet.demo.model.common.LoggingResponseModel;
import com.indusnet.demo.model.common.SuccessResponseModel;
import com.indusnet.demo.service.INotificationTemplateService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v0.0.1/notification/")
@Slf4j
@Validated
public class NotificationTempController {

	@Autowired
	Gson gson;

	@Autowired
	INotificationTemplateService iNotificationService;

	/**
	 * This method is use to interact to the service layer for storing the template
	 * 
	 * @param template the details of template held in this variable
	 * @return it return the success response with status code
	 */
	
	@PostMapping(value = "/saveNotificationTemplate")
	public ResponseEntity<SuccessResponseModel> saveTemplate(@RequestBody String template) {

		LoggingResponseModel msgStart = LoggingResponseModel.builder().statusCode(HttpStatus.ACCEPTED)
				.message("started at template saving").build();

		log.info(gson.toJson(msgStart));

		SuccessResponseModel response = iNotificationService
				.saveNotificationTemplate(gson.fromJson(template, NotificationTemplate.class));

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
