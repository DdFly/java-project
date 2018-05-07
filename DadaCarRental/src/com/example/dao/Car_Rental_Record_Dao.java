package com.example.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.example.dal.DBUtil;
import com.example.model.Rent_Record;

public class Car_Rental_Record_Dao {
	DBUtil db = new DBUtil();
	//返回所有的租车记录
	public List<Rent_Record> listRecord(){
		List<Rent_Record> LRecord=null;
		LRecord = new LinkedList<Rent_Record>();
		String sql = "select * from Rent_Record";
		try{
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			while(rst.next()){
				Rent_Record r = new Rent_Record();
				r.setRec_Id(rst.getInt("Rec_Id"));
				r.setCar_Id(rst.getInt("Car_Id"));
				r.setE_Id(rst.getInt("E_Id"));
				r.setCus_IDNum(rst.getString("Cus_IDNum"));
				r.setCar_RentDate(rst.getDate("Car_RentDate"));
				r.setCar_BackDate(rst.getDate("Car_BackDate"));
				r.setCar_IsBack(rst.getInt("Car_IsBack"));
				r.setCar_RentMoney(rst.getDouble("Car_RentMoney"));
				r.setDesD_Id(rst.getInt("DesD_Id"));
				r.setDeposit(rst.getDouble("Deposit"));
				r.setDesD_Is(rst.getInt("DesD_Is"));
				LRecord.add(r);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return LRecord;
}
	//插入一条租车记录
	public int insert_record(Rent_Record r){
		try {
			String sql = "insert into Rent_Record(Rec_Id, Car_Id,E_Id, Cus_IDNum,Car_RentDate, Car_BackDate,Car_IsBack,DesD_Is,DesD_Id ,Car_RentMoney,Deposit)"
					+ " values("
					+ r.getRec_Id()
					+ ", "
					+ r.getCar_Id()
					+","
					+r.getE_Id()
					+",'"
					+r.getCus_IDNum()
					+"',"
					+ ", '" + r.getCar_RentDate() 
					+ "', '" + r.getCar_BackDate()
					+"', "+r.getCar_IsBack()
					+", "+r.getDesD_Is()
					+","+r.getCar_RentMoney()
					+", "+r.getDesD_Id()
					+","
					+r.getDeposit()
					+ " )";
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return 0;
			}
			ResultSet rst = db.execQuery(sql);
			if (rst!=null && rst.first()) {
				r.setRec_Id(rst.getInt(1));
			}
			db.close(rst);
			db.close();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
}
	
	public int update_record(Rent_Record r){
		try{
			String sql = "update Rent_Record set Car_BackDate="+r.getCar_BackDate()+" where Rec_Id = "+r.getRec_Id();
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return 0;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null){
				return 1;
			}
			db.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
