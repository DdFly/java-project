package com.game2048.app.model;

import com.game2048.app.activity.MainActivity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class record {
	private int recore;
	private int step;
	private int max;
//	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.getContext());
//	SharedPreferences.Editor editor = pref.edit();
	private static final record r = new record();
	private record(){
		recore=0;
		step=0;
		//max=pref.getInt("Max", 0);
	}
	public static record getRecord(){
		return r;
	}
	public int getRecore() {
		return recore;
	}
	public void setRecore(int recore) {
		this.recore = recore;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max){
		this.max=max;
	}

}
