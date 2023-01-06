package com.notification.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.notification.demo.model.NotificationTemplateModel;
import com.notification.demo.model.common.NotificationTypeConst;
import com.notification.demo.model.common.SuccessResponseModel;
import com.notification.demo.repository.INotificationTemplateRepository;
import com.notification.demo.service.INotificationTemplateService;
import com.notification.demo.service.impl.NotificationTemplateServiceImpl;

@SpringBootTest
class NotificationApplicationTests {

	@MockBean
	INotificationTemplateRepository iNotificationTemplateRepo;
	@Autowired
	INotificationTemplateService iNotificationTemplateService;
	
	@BeforeEach
	void setvalue() {
		this.iNotificationTemplateService=new NotificationTemplateServiceImpl(iNotificationTemplateRepo);
	}
	
	
	@Test
	void contextLoads() {
		NotificationTemplateModel notificationTemplate=NotificationTemplateModel.builder()
				.messageBody("jai ram ji")
				.notificationType(NotificationTypeConst.SMS)
				.requestDevice("android")
				.requestOn(Date.from(Instant.now()))
				.subject("leave")
				.templateValidUpto(Date.from(Instant.now()))
				.type(NotificationTypeConst.CUSTOMIZED)
				.build();
	SuccessResponseModel model=iNotificationTemplateService.saveNotificationTemplate(notificationTemplate);
	
	
	assertThat(HttpStatus.OK.value()).isEqualTo(model.getStatusCode());
	
	}

}
