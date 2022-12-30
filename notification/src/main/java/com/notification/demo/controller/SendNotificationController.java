package com.notification.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notification.demo.model.Users;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.ISmsService;
import com.notification.demo.service.impl.EmailSenderServiceimpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v0.0.1/notification")
public class SendNotificationController {
	@Autowired
	private EmailSenderServiceimpl emailSenderServiceimpl;

	@Autowired
	ISmsService ismsService;

	@PostMapping("/sendEmailNotification")
	public ResponseEntity<SuccessResponseModel> sendNotificationviamail(@RequestBody Users user)
			throws MessagingException {
		log.info("Users dto is working");
		SuccessResponseModel response = emailSenderServiceimpl.sendEmail(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}