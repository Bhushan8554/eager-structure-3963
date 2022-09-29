package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;
import com.masai.users.*;
import com.masai.util.DBUtil;

public class AccountantDaoImpl implements AccountantDao{

	@Override
	public Accountant loginAcountant(String userName, String password) throws AccountantException {
		
		Accountant accountant=null;
		
		try(Connection conn = DBUtil.provideConnection()) {
					
					
					PreparedStatement ps= conn.prepareStatement("select * from accountant where user_name = ? AND password = ?");			
					
					ps.setString(1, userName);
					ps.setString(2, password);
					
					ResultSet rs= ps.executeQuery();
					
					
						if(rs.next()) {
						
						int a= rs.getInt("id");
						String n= rs.getString("first_name");
						String l= rs.getString("last_name");
						String u= rs.getString("user_name");
						
						String p= rs.getString("password");
												
						accountant=new Accountant(a, n, l, u, p);	
						
						
					}else
						throw new AccountantException("Invalid Username or password.. ");
					
					
					
					
				} catch (SQLException e) {
					throw new AccountantException(e.getMessage());
				}
		
		
		return accountant;
	}

	}


