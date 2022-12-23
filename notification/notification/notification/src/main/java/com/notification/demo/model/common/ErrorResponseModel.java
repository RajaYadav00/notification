package com.notification.demo.model.common;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseModel {
	
	private Timestamp timestamp;
	private Integer status;
	private Integer errorCode; 
	private String errorMessage;

	private long traceID;
	private String errorDetails;
	
	private String path;
}
