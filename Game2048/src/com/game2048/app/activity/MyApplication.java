package com.game2048.app.activity;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

	private static Context context;
	@Override
	public void onCreate() {
		// TODO 自动生成的方法存根
		context = getApplicationContext();
	}
	public static Context getContext(){
		return context;
	}

}
