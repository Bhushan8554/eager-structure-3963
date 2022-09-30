package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;
import com.masai.users.Accountant;
import com.masai.util.DBUtil;
public class AccountantDaoImpl implements AccountantDao{

	@Override
	public Accountant loginAcountant(String userName, String password) throws AccountantException {
		
		Accountant accountant=null;
		
		if(userName.equals("Ram@777") && password.equals("123456")) {
			accountant=new Accountant(12, "Ram", "Rao", userName, password);
		}else {
			throw new AccountantException("Username and password not valid");
		}
		
		
		return accountant;
	}

	@Override
	public void addCustomer(int id,int acc_no) throws CustomerException {
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("insert into account (customer_id) values (?)");			
			
			ps.setInt(1, id);
			
			
			int x=ps.executeUpdate();
			
			
			if(x>0) {
				
				System.out.println("Registration Succesfull");
				PreparedStatement ps1= conn.prepareStatement("Select * from customer inner join account on customer.id=account.customer_id where account.acc_no=? and customer.id=?");			
				
				ps1.setInt(1, acc_no);
				ps1.setInt(2, id);
				
				ResultSet res=ps1.executeQuery();
				String sert=res.getString("name");
				System.out.println("Account no "+acc_no+" Assign to user "+sert);
				
				
			}else
				throw new CustomerException("User name Allready Exist");
			
			
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
	}

	@Override
	public void changeName(int id,String name) throws CustomerException {


		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("UPDATE customer SET name=? WHERE id = ?");	
			
			ps.setString(1, name);
			ps.setInt(2, id);
			
			int  up= ps.executeUpdate();
			
			if(up<=0) {
				throw new CustomerException("invalid user");
			}
			System.out.println("Name changed succesfully");
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public void changeUserName(int id,String name) throws CustomerException {
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("UPDATE customer SET user_name=? WHERE id = ?");	
			
			ps.setString(1, name);
			ps.setInt(2, id);
			
			int  up= ps.executeUpdate();
			
			if(up<=0) {
				throw new CustomerException("invalid user");
			}
			System.out.println("user name changed succesfully");
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
	}

	@Override
	public void removeAcc(int accNo) throws CustomerException {
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("DELETE FROM account WHERE acc_no=?");	
			
			ps.setInt(1, accNo);
			
			int  up= ps.executeUpdate();
			
			if(up<=0) {
				throw new CustomerException("invalid Account");
			}
			System.out.println("Account deleted Succesfully");
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
	}

	@Override
	public void viewDetail(int accNo) throws CustomerException {
		
	}

	@Override
	public void viewAllAccDetail() throws CustomerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositeAmount(int accNo , int amount) throws CustomerException {
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("UPDATE account SET balance=balance+? WHERE id = ?");	
			
			ps.setInt(1, amount);
			ps.setInt(2, accNo);
			
			int  up= ps.executeUpdate();
			
			if(up<=0) {
				throw new CustomerException("invalid user");
			}
			System.out.println("balance deposited succesfully");
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public void withdrawAmount(int accNo,int amount) throws CustomerException {
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps1=conn.prepareStatement("select balance from account where acc_no=?");
			ps1.setInt(1, accNo);
			
			ResultSet res=ps1.executeQuery();
			
			if(res.next()) {
				long bal=res.getLong("balance");
				if(bal<amount) {
					throw new CustomerException("insufficient balance ");
				}
			}else {
				throw new CustomerException("invalid account");
			}
			PreparedStatement ps= conn.prepareStatement("UPDATE account SET balance=balance-? WHERE id = ?");	
			
			ps.setInt(1, amount);
			ps.setInt(2, accNo);
			
			int  up= ps.executeUpdate();
			
			if(up<=0) {
				throw new CustomerException("invalid user");
			}
			System.out.println("balance withdraw succesfull");
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public void changeAccNo(int id, int currAcNo, int newAcNo) throws CustomerException {
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("UPDATE account SET acc_no=? WHERE customer_id = ? and acc_no=?");	
			
			ps.setInt(1, newAcNo);
			ps.setInt(2, id);
			ps.setInt(1, currAcNo);
			
			int  up= ps.executeUpdate();
			
			if(up<=0) {
				throw new CustomerException("invalid account");
			}
			System.out.println("Account changed succesfully");
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}

	
	
	
	
	

	}


