package com.vveral.demo.controller;

import java.util.Date;
import java.util.EmptyStackException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import exceptions.ResponseApi;


@ControllerAdvice("controller")
public class ExceptionGlobalResponse extends RuntimeException {
	


	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeException(RuntimeException e) {
		String message = "We have bad code";
		//result = new ResponseApi(new Date(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error TEST");
		return new ResponseEntity<>(message, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> eException(Exception e) {
		return new ResponseEntity<>("Custom error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	



}