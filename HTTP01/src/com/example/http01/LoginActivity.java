package com.example.http01;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {

	private Button bt_regist;
	private Button bt_login;
	private Button bt_forgetPass;
	private Button bt_clean;
	private Button bt_passVisiable;
	private EditText edit_name;
	private EditText edit_pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		bt_regist = (Button) findViewById(R.id.regist_id);
		bt_login = (Button) findViewById(R.id.login);
		bt_forgetPass = (Button) findViewById(R.id.forget);
		bt_clean = (Button) findViewById(R.id.clean);
		bt_passVisiable = (Button) findViewById(R.id.pass_visiable);
		edit_name = (EditText) findViewById(R.id.name_input);
		edit_pass = (EditText) findViewById(R.id.pass_input);
		bt_regist.setOnClickListener(this);
		bt_login.setOnClickListener(this);
		bt_forgetPass.setOnClickListener(this);
		bt_passVisiable.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch (arg0.getId()) {
		case R.id.login:

			break;
		case R.id.regist_id:
			break;
		case R.id.forget:
			break;
		case R.id.clean:
			break;
		case R.id.pass_visiable:
			break;
		default:
			break;
		}
	}

}
