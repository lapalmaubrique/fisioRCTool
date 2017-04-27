package com.fisiorctool.exceptions;

public class UserExistException extends Exception {

	private static final long serialVersionUID = -1571148624390847927L;
	
	public UserExistException(){
		super();
	}
	
	public UserExistException(String message){
		super(message);
	}

}
