package com.example.myclock;

import java.util.Calendar;

import android.net.Uri;

public class Clock {
	private String information;
	private String time;
	private boolean turn;
	private Uri uri;
	public Clock(String information,String time,boolean turn,Uri uri){
		this.time = time;
		this.information = information;
		this.turn = turn;
		this.uri = uri;
	}
	public String getInf(){
		return information;
	}
	public String getTime(){
		return time;
	}
	public boolean getTurn(){
		return turn;
	}
	public Uri getUri(){
		return uri;
	}
}
