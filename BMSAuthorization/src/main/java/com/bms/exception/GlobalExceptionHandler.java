package com.bms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bms.model.MessageResponse;

import lombok.extern.slf4j.Slf4j;

/**Exception class*/
@Slf4j

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
	
	/**
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Object> handleUnauthorizedExceptions(UnauthorizedException ex) {

		log.info("Start");
		log.error("Unauthorized request");
		log.info("End");
		return ResponseEntity.badRequest().body(new MessageResponse(ex.getMessage(),LocalDateTime.now(), HttpStatus.UNAUTHORIZED));
	}
	
	
	
	

	
	
	
	
	
}
