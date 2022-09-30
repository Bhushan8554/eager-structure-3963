package com.masai.exception;

public class CustomerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String masssage ;
	
	
	public CustomerException(String masssage) {
		super();
		this.masssage = masssage;
	}


	@Override
	public String getMessage() {
		
		return this.masssage;
	}


	
	

}
