package com.bms.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Model class for the business details */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

	String message;

	LocalDateTime date;
	HttpStatus status ; 

}
