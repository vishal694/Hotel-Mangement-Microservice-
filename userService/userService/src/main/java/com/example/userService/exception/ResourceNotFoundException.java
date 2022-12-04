package com.example.userService.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -385247494632242078L;

	 public ResourceNotFoundException() {
		 super("Resource not found on Server");
	 }
	 
	 public ResourceNotFoundException(String message) {
		 super(message);
	 }
	 
}
