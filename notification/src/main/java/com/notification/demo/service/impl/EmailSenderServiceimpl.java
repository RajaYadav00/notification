package com.notification.demo.service.impl;

import java.io.File;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.notification.demo.model.EmailDetails;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.SuccessResponseModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailSenderServiceimpl {
	@Autowired
	JavaMailSender mailsender;

	@Autowired
	NotificationTemplateServiceImpl notificationTemplateServiceImpl;

	public SuccessResponseModel sendEmail(EmailDetails details) {

		Integer templateId = details.getNotificationTemplateId();
		NotificationTemplate template = notificationTemplateServiceImpl.getTemplate(templateId);
		log.info(template.getSubject());
		details.getNotifyto().forEach(x -> {
			try {

				String msg = template.getMessageBody().replace("{{#cusname}}", x.getName());
				MimeMessage mimeMessage = mailsender.createMimeMessage();
				MimeMessageHelper mimemessagehelper = new MimeMessageHelper(mimeMessage, true);
				mimemessagehelper.setFrom("ranjeetkumaryadvv@gmail.com");
				mimemessagehelper.setTo(x.getEmail());
				mimemessagehelper.setText(msg);
				mimemessagehelper.setSubject(template.getSubject());
				mimemessagehelper.setCc(details.getCcto());
				mimemessagehelper.setBcc(details.getBccto());

				for (int i = 0; i < details.getAttachFile().length; i++) {
					FileSystemResource filesystemResorce = new FileSystemResource(new File(details.getAttachFile()[i]));
					mimemessagehelper.addAttachment(filesystemResorce.getFilename(), filesystemResorce);
				}
				mailsender.send(mimeMessage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		return SuccessResponseModel.builder().status(HttpStatus.ACCEPTED.value())
				.messsage("The Email-notification is generated").templateId(templateId).build();

	}

}
