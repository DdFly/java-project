package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.dal.DBUtil;
import com.example.model.Customers;

public class LoginVerification {
	
	String id;
	String password;
	Boolean flag = false;
	public LoginVerification(Customers user) throws Exception {
		id = user.getCus_Nickname();
		password = user.getCus_Password();
		String sql = "select * from Customers where Cus_NickName = '"+id+"' and Cus_Password = '"+password+"'";
		DBUtil db = new DBUtil();
		db.openConnection();
		ResultSet res = db.execQuery(sql);
		if(res.next()) {
			flag = true;
		}
		else
			System.out.println("login failed");
	}
	
	public Boolean getFlag() {
		return flag;
	}
}

