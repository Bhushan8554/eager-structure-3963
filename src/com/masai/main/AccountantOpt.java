package com.masai.main;

import java.util.Scanner;

public class AccountantOpt {

	public static void accOptions() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("please select below option 1/2/3");
		System.out.println("1 : Login as Accountant");
		System.out.println("2 : Login as Customer");
		System.out.println("3 : Register Customer");
		
		int opt=sc.nextInt();
		switch (opt) {
		case 1: {
			
			break;
			
		}
		case 2: {
			
			break;
					
				}
		case 3: {
			
			
			break;
			
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + opt);
		}
	}

	}
	
}
