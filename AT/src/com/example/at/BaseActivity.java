package com.example.at;

import com.example.utils.ActivityCollector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {
	public static int loginId;
	public static String loginName;
	public static String loginPsw;
	public static boolean isSavePsw;
	public static Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		//Log.d("BaseActivity", getClass().getSimpleName());
		ActivityCollector.addActivity(this);
		context = getApplicationContext();
	}
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}
