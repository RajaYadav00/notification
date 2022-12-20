package com.notification.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmsWhatsappModule {
	
	@NotNull(message = "Notificatoin type should not be null")
//	@Pattern(regexp = "[a-zA-Z]",message = "notification type should contain only alphbets")
	private String notificationType;
	@NotEmpty(message = "Process type should not be null")
//	@Pattern(regexp = "[a-zA-Z]",message = "process type should contain only alphbets")
	private String processType;
	@NotNull(message = "Scheduled time should not be null")
	private Date scheduledTime;
	@NotNull(message = "Notificatoin template Id should not be null")
	private Integer notificationTemplateId;
	@NotNull(message = "Other customizable object should not be null")
	private Map<String ,String> otherCustomizableObject;
	@NotNull(message = "NotifyTo type should not be null")
	private List<SmsWhatsappUser> notifyTo;
	@NotEmpty(message = "requestOn should not be null")
	private String requeston;
	@NotEmpty(message = "requestdevice type should not be null")
	private String requestdevice;

}
