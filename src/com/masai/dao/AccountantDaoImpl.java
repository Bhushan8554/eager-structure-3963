package com.masai.dao;

import com.masai.exception.AccountantException;
import com.masai.users.Accountant;



public class AccountantDaoImpl implements AccountantDao{

	@Override
	public Accountant loginAcountant(String userName, String password) throws AccountantException {
		
		Accountant accountant=null;
		
		if(userName.equals("Ram@777") && password.equals("123456")) {
			accountant=new Accountant(12, "Ram", "Rao", userName, password);
		}else {
			throw new AccountantException("Username and password not valid");
		}
		
		
		return accountant;
	}

	
	
	
	
	

	}


