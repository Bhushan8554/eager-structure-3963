package com.masai.main;

import java.util.Scanner;

import com.masai.dao.AccountantDao;
import com.masai.dao.AccountantDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;
import com.masai.users.Accountant;
import com.masai.users.Customer;

public class App {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("welcome to the Bank");
		
		boolean loop =true;
		
		while(loop) {
			System.out.println("please select below option 1/2/3/4");
			System.out.println("1 : Login as Accountant");
			System.out.println("2 : Login as Customer");
			System.out.println("3 : Register Customer");
			System.out.println("4 : Exit");
			
			int opt=sc.nextInt();
			switch (opt) {
			case 1: {
				System.out.println("Enter Username:");
				String uname = sc.next();
				
				System.out.println("Enter Password:");
				String pass = sc.next();
				
				AccountantDao dao = new AccountantDaoImpl();
				
				try {
					Accountant accountant= dao.loginAcountant(uname, pass);
				
			 		System.out.println("Welcome :"+accountant.getFirst_name()+" "+accountant.getLast_name());
			 		AccountantOpt.accOptions();
			 	
				}catch (AccountantException e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			}
			case 2: {
						
				System.out.println("Enter Username:");
				String uname = sc.next();
				
				System.out.println("Enter Password:");
				String pass = sc.next();
				
				CustomerDao dao = new CustomerDaoImpl();
				
				try {
					Customer customer= dao.loginCustomer(uname, pass);
				
			 		System.out.println("Welcome :"+customer.getName());
			 		CustOptions.custOptions(customer);
			 	
				}catch (CustomerException e) {
					System.out.println(e.getMessage());
				}
				
				break;
						
					}
			case 3: {
				
				System.out.println("Enter name:");
				String name = sc.next();
				System.out.println("Enter user name:");
				String uname = sc.next();
				
				System.out.println("Enter password:");
				String pass = sc.next();
				
				CustomerDao dao= new CustomerDaoImpl();
				
				String str = null;
				try {
					str = dao.registerCustome(name,uname,pass);
				} catch (CustomerException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				System.out.println(str);
				
				break;
				
			}
			
			case 4: {
				
				return;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}

		}
		}

}
