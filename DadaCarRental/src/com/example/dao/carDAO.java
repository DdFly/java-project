package com.example.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.example.dal.DBUtil;
import com.example.model.Car;

/**
 * 汽车增、删、改、查
 * 
 */
public class carDAO {
	DBUtil db=new DBUtil();
	
	public int insert_car(Car c){
		try{
			String sql=" insert into Car values("+c.getCar_Id()+","+c.getCar_Name()+","+c.getCar_Type()+","+
					","+c.getCar_Count()+","+c.getCar_Door()+","+c.getCar_Window()+","+c.getCar_GPS()+","+c.getCar_Oil()+","+
					c.getCar_Gasbag()+","+c.getCar_Color()+","+c.getCar_Image()+","+c.getCar_IsUseful()+","+","+c.getCar_Description()+")";
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return 0;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null)
				return 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
//修改车辆是否还可以继续使用	
	public int delete_car(int id){
		int flag=0;
		try{
			String sql = "update Car set Car_IsUseful where Car_Id="+id;
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return flag;
			}
			 flag=db.execCommand(sql);
			 return flag;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return 0;
	}
	//更新车辆信息
	public int update_car(Car car){
		try{
			String sql = "update Car set Car_Color ="+car.getCar_Color()+",Car_IsUseful="+car.getCar_IsUseful()+",Car_Description"+car.getCar_Description()+" where Car_Id="+car.getCar_Id();
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return 0;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null)
				return 1;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return 0;
	}
	public Car select_car(int id){
		return null;
	}
	public List<Car> fetchAll_car(){	
		List<Car> list = new LinkedList<Car>();
		
		return null;
		
	}
}
