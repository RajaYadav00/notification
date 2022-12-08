package com.notification.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


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
	private String notificationType;
	
//	@NotBlank (message = "notificationType is required")
	private String type;
	
	@NotBlank (message = "notificationType is required")
	private String templateValidUpto;
	
	private String subject;
	
	@NotBlank (message = "messageBody is required")
	private String messageBody;
	
	@NotBlank (message = "requestdevice is required")
	private String requestdevice;
	
	@NotBlank (message = "requestOn is required")
	private String requestOn;

}
