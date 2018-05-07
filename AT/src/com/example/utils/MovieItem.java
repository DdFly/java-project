package com.example.utils;

import android.graphics.Bitmap;

public class MovieItem {
	private Bitmap image;
	private String name;
	private double grade;
	private int buyId;
	private String mText;
	private int time;
	public MovieItem(Bitmap image,String name,double d,int buyId,String mText,int time){
		this.image = image;
		this.name = name;
		this.grade = d;
		this.buyId = buyId;
		this.mText = mText;
		this.setTime(time);
	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}
	public double getGrade() {
		return grade;
	}
	public int getBuyId() {
		return buyId;
	}
	public String getMText(){
		return mText;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}

