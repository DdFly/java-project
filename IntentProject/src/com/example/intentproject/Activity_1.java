package com.example.intentproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_1 extends Activity{
	TextView text;
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.activity_1);
		Intent intent = getIntent();
		text = (TextView) findViewById(R.id.aty1_t1);
		text.setText(intent.getStringExtra("value_1"));
		
	}

}
