package com.notification.demo.service;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.notification.demo.model.EmailDetails;
import com.notification.demo.model.common.SuccessResponseModel;
@Validated
public interface IEmailSenderService {
	public SuccessResponseModel sendEmail(@Valid EmailDetails user);
}