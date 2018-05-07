package com.example.listview;

import android.graphics.drawable.Drawable;

public class Fruit {
	private String name;
	private int imageId;
	private String beizhu;
	public Fruit(String arr,int icons,String beizhu){
		this.name=arr;
		this.imageId=icons;
		this.beizhu=beizhu;
	}
	public String getName(){
		return name;
	}
	public int getImageId(){
		return imageId;
	}
	public String getBeizhu(){
		return beizhu;
	}

}
