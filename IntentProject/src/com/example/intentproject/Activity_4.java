package com.example.intentproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity_4 extends Activity{
	public static final String ACTION = "com.example.intentproject.action.intent.Activity_4";
	Intent intent;
	TextView text;
	Button button;
	public void onCreate(Bundle bundle){
		
		super.onCreate(bundle);
		setContentView(R.layout.activity_4);
		intent = getIntent();
		text = (TextView)findViewById(R.id.aty4_t1);
		text.setText(intent.getStringExtra("value_4"));
		button = (Button)findViewById(R.id.button_result);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent2 = new Intent();
				intent2.putExtra("value_return", "通过按钮返回来了，哈哈哈！");
				setResult(RESULT_OK, intent2);
				finish();
			}
		});

		
	}
	public void onBackPressed(){
		Intent intent2 = new Intent();
		intent2.putExtra("value_return", "通过返回键返回来了，哈哈哈！");
		setResult(RESULT_OK, intent2);
		finish();
	}
}
