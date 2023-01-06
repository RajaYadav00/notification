package com.notification.demo.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuccessResponseModel {
	
	private Integer statusCode;
	private String message;
	private Integer messageTypeId;
}
