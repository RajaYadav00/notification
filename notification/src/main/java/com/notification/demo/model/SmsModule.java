package com.notification.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmsModule {
	
	private String notificationType;
	private String processType;
	private Date scheduledTime;
	private Integer notificationTemplateId;
	private Map<String ,String> otherCustomizableObject;
	private List<SmsUser> notifyTo;
	private String requeston;
	private String requestdevice;

}
