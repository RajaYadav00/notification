package com.notification.demo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.notification.demo.model.SmsWhatsappModel;
import com.notification.demo.model.common.LoggingResponseModel;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.service.impl.WhatsAppService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v0.0.1/notification")
public class WhatsAppController {

	// This is use to serialize JSON object to java object an vice-versa
	@Autowired
	Gson gson;

	@Autowired
	WhatsAppService whatsappService;

	/**
	 * 
	 * @param req this variable holds the details of whatsapp messages
	 * @return  it return the success response with the message and response code
	 */
	@PostMapping("/sendWhatsappNotification")
	public ResponseEntity<SuccessResponseModel> sendWhatsappNotification(@RequestBody @Valid String req){
		
		LoggingResponseModel msgStart = LoggingResponseModel.builder()
				.message("whatsApp module is working").build();
		log.info(gson.toJson(msgStart));

		SuccessResponseModel responseTemplate = whatsappService.sendWhatsAppNotification(gson.fromJson(req, SmsWhatsappModel.class));
		return ResponseEntity.ok(responseTemplate);
		
		
		
		
	}

}
