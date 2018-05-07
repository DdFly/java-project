package com.example.jishiqi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn_miaobiao).setOnClickListener(this);
		findViewById(R.id.btn_daojishi).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.btn_miaobiao:
			Intent intent = new Intent(MainActivity.this,Miaobiao.class);
			startActivity(intent);
			break;
		case R.id.btn_daojishi:
			Intent intent2 = new Intent(MainActivity.this,Daojishi.class);
			startActivity(intent2);
			break;
		}
	}


}
