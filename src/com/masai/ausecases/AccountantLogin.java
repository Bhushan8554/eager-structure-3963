package com.masai.ausecases;

import java.util.Scanner;

import com.masai.dao.AccountantDao;
import com.masai.dao.AccountantDaoImpl;
import com.masai.exception.AccountantException;
import com.masai.users.Accountant;

public class AccountantLogin {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			Accountant accountant= dao.loginAcountant(uname, pass);
		
	 		System.out.println("Welcome :"+accountant.getFirst_name()+" "+accountant.getLast_name());
	 	
	 	
		}catch (AccountantException e) {
			System.out.println(e.getMessage());
		}
	}

}
