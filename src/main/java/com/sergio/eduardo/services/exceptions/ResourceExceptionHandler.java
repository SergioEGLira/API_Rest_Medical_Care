package com.sergio.eduardo.services.exceptions;

import java.time.Instant;
import java.time.format.DateTimeParseException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
 
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
			ValidationError err = new ValidationError();
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Erro de validação");
			
		err.setPath(request.getRequestURI());
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(err);
		}	

		@ExceptionHandler(HttpMessageNotReadableException.class)
		public ResponseEntity<StandardError> InvalidDataAccessException(HttpMessageNotReadableException e,
				HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Sintaxe de requisição errada...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}

		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<StandardError> NotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Recurso não encontrado...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}

		@ExceptionHandler(PropertyReferenceException.class)
		public ResponseEntity<StandardError> PropertyException(PropertyReferenceException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Requisito de pesquisa errado...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}

		@ExceptionHandler(DateTimeParseException.class)
		public ResponseEntity<StandardError> DateTimeException(DateTimeParseException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Requisito de pesquisa de data errado...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}

		@ExceptionHandler(InvalidDataAccessApiUsageException.class)
		public ResponseEntity<StandardError> InvalidDataAccessException(InvalidDataAccessApiUsageException e,
				HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Sintaxe de requisição errada...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}

		@ExceptionHandler(IllegalArgumentException.class)
		public ResponseEntity<StandardError> IllegalArgsException(IllegalArgumentException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Sintaxe de requisição errada...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
		
		@ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<StandardError> ViolationException(ConstraintViolationException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Sintaxe de requisição errada...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}

		@ExceptionHandler(EntityNotFoundException.class)
		public ResponseEntity<StandardError> EntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(); 
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Sintaxe de requisição errada...");
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}

}