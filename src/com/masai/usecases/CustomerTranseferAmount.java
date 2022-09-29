package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;

public class CustomerTranseferAmount {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Account number:");
			int acc_no = sc.nextInt();
			
			System.out.println("Enter amount:");
			long amount = sc.nextLong();
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				dao.transferAmount(acc_no, amount);
				System.out.println("Transaction Succesful");
			
			}catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
