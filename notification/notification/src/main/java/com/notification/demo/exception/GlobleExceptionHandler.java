package com.notification.demo.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.notification.demo.model.common.ErrorResponseModel;

@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(NotificationTemplateError.class)
	public ResponseEntity<ErrorResponseModel> notificationTemplatehandler(NotificationTemplateError er, WebRequest wr,Exception e) {
		
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		String stackTrace = stringWriter.toString();
		
		
		ErrorResponseModel error = ErrorResponseModel.builder().errorCode(1).errorDetails(stackTrace).errorMessage(er.getMessage())
				.path(er.getPath()).status(HttpStatus.BAD_REQUEST.value()).timestamp(Timestamp.valueOf(LocalDateTime.now())).traceID(Instant.now().toEpochMilli()).build();
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

	}

}
