package com.example.broadcastpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements OnClickListener{
	private EditText zhanghao;
	private EditText mima;
	private Button denglu;
	private Button clear;
	private Button regist;
	private TextView moreBotton;
	private View morehideBotton;
	private View input2;
	private boolean showBotton = false;
	private SharedPreferences pre;
	private SharedPreferences.Editor editor;
	CheckBox savePassword;
	CheckBox hideLogin;
	CheckBox silence;
	CheckBox bothOnline;
	CheckBox acceptSys;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		zhanghao = (EditText) findViewById(R.id.zhanghao);
		mima = (EditText) findViewById(R.id.mima);
		denglu = (Button) findViewById(R.id.login);
		clear = (Button) findViewById(R.id.clear);
		input2 = findViewById(R.id.input2);
		savePassword = (CheckBox) findViewById(R.id.save_password);
		morehideBotton = findViewById(R.id.morehidebottom);
		silence = (CheckBox) findViewById(R.id.silence_login);
		hideLogin = (CheckBox) findViewById(R.id.hide_login);
		bothOnline = (CheckBox) findViewById(R.id.accept_accounts);
		acceptSys = (CheckBox) findViewById(R.id.accept_troopmsg);		
		pre = getSharedPreferences("data", MODE_APPEND);
		editor = pre.edit();
		initView();
	}
	private void initView(){		
		zhanghao.setText(pre.getString("user", ""));
		mima.setText(pre.getString("password", ""));
		savePassword.setChecked(pre.getBoolean("savePassword", false));
		silence.setChecked(pre.getBoolean("silence", false));
		hideLogin.setChecked(pre.getBoolean("hideLogin",false));
		bothOnline.setChecked(pre.getBoolean("bothOnline", false));
		acceptSys.setChecked(pre.getBoolean("acceptSys", false));
		denglu.setOnClickListener(this);
		clear.setOnClickListener(this);
		input2.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.login:
			if (zhanghao.getText().toString().equals("111") && mima.getText().toString().equals("aaa")){
				Intent intent = new Intent(LoginActivity.this,MainActivity.class);
				editor.putString("zhanghao", zhanghao.getText().toString());
				editor.putString("password", mima.getText().toString());
				editor.putBoolean("savePassword", savePassword.isChecked());
				editor.putBoolean("silence", silence.isChecked());
				editor.putBoolean("hideLogin", hideLogin.isChecked());
				editor.putBoolean("bothOnline", bothOnline.isChecked());
				editor.putBoolean("acceptSys", acceptSys.isChecked());
				startActivity(intent);
				finish();
			}
			else{
				Toast.makeText(LoginActivity.this, "账号或密码错误，请重新的输入", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.clear:
			zhanghao.setText("");
			mima.setText("");
		case R.id.regist:
			
			break;
		case R.id.input2:
			showMoreBotton();
			break;
		}
	}
	public void showMoreBotton(){
		if(!showBotton){
			morehideBotton.setVisibility(View.VISIBLE);
			showBotton=true;
		}
		else{
			morehideBotton.setVisibility(View.GONE);
			showBotton=false;
		}
	}
	
	

}
