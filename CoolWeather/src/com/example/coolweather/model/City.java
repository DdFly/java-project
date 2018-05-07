package com.example.coolweather.model;

public class City {
	private int id;
	private String cityName;
	private String cityCode;
	private int provincdId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public int getProvincdId() {
		return provincdId;
	}
	public void setProvincdId(int provincdId) {
		this.provincdId = provincdId;
	}
	
}
