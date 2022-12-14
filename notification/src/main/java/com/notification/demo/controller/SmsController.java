package com.notification.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.demo.model.SmsModule;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.ISmsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v0.0.1/otp")
public class SmsController {

	@Autowired
	ISmsService ismsService;
	
	@PostMapping("/sendSmsNotification")
	public ResponseEntity<SuccessResponseModel> sendSmsNotification(@RequestBody SmsModule sms) {

		log.info("SmsModule is working");
		
		SuccessResponseModel response = ismsService.sendSms(sms);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
