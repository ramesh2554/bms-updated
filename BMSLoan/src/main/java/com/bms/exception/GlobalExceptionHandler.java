package com.bms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bms.model.ResponseMessage;

import feign.RetryableException;

public class GlobalExceptionHandler {

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(
//	  MethodArgumentNotValidException ex) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	   
//	    return errors;
//	}
	
	
	@ExceptionHandler(RetryableException.class)
	public ResponseEntity<ResponseMessage> microServiceUnavailableException( ) {
		return new ResponseEntity<>(
				new ResponseMessage("MicroServiceUnavailable", LocalDateTime.now(), HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);
	}
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Object> handleUnauthorizedExceptions(UnauthorizedException ex) {
		
		return new ResponseEntity<>(
				new ResponseMessage("Un Authorized, Login Again ...", LocalDateTime.now(), HttpStatus.UNAUTHORIZED),
				HttpStatus.UNAUTHORIZED);
	}
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//	    Map<String, String> errors = new HashMap<>();
//	 
//	    String formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(LocalDateTime.now());
//    	ex.getBindingResult().getFieldErrors().forEach(error -> {
//	    	errors.put("RejectedValue" ,(String) error.getRejectedValue());
//	    	errors.put("Time stamp" , formatter);
//	        errors.put(error.getField(), error.getDefaultMessage());
//	    }); 
//	    return errors;
//		
//	}
	
	


	
}
