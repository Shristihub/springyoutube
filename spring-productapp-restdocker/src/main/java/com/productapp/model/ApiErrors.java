package com.productapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrors {

	private LocalDateTime timestamp;
	private int statusCode; // 200,500,201
	private String error; // print the error message
	private HttpStatus status; //OK,INTERNALSERVERERROR,CREATED
}
