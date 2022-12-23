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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull(message = "notificationType is required")
	private NotificationTypeConst notificationType;
	@NotNull(message = "notificationTypeConst is required")
	private NotificationTypeConst type;
	@NotNull(message = "template valide upto  is required")
	private Date templateValidUpto;
	private String subject;
	@NotNull(message = "message body is required")
	private String messageBody;
	@NotNull(message = "requested device is required")
	private String requestDevice;
	@NotNull(message = "request on  date is required")
	private Date requestOn;

}
