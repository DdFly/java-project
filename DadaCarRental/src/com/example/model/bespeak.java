package com.example.model;

import java.sql.Date;

public class bespeak {
	private int Bes_Id;
	private int DesD_Is;
	private double Deposit;
	private Date  Car_RentDate;
	private Date  Car_BackDate;
	private String Cus_IDNum;
	private String Car_Name;
	private String Cus_Drilicense_Id;
	public int getBes_Id() {
		return Bes_Id;
	}
	public void setBes_Id(int bes_Id) {
		Bes_Id = bes_Id;
	}
	public int getDesD_Is() {
		return DesD_Is;
	}
	public void setDesD_Is(int desD_Is) {
		DesD_Is = desD_Is;
	}
	public double getDeposit() {
		return Deposit;
	}
	public void setDeposit(double deposit) {
		Deposit = deposit;
	}
	public Date getCar_RentDate() {
		return Car_RentDate;
	}
	public void setCar_RentDate(Date car_RentDate) {
		Car_RentDate = car_RentDate;
	}
	public Date getCar_BackDate() {
		return Car_BackDate;
	}
	public void setCar_BackDate(Date car_BackDate) {
		Car_BackDate = car_BackDate;
	}
	public String getCus_IDNum() {
		return Cus_IDNum;
	}
	public void setCus_IDNum(String cus_IDNum) {
		Cus_IDNum = cus_IDNum;
	}
	public String getCar_Name() {
		return Car_Name;
	}
	public void setCar_Name(String car_Name) {
		Car_Name = car_Name;
	}
	public String getCus_Drilicense_Id() {
		return Cus_Drilicense_Id;
	}
	public void setCus_Drilicense_Id(String cus_Drilicense_Id) {
		Cus_Drilicense_Id = cus_Drilicense_Id;
	}
}
