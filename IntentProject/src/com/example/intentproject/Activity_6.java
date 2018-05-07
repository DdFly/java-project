package com.example.intentproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity_6 extends Activity{
	public static final String ACTION = "com.example.intentproject.action.intent.Activity_6"; 
	TextView text;
	Button button;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_6);
		button = (Button)findViewById(R.id.button_result6);
		text = (TextView)findViewById(R.id.aty6_t1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}
}
