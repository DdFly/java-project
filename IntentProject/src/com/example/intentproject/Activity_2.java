package com.example.intentproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_2 extends Activity{
	public static final String ACTION = "com.example.intentproject.action.intent.Activity_2";
	TextView text;
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.activity_2);
		Intent intent = getIntent();
		text = (TextView)findViewById(R.id.aty2_t1);
		text.setText(intent.getStringExtra("value_2"));
	}

}
