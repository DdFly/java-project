package com.example.attms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {

	EditText phone_edit;
	EditText passw_edit;
	Button login_bt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getActionBar().hide();
		login_bt = (Button) findViewById(R.id.signin_button);
		phone_edit = (EditText) findViewById(R.id.username_edit);
		passw_edit = (EditText) findViewById(R.id.password_edit);
		login_bt.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}

}
