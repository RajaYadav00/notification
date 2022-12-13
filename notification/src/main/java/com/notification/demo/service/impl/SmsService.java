package com.notification.demo.service.impl;
import org.springframework.stereotype.Service;

import com.notification.demo.model.common.SmsPojo;
import com.notification.demo.service.ISmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService implements ISmsService {
	
	private static final String accountSID="ACe9530394dfdc668ffbce9c20b2d1ba0c";
	private static final String authToken="6bb252da4f7cac1ab4502a8bd9d13def";
	private static final String fromNumber="+19035826473";
	
	@Override
	public void sendSms(SmsPojo sms ,String responseOtp){
		Twilio.init(accountSID, authToken);
		
		String msg= "Otp is generated successfully "+responseOtp;
		
		Message message =Message.creator(new PhoneNumber(sms.getMob()),new PhoneNumber(fromNumber),msg).create();
	}

}
