package com.example.service;

import java.util.LinkedList;
import java.util.List;

import com.example.dao.Exhibition_Dao;
import com.example.model.Car;

/**
 * �ó�һ��
 *
 */
public class Exhibition_Srv {
	Exhibition_Dao ed=new Exhibition_Dao();
	//String s;
		//�������еĳ���
		public List<Car> FetchAll(){
			List<Car> listC=ed.CarList();
			
			return listC;
		}
		//�����ֶβ��ҳ���
		public List<Car> Fetch(String s){
			List<Car> listC=ed.CarList(s);
			return listC;
		}
		
}
