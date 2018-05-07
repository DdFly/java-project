package com.example.utils;

import android.app.SearchManager.OnCancelListener;

public class MovieItem {
	private int imgId;
	private String name;
	private double grade;
	private int buyId;
	private String mText;
	public MovieItem(int imgId,String name,double d,int buyId,String mText){
		this.imgId = imgId;
		this.name = name;
		this.grade = d;
		this.buyId = buyId;
		this.mText = mText;
	}
	public int getImgId(){
		return imgId;
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
	
}

