package com.masai.exception;

public class AccountantException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String masssage ;
	
	
	public AccountantException(String masssage) {
		this.masssage = masssage;
	}


	@Override
	public String getMessage() {
		
		return this.masssage;
	}


}
