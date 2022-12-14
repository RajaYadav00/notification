package com.notification.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.notification.demo.model.SmsWhatsappModel;
import com.notification.demo.model.common.LoggingResponseModel;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.ISmsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v0.0.1/notification")
public class SmsNotificationController {

	// This is use to serialize JSON object to java object an vice-versa
	@Autowired
	Gson gson;

	@Autowired
	ISmsService ismsService;

	/**
	 * 
	 * @param smsdetails this variable holds the details of sms
	 * @return it will return the success response with status code if message is
	 *         success
	 */
	@PostMapping("/sendSmsNotification")
	public ResponseEntity<SuccessResponseModel> sendSmsNotification(@RequestBody String smsdetails) {

		LoggingResponseModel msgStart = LoggingResponseModel.builder().message("SmsModule is working").build();
		log.info(gson.toJson(msgStart));

		SuccessResponseModel response = ismsService.sendSms(gson.fromJson(smsdetails, SmsWhatsappModel.class));
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
