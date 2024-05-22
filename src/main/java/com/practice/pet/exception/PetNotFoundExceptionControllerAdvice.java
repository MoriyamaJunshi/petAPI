package com.practice.pet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PetNotFoundExceptionControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(PetNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String petNotFoundHandler (PetNotFoundException ex) {
		return ex.getMessage();
	}

}
