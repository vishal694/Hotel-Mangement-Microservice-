package com.example.hotel.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 238965033913280496L;

	public ResourceNotFoundException() {
		 super("Resource not found !!");
	 }
	 
	 public ResourceNotFoundException(String message) {
		 super(message);
	 }
	
}
