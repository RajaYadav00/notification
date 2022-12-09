package com.notification.demo.service.impl;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailSenderServiceimpl {

	@Autowired
     JavaMailSender mailsender;
	
	public void sendEmail(String toMail,String subject,String body,String []ccList, String []bccList,String []attachement) throws MessagingException{
		
		
		MimeMessage mimeMessage=mailsender.createMimeMessage();
		MimeMessageHelper mimemessagehelper=new MimeMessageHelper(mimeMessage, false);
		mimemessagehelper.setFrom("ranjeetkumaryadvv@gmail.com");
		mimemessagehelper.setTo(toMail);
		mimemessagehelper.setText(body);
		mimemessagehelper.setSubject(subject);
		mimemessagehelper.setCc(ccList);
		mimemessagehelper.setBcc(bccList);
		
		
//		mimemessagehelper.addAttachment(body, null);
		
		
		mailsender.send(mimeMessage);
		System.out.println("jai rama ji");
	}

	
}
