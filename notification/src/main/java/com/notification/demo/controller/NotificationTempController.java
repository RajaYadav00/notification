package com.notification.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.notification.demo.exception.NotificationTemplateError;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.LoggingResponseModel;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.INotificationTemplateService;
import com.notification.demo.service.impl.NotificationTemplateServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/api/v0.0.1/otp/")
@Slf4j
public class NotificationTempController {
	
	@Autowired
    Gson gson;
	
	@Autowired
	NotificationTemplateServiceImpl inotificationService;
	
	@PostMapping(value="/saveNotificationTemplate")
	public ResponseEntity<SuccessResponseModel> saveTemplate(@RequestBody String template){
		
		
		LoggingResponseModel msgStart = LoggingResponseModel.builder()
											.statusCode(HttpStatus.ACCEPTED)
											.message("started at template saving")
											.build();
		log.info(gson.toJson(msgStart));
		
		SuccessResponseModel response=inotificationService.saveNotificationTemplate(gson.fromJson(template,NotificationTemplate.class));
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
