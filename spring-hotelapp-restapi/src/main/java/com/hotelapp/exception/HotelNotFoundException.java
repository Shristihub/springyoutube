package com.hotelapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HotelNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
