package com.masai.dao;

import com.masai.exception.AccountantException;
import com.masai.exception.CustomerException;
import com.masai.users.*;

public interface AccountantDao {

	public Accountant loginAcountant (String userName, String password)throws AccountantException;
}
