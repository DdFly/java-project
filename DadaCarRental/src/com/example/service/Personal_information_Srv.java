package com.example.service;

import com.example.dao.userDAO;
import com.example.model.Car;
import com.example.model.Customers;

/**
 * ������Ϣ
 * @author ����
 *
 */
public class Personal_information_Srv {
	
	userDAO  ud=new userDAO();
	public int update_userInfo(Customers u){
		return ud.update_user(u);
	}
	public Car select_userInfo(int id){
		return ud.select_user(id);
	}
}
