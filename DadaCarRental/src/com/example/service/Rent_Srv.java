package com.example.service;

import com.example.dao.carDAO;
import com.example.model.Car;

/**
 *³ö×â
 * @author ´ú¶°
 *
 */
public class Rent_Srv {
	carDAO cd=new carDAO();
	public int rent_car(Car c){
		return cd.insert_car(c);
	}
	
}
