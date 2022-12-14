package com.notification.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwilioConfig {

	private String accountSid;
	private String authToken;
	private String trialNumber;
}
