package com.notification.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.demo.model.SmsWhatsappModule;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.impl.WhatsAppService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v0.0.1/otp")
public class WhatsAppController {

	@Autowired
	WhatsAppService whatsappService;

	@PostMapping("/sendWhatsappNotification")
	public ResponseEntity<SuccessResponseModel> sendWhatsappNotification(@RequestBody @Valid SmsWhatsappModule req){
		
		log.info("whatsApp module is working");
		SuccessResponseModel response = whatsappService.sendWhatsAppNotification(req);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	

}	


