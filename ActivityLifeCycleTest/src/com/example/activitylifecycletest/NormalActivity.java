package com.example.activitylifecycletest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class NormalActivity extends Activity{
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.normal_layout);
		
	}
}
