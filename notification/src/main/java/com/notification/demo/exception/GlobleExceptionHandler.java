package com.notification.demo.exception;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.google.gson.Gson;
import com.notification.demo.common.MessageTypeConst;
import com.notification.demo.model.common.ErrorResponseModel;
import com.notification.demo.model.common.LoggingResponseModel;
import com.notification.demo.model.common.SuccessResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobleExceptionHandler {

	@Autowired
	Gson gson;

	@ExceptionHandler(NotificationTemplateError.class)
	public ResponseEntity<ErrorResponseModel> notificationTemplatehandler(NotificationTemplateError er, WebRequest wr,
			Exception e) {

		ErrorResponseModel error = ErrorResponseModel.builder().errorCode(1).errorMessage(er.getMessage())
				.path(wr.getDescription(false)).status(HttpStatus.BAD_REQUEST.value())
				.timestamp(Timestamp.valueOf(LocalDateTime.now())).traceID(Instant.now().toEpochMilli()).build();

		log.error(gson.toJson(LoggingResponseModel.builder().message(er.getMessage())
				.messageTypeId(MessageTypeConst.OTHERS).statusCode(HttpStatus.UNPROCESSABLE_ENTITY).build()));

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ValidationError> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest wr) {

		LoggingResponseModel msg = LoggingResponseModel.builder().statusCode(HttpStatus.ACCEPTED)
				.message("ConstraintVoilation is working").build();
		log.info(gson.toJson(msg));

		Map<String, String> msgList = new HashMap<>();
		msgList.put("message", ex.getMessage().split(",")[0].split(":")[1]);
		ValidationError er = new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(), msgList,
				wr.getDescription(false));

		log.error(gson.toJson(LoggingResponseModel.builder().message(ex.getMessage().split(",")[0].split(":")[1])
				.messageTypeId(MessageTypeConst.OTHERS).statusCode(HttpStatus.UNPROCESSABLE_ENTITY).build()));

		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);

	}

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(CustomUnprocessableRequestException.class)
	public ResponseEntity<ErrorResponseModel> handleCustomUnprocessableRequestException(
			CustomUnprocessableRequestException ex) {
		String msg = ex.getMessage();
		ErrorResponseModel errorResponse = null;
		errorResponse = ErrorResponseModel.builder().errorMessage(msg).errorCode(1)
				.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).timestamp(Timestamp.valueOf(LocalDateTime.now()))
				.traceID(Instant.now().toEpochMilli()).build();
		
		log.error(gson.toJson(LoggingResponseModel.builder().message(msg).messageTypeId(MessageTypeConst.OTHERS)
				.statusCode(HttpStatus.UNPROCESSABLE_ENTITY).build()));
		
		return new ResponseEntity<ErrorResponseModel>(errorResponse,HttpStatus.BAD_REQUEST);
	}

}
