package com.example.calculatorprotect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity{
	public static final String ACTION = "com.example.calculatorprotect.intent.action.SecondActivity";
	Button button;
	TextView text;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent("com.example.intentproject.action.intent.Activity");
				startActivity(intent);
				finish();
			}
		});
	}
}
