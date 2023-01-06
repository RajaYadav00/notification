package com.notification.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.notification.demo.model.EmailDetails;
import com.notification.demo.model.common.LoggingResponseModel;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.ISmsService;
import com.notification.demo.service.impl.EmailSenderServiceimpl;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("api/v0.0.1/notification")
public class SendNotificationController {

	// This is use to serialize JSON object to java object an vice-versa
	@Autowired
	Gson gson;

	@Autowired
	private EmailSenderServiceimpl emailSenderServiceimpl;

	@Autowired
	ISmsService ismsService;

	/**
	 * 
	 * @param details we get details Of email to whom we have to send email and other details
	 * @return it will return the success response with success response code  
	 */

	@PostMapping("/sendEmailNotification")
	public ResponseEntity<SuccessResponseModel> sendNotificationviamail(@RequestBody String details) {

		LoggingResponseModel msgStart = LoggingResponseModel.builder().statusCode(HttpStatus.ACCEPTED)
				.message("started at sending emailNotification").build();
		log.info(gson.toJson(msgStart));

		SuccessResponseModel response = emailSenderServiceimpl.sendEmail(gson.fromJson(details, EmailDetails.class));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}