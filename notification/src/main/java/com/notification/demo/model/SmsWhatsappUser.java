package com.notification.demo.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmsWhatsappUser {

	@NotNull(message = "name of should not be null")
	private String name;
	@NotNull(message = "phome number should not be null")
	private String phone;
	@NotNull(message = "Id should not be null")
	private Integer id;
	
}
