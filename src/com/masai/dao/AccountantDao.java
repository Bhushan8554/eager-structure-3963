package com.masai.dao;

import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;
import com.masai.users.*;

public interface AccountantDao {

	public Accountant loginAcountant (String userName, String password)throws AccountantException;
	
	
	
	public void addCustomer(int id,int acc_no)throws CustomerException;
	
	public void changeName(int id,String name)throws CustomerException;
	public void changeUserName(int id,String name)throws CustomerException;
	public void removeAcc(int accNo)throws CustomerException;
	public void viewDetail(int accNo)throws CustomerException;
	public void viewAllAccDetail()throws CustomerException;
	public void withdrawAmount(int accNo,int amount)throws CustomerException;
	public void changeAccNo(int id,int currAcNo,int newAcNo)throws CustomerException;



	void depositeAmount(int accNo, int amount) throws CustomerException;
	
}
