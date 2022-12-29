package com.notification.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "notificationType is required")
	private NotificationTypeConst notificationType;
	@NotNull(message = "notificationType is required")
	private NotificationTypeConst type;
	@NotNull(message = "notificationType is required")
	private Date templateValidUpto;
	private String subject;
	@NotNull(message = "notificationType is required")
	private String messageBody;
	@NotNull(message = "notificationType is required")
	private String requestDevice;
	@NotNull(message = "notificationType is required")
	private Date requestOn;

}
