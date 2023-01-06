package com.notification.demo.service;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.notification.demo.model.EmailDetailsModel;
import com.notification.demo.model.common.SuccessResponseModel;

@Validated
public interface IEmailSenderService {
	/**
	 * 
	 * @param user this variable holds the details of email to send
	 * @return it return success response with details like success code and message
	 */
	public SuccessResponseModel sendEmail(@Valid EmailDetailsModel user);
}