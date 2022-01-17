package com.calpha.hospital.exception;

public class RecordNotFoundException extends Exception{

private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Not record found";

	public RecordNotFoundException() {
		// TODO Auto-generated constructor stub
		 super(DEFAULT_MESSAGE);
	}

	public RecordNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		message = "No employee record exist for given id";
	}

}
