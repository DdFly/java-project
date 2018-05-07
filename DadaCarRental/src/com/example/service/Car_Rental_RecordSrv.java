package com.example.service;

import java.util.ArrayList;

import java.util.List;

import com.example.dao.Car_Rental_Record_Dao;
import com.example.model.Rent_Record;

/**
 * ×â³µ¼ÇÂ¼

 *
 */
public class Car_Rental_RecordSrv {
	Car_Rental_Record_Dao  ccrd=new Car_Rental_Record_Dao();
	List<Rent_Record> n=new ArrayList<Rent_Record>();
	Rent_Record  r=new Rent_Record();
	
	
	public List<Rent_Record>  listSrv(){
	
	n=ccrd.listRecord();
	return n;
	}
	
	public int add(Rent_Record r){
		//this.r=r;
		return ccrd.insert_record(r);
	}
	
	
	public int updateq(Rent_Record r){
		return  ccrd.update_record(r);
	}	
	
}
