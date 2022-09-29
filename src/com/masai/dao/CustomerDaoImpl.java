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

	
}
