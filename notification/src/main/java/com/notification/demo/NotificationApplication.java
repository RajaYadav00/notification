package com.notification.demo;


import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.notification.demo.config.TwilioConfig;
import com.twilio.Twilio;

@SpringBootApplication
public class NotificationApplication {
	
	@Autowired
	TwilioConfig tConfig;
	
	@PostConstruct
	public void initTwilioConfig() {
		Twilio.init(tConfig.getAccountSid(),tConfig.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
	
	
  
	
}
