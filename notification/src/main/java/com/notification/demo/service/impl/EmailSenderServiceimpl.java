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

	public void sendEmail(String toMail, String subject, String msgbody, String[] ccList, String[] bccList,
			String[] file,String name) throws MessagingException {

		String msg = msgbody.replace("{{#cusname}}", name);
		MimeMessage mimeMessage = mailsender.createMimeMessage();
		MimeMessageHelper mimemessagehelper = new MimeMessageHelper(mimeMessage, true);
		mimemessagehelper.setFrom("ranjeetkumaryadvv@gmail.com");
		mimemessagehelper.setTo(toMail);
		mimemessagehelper.setText(msg);
		mimemessagehelper.setSubject(subject);
		mimemessagehelper.setCc(ccList);
		mimemessagehelper.setBcc(bccList);
       
		for(int i=0;i<file.length;i++) {
		FileSystemResource filesystemResorce = new FileSystemResource(new File(file[i]));
		mimemessagehelper.addAttachment(filesystemResorce.getFilename(), filesystemResorce);}
		mailsender.send(mimeMessage);
	}

}
