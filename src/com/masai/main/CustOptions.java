package com.masai.main;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.users.Customer;

public class CustOptions {

	public static void custOptions(Customer customer) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("=================================================");
		System.out.println("please select below option 1/2/3/4");
		System.out.println("1 : Transfer Amount");
		System.out.println("2 : View Transaction History");
		System.out.println("3 : Cheack balance");
		System.out.println("4 : logout");
		CustomerDao dao = new CustomerDaoImpl();
		int opt=sc.nextInt();
		switch (opt) {
		case 1: {			
			System.out.println("Enter your Account number:");
			int cAcc = sc.nextInt();
			
			System.out.println("Enter reciever Account number:");
			int acc_no = sc.nextInt();
			
			System.out.println("Enter amount:");
			long amount = sc.nextLong();
			
			
			
			try {
				dao.transferAmount(acc_no, amount,customer.getId(),cAcc);
				
			
			}catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			
			CustOptions.custOptions(customer);
			break;
			
		}
		case 2: {
			try {
				
				
				dao.transactionHistory(customer.getId());
				
			
			}catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			CustOptions.custOptions(customer);
			break;		
		}
		case 3: {
			try {
				
				
				dao.checkBalance(customer.getId());
				
			
			}catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			CustOptions.custOptions(customer);
			break;		
		}
		case 4: {
			return;
			
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + opt);
		}
	}




		
	}

		
}
