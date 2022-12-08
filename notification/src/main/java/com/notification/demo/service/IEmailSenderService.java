package com.notification.demo.service;

public interface IEmailSenderService {
	public void sendEmail(String toMail,String subject,String body);
}