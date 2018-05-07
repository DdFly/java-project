package com.example.service;

import java.util.LinkedList;
import java.util.List;

import com.example.dao.Exhibition_Dao;
import com.example.model.Car;

/**
 * 用车一览
 *
 */
public class Exhibition_Srv {
	Exhibition_Dao ed=new Exhibition_Dao();
	//String s;
		//返回所有的车辆
		public List<Car> FetchAll(){
			List<Car> listC=ed.CarList();
			
			return listC;
		}
		//根据字段查找车辆
		public List<Car> Fetch(String s){
			List<Car> listC=ed.CarList(s);
			return listC;
		}
		
}
