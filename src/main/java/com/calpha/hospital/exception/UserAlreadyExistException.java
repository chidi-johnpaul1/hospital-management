package com.calpha.hospital.exception;


import com.calpha.hospital.model.Users;
public class UserAlreadyExistException   extends Exception{

private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "The user you entered  already exist";

	
	public UserAlreadyExistException() {
		// TODO Auto-generated constructor stub
		 super(DEFAULT_MESSAGE);
	}
	
    
    public UserAlreadyExistException(Users user) {
        super(String.format("There exist %s user with ", user.getEmail(), user.getUsername()));
    }
    
   
    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
