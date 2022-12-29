package com.notification.demo.service;

import com.notification.demo.model.Users;
import com.notification.demo.model.common.SuccessResponseModel;
public interface IEmailSenderService {
	public SuccessResponseModel sendEmail(Users user);
}