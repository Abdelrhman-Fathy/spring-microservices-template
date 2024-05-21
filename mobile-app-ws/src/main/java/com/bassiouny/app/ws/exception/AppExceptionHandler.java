package com.bassiouny.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bassiouny.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		String errorMessage = ex.getLocalizedMessage();
		if(errorMessage == null) {
			errorMessage = ex.toString();
		}
		ErrorMessage error = new ErrorMessage(new Date(), errorMessage);
		
		return new ResponseEntity<>(error,  HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {UserServiceException.class, NullPointerException.class})
	public ResponseEntity<Object> handleUserServiceException(Exception ex, WebRequest request){
		String errorMessage = ex.getLocalizedMessage();
		if(errorMessage == null) {
			errorMessage = ex.toString();
		}
		ErrorMessage error = new ErrorMessage(new Date(), errorMessage);
		
		return new ResponseEntity<>(error,  HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
