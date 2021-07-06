package com.cts.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.model.ResponseMessage;

import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(RetryableException.class)
	public ResponseEntity<ResponseMessage> microServiceUnavailableException() {
		log.info("Start");
		log.error("RetryableException occurs when MicroService is Unavailable ");
		log.info("End");
		return new ResponseEntity<>(
				new ResponseMessage("MicroService Unavailable", LocalDateTime.now(), HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param ex
	 * @return
	 * 
	 * 
	 *         used in putMapping ConstraintViolationException
	 * 
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> ConstraintViolationException(ConstraintViolationException ex) {
		log.info("Start");
		Map<String, String> errors = new HashMap<>();

		ex.getConstraintViolations().forEach(error -> {
			errors.put("Field Name", (String) error.getPropertyPath().toString());
			errors.put("Timestamp", LocalDateTime.now().toString());
			errors.put("Error Message ", error.getMessage());
		});
		log.info("End");
		return errors;

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		log.info("Start");
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put("Field Name", (String) error.getField());
			errors.put("Timestamp", LocalDateTime.now().toString());
			errors.put("Error Message ", error.getDefaultMessage());
		});
		log.info("End");
		return errors;

	}

}
