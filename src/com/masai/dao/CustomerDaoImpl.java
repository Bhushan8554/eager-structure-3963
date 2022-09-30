package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.exception.CustomerException;
import com.masai.users.Customer;
import com.masai.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public Customer loginCustomer(String userName, String password) throws CustomerException {
		Customer customer=null;
		
		try(Connection conn = DBUtil.provideConnection()) {
					
					
					PreparedStatement ps= conn.prepareStatement("select * from customer where user_name = ? AND password = ?");			
					
					ps.setString(1, userName);
					ps.setString(2, password);
					
					ResultSet rs= ps.executeQuery();
					
					
						if(rs.next()) {
						
						int a= rs.getInt("account_no");
						String n= rs.getString("first_name");
						String l= rs.getString("last_name");
						String u= rs.getString("user_name");
						
						String p= rs.getString("password");
						
						long b=rs.getLong("balance");
						
						customer=new Customer(a, n, l, u, p,b);	
						
						
					}else
						throw new CustomerException("Invalid Username or password.. ");
					
					
					
					
				} catch (SQLException e) {
					throw new CustomerException(e.getMessage());
				}
		
		
		
		
		return customer;
	}

	@Override
	public void transferAmount(int accNo,long ammount,int cAcc) throws CustomerException {
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select balance from customer where account_no=?");	
			
			ps.setInt(1, cAcc);
			
			ResultSet  rs= ps.executeQuery();
			rs.next();
			long bal=rs.getLong("balance");
			//System.out.println(bal);
			if(bal<ammount) {
				//System.out.println("Insufficient Balance");
				throw new CustomerException("Insufficient Balance");
			}else {
				PreparedStatement ps1= conn.prepareStatement("UPDATE Customer SET balance=balance+? WHERE account_no = ?;");			
				
				ps1.setLong(1, ammount);
				ps1.setInt(2, accNo);
				int  up= ps1.executeUpdate();
				
				if(up<0) {
					throw new CustomerException("invalid account number.");
				}else {
					PreparedStatement ps2= conn.prepareStatement("UPDATE Customer SET balance=balance-? WHERE account_no = ?;");			
					
					ps2.setLong(1, ammount);
					ps2.setInt(2, cAcc);
					ps2.executeUpdate();
				}
			}
			
			 //System.out.println("Transaction Succesful ");
					
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		
	}

	
}
