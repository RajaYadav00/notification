package com.notification.demo.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.notification.demo.controller.SendNotificationController;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.Users;
import com.notification.demo.model.common.SuccessResponseModel;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmailSenderServiceimpl {
	@Autowired
	JavaMailSender mailsender;
	
	@Autowired
	NotificationTemplateServiceImpl notificationTemplateServiceImpl;

	public SuccessResponseModel sendEmail( Users user) throws MessagingException {
		
		Integer templateId = user.getNotificationTemplateId();
		NotificationTemplate template = notificationTemplateServiceImpl.getTemplate(templateId);
		log.info(template.getSubject());
		user.getNotifyto().forEach(x -> {
			try {
//				emailSenderServiceimpl.sendEmail(x.getEmail(), template.getSubject(), template.getMessageBody(),
//						user.getCcto(), user.getBccto(), user.getAttachFile(), x.getName());
				
				String msg = template.getMessageBody().replace("{{#cusname}}", x.getName());
				MimeMessage mimeMessage = mailsender.createMimeMessage();
				MimeMessageHelper mimemessagehelper = new MimeMessageHelper(mimeMessage, true);
				mimemessagehelper.setFrom("ranjeetkumaryadvv@gmail.com");
				mimemessagehelper.setTo(x.getEmail());
				mimemessagehelper.setText(msg);
				mimemessagehelper.setSubject(template.getSubject());
				mimemessagehelper.setCc(user.getCcto());
				mimemessagehelper.setBcc(user.getBccto());
		       
				for(int i=0;i<user.getAttachFile().length;i++) {
				FileSystemResource filesystemResorce = new FileSystemResource(new File(user.getAttachFile()[i]));
				mimemessagehelper.addAttachment(filesystemResorce.getFilename(), filesystemResorce);}
				mailsender.send(mimeMessage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return SuccessResponseModel.builder().status(HttpStatus.ACCEPTED.value())
				.messsage("The Email-notification is generated").templateId(templateId).build();

}

}
