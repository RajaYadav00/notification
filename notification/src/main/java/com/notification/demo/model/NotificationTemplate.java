package com.notification.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.notification.demo.model.common.NotificationTypeConst;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class NotificationTemplate {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
//	@NotBlank (message = "notificationType is required")
	private NotificationTypeConst notificationType;
	
//	@NotBlank (message = "notificationType is required")
	private NotificationTypeConst type;
	
//	@NotBlank (message = "notificationType is required")
	private Date templateValidUpto;
	
	private String subject;
	
	@NotBlank (message = "messageBody is required")
	private String messageBody;
	
	@NotBlank (message = "requestdevice is required")
	private String requestDevice;
	
//	@NotBlank (message = "requestOn is required")
	private Date requestOn;

}
