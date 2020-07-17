package com.hotelapp.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrors {
	String message;
	List<String> details;
	HttpStatus status;
	LocalDateTime timestamp;

}
