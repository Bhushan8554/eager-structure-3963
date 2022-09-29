package com.masai.dao;

import com.masai.exception.CustomerException;
import com.masai.users.Customer;

public interface CustomerDao {

	public Customer loginCustomer (String userName, String password)throws CustomerException;
}
