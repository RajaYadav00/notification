package com.notification.demo.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderServiceimpl {

	@Autowired
     JavaMailSender mailsender;
	
	public void sendEmail(String toMail,String subject,String body,String []ccList, String []bccList,String []file) throws MessagingException{
		
		
		MimeMessage mimeMessage=mailsender.createMimeMessage();
		MimeMessageHelper mimemessagehelper=new MimeMessageHelper(mimeMessage, false);
		mimemessagehelper.setFrom("ranjeetkumaryadvv@gmail.com");
		mimemessagehelper.setTo(toMail);
		mimemessagehelper.setText(body);
		mimemessagehelper.setSubject(subject);
		mimemessagehelper.setCc(ccList);
		mimemessagehelper.setBcc(bccList);
		
		FileSystemResource filesystemResorce = new FileSystemResource(new File(file[0]));
		mimemessagehelper.addAttachment(filesystemResorce.getFilename(), filesystemResorce);
		
		
		
		mailsender.send(mimeMessage);
	}

	
}
