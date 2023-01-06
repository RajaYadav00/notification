package com.notification.demo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class EmailDetails {
	
	private String processType;
	private String scheduledTime;
	private Integer notificationTemplateId;
	private String[] attachFile;
	private String[] ccto;
	private String[] bccto;
	@OneToMany
	private List<NotifyTo> notifyto = new ArrayList<>();

}