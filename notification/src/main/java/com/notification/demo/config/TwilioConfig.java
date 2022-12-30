package com.notification.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

/**
 * This class is used to configer the twilio with our application
 * @author Raja Ram Yadav
 *
 */
@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwilioConfig {

	private String accountSid;
	private String authToken;
	private String trialNumber;
}
