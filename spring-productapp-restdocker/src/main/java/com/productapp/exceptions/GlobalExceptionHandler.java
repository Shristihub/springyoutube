package com.productapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		int statusCode = status.value();
		String error = ex.getMessage();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		headers.add("info","Method not supported");
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		int statusCode = status.value();
		String error = ex.getMessage();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		headers.add("info","Media Type not supported");
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		int statusCode = status.value();
		String error = ex.getMessage();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
//		headers.add("info","Pathvariable is missing");
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		int statusCode = status.value();
		String error = ex.getMessage();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
//		headers.add("info","RequestParam variable name does not match");
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		int statusCode = status.value();
		String error = ex.getMessage();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		headers.add("info","Type mismatch");
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	protected ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex){
		HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
		String error = ex.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", ex.getMessage());
		int statusCode = httpStatus.value();
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), httpStatus.value(), error, httpStatus);
		return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).headers(headers).body(apiErrors);
	}
	
	@ExceptionHandler(InvalidIdException.class)
	protected ResponseEntity<Object> handleInvalidId(InvalidIdException ex){
		HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
		String error = ex.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", ex.getMessage());
		int statusCode = httpStatus.value();
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), httpStatus.value(), error, httpStatus);
		return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).headers(headers).body(apiErrors);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(Exception ex){
		HttpStatus httpStatus = HttpStatus.CONFLICT;
		String error = ex.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", ex.getMessage());
		int statusCode = httpStatus.value();
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), httpStatus.value(), error, httpStatus);
		return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).headers(headers).body(apiErrors);
	}
}














