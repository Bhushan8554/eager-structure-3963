package com.masai.main;

import java.util.Scanner;

import com.masai.dao.AccountantDao;
import com.masai.dao.AccountantDaoImpl;
import com.masai.exception.CustomerException;

public class AccountantOpt {

	public static void accOptions() {
		AccountantDao dao=new AccountantDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("=================================================");
		System.out.println("please select below option 1/2/3/4/5/6/7/8/9");
		System.out.println("1 : New Account for Customer");
		System.out.println("2 : Change Customer name");
		System.out.println("3 : Change Customer user name");
		System.out.println("4 : Remove Account");
		System.out.println("5 : View account Details by account number");
		System.out.println("6 : view all accounts");
		System.out.println("7 : Deposite amount in user Account");
		System.out.println("8 : withdraw amount from user account");
		System.out.println("9 : Approve customer loan");
		System.out.println("10 : remove loan");
		System.out.println("11 : Logout");
		
		int opt=sc.nextInt();
		switch (opt) {
		case 1: {
			System.out.println("please Enter customer id ");
			int id=sc.nextInt();
			System.out.println("please Enter Account no to assign ");
			int ac=sc.nextInt();
			try {
				dao.addCustomer(id, ac);
				
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			break;
			
		}
		case 2: {
			System.out.println("please Enter customer id ");
			int id=sc.nextInt();
			System.out.println("please Enter new name");
			String ac=sc.next();
			try {
				dao.changeName(id, ac);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			break;
					
				}
		case 3: {
			
			System.out.println("please Enter customer id ");
			int id=sc.nextInt();
			System.out.println("please Enter new user name");
			String ac=sc.next();
			try {
				dao.changeUserName(id, ac);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			break;
			
		}
		
		case 4: {
			
			System.out.println("please Enter Account number");
			int ac=sc.nextInt();
			try {
				dao.removeAcc(ac);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			break;
			
		}
		case 5: {
			
			System.out.println("please Enter Account number");
			int ac=sc.nextInt();
			try {
				dao.viewDetail(ac);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			break;
			
		}
		case 6: {
			try {
				dao.viewAllAccDetail();
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			break;
			
		}
		case 7: {
			
			System.out.println("please Enter customer Account no ");
			int ac=sc.nextInt();
			System.out.println("please Enter amount to deposite");
			int amunt=sc.nextInt();
			try {
				dao.depositeAmount(ac, amunt);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			
			break;
			
		}
		case 8: {
			System.out.println("please Enter customer Account no ");
			int ac=sc.nextInt();
			System.out.println("please Enter amount to withdraw");
			int amunt=sc.nextInt();
			try {
				dao.withdrawAmount(ac, amunt);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			
			break;
			
		}
		case 9: {
			System.out.println("please Enter customer Account no ");
			int ac=sc.nextInt();
			System.out.println("please Enter loan amount");
			int amunt=sc.nextInt();
			System.out.println("please Enter loan type home /personal/car");
			String str=sc.next();
			try {
				dao.approveLoan(ac, str, amunt);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			
			break;
			
		}
		case 10: {
			System.out.println("please Enter customer Account no ");
			int ac=sc.nextInt();
			
			try {
				dao.removeLoan(ac);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				AccountantOpt.accOptions();
			}
			
			
			break;
			
		}
		case 11: {
			
			
			return;
			
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + opt);
		}
	}

	}
	
}
