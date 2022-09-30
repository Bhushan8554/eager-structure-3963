package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.users.Customer;

public class CustomerLogin {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			Customer customer= dao.loginCustomer(uname, pass);
		
	 		System.out.println("Welcome :"+customer.getName());
	 	
	 	
		}catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	}

}
