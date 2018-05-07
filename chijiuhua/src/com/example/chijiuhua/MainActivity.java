package com.example.chijiuhua;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private Button btn1;
	private Button btn2;
	private Button btn3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button)findViewById(R.id.wenjian);
		btn2 = (Button) findViewById(R.id.shared);
		btn3 = (Button) findViewById(R.id.SQL);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		Intent intent;
		switch(arg0.getId()){
		case R.id.wenjian:
			intent = new Intent(MainActivity.this,WenjianSave.class);
			startActivity(intent);
			break;
		case R.id.shared:
			intent = new Intent(MainActivity.this,Shared.class);
			startActivity(intent);
			break;
		case R.id.SQL:
			
			break;
		}
	}


}
