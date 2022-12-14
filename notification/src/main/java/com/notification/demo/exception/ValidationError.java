package com.notification.demo.exception;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {
	
	private Integer status;
	private Map<String,String> errorMessage;
	private String path;

	
}
