package com.notification.demo.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Users {
	private String notificationType;
	private String processType;
//	private String ScheduledTime;
	private Integer notificationTemplateId;
//	@OneToMany
//	private List<EmailObj> []otherCustomizableObject;
//	private List<String> []attachFile;
//	private List<String> []ccto;
//	private List<String> []bccto;
	@OneToMany
	private List<User> notifyto = new ArrayList<>();
	

	
	

	
}