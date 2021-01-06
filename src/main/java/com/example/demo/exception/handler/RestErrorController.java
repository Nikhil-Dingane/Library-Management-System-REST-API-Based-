package com.example.demo.exception.handler;

import java.util.logging.ErrorManager;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.ErrorMessage;

@ControllerAdvice
public class RestErrorController extends ResponseEntityExceptionHandler{

	public RestErrorController() {
		super();
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleOtherException(Exception exception, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage("Error_code", exception.getMessage());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<Object>(errorMessage, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
