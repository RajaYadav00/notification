package com.notification.demo.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import com.notification.demo.model.common.ErrorResponseModel;

@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(NotificationTemplateError.class)
	public ResponseEntity<ErrorResponseModel> notificationTemplatehandler(NotificationTemplateError er, WebRequest wr,
			Exception e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		String stackTrace = stringWriter.toString();

		ErrorResponseModel error = ErrorResponseModel.builder().errorCode(1).errorDetails(stackTrace)
				.errorMessage(er.getMessage()).path(wr.getDescription(false)).status(HttpStatus.BAD_REQUEST.value())
				.timestamp(Timestamp.valueOf(LocalDateTime.now())).traceID(Instant.now().toEpochMilli()).build();
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validationExceptionMessage(MethodArgumentNotValidException nValid, WebRequest wr) {
		Map<String, String> msgList = new HashMap<>();
		nValid.getBindingResult().getFieldErrors()
				.forEach(error -> msgList.put(error.getField(), error.getDefaultMessage()));
		
		ValidationError error=new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(), msgList,wr.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
//	@ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handle(Exception ex, 
//                HttpServletRequest request, HttpServletResponse response) {
//        if (ex instanceof NullPointerException) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
////        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        System.out.println(ex.getMessage());
//        System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
//        
//        System.out.println(response.);
//        EmailException er=new EmailException(ex.getMessage());
//        return new ResponseEntity<>(er,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
