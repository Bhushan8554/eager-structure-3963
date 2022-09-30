package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.users.Customer;

public class CTransHistory {

	Customer c=new Customer();
	
	
	
	
	public static void main(String[] args) {
		CTransHistory obj=new CTransHistory();
			CustomerDao dao=new CustomerDaoImpl();
			try {
				dao.transactionHistory(obj.c.getId());
				
			
			}catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
		}


	}


