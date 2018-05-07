package com.example.jishiqi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class Daojishi extends Activity implements OnClickListener{

	int i;
	EditText edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.daojishi);
		edit = (EditText) findViewById(R.id.edit_setTime);
		findViewById(R.id.btn_daojishi_getTime).setOnClickListener(this);
		findViewById(R.id.btn_daojishi_start).setOnClickListener(this);
		findViewById(R.id.btn_daojishi_stop).setOnClickListener(this);
		findViewById(R.id.btn_daojishi_reset).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.btn_daojishi_getTime:
			i = Integer.parseInt(edit.getText().toString());
			
			break;
		case R.id.btn_daojishi_start:
			
			break;
		case R.id.btn_daojishi_stop:
			
			break;
		case R.id.btn_daojishi_reset:
			
			break;
		}
	}

}
