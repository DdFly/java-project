package com.example.idao;

public class User {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String phone;
	public User(int id,String name,String sex,int age,String phone){
		this.age = age;
		this.id = id;
		this.sex = sex;
		this.name = name;
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
