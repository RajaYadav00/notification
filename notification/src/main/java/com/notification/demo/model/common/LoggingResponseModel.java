package com.notification.demo.model.common;

import org.springframework.http.HttpStatus;

import com.notification.demo.common.MessageTypeConst;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoggingResponseModel {
	private HttpStatus statusCode;
	private MessageTypeConst  messageTypeId;
	private String message;
}
