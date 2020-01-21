package com.mongdb.mongodbTest.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongdb.mongodbTest.service.exception.ObjectNotFoundException;

//Classe responsável por tratar possíveis erros na aplicação
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exc, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status, "Não eoncontrado", exc.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
}
