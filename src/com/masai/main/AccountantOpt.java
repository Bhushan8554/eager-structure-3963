package com.masai.main;

import java.util.Scanner;

public class AccountantOpt {

	public static void accOptions() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("please select below option 1/2/3");
		System.out.println("1 : New Account for Customer");
		System.out.println("2 : Change Customer name");
		System.out.println("3 : Change Customer Account number");
		System.out.println("4 : Change Customer user name");
		System.out.println("5 : Remove Account");
		System.out.println("6 : View account Details by account number");
		System.out.println("7 : view all accounts");
		System.out.println("8 : Deposite amount in user Account");
		System.out.println("9 : withdraw amount from user account");
		System.out.println("10 : Logout");
		
		int opt=sc.nextInt();
		switch (opt) {
		case 1: {
			System.out.println("please Enter customer id ");
			int id=sc.nextInt();
			
			
			break;
			
		}
		case 2: {
			
			break;
					
				}
		case 3: {
			
			
			break;
			
		}
		case 4: {
			
			
			break;
			
		}
		
		case 5: {
			
			
			break;
			
		}
		case 6: {
			
			
			break;
			
		}
		case 7: {
			
			
			break;
			
		}
		case 8: {
			
			
			break;
			
		}
		case 9: {
			
			
			break;
			
		}
		case 10: {
			
			
			return;
			
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + opt);
		}
	}

	}
	
}
