package com.example.chijiuhua;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Shared extends Activity{
	EditText zhanghao;
	EditText mima;
	Button Login;
	CheckBox check;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_layout);
		zhanghao = (EditText) findViewById(R.id.name);
		mima = (EditText) findViewById(R.id.edit2);
		Login = (Button) findViewById(R.id.login);
		check = (CheckBox) findViewById(R.id.save_passworld);
		SharedPreferences pre = getSharedPreferences("data",MODE_PRIVATE);
		zhanghao.setText(pre.getString("账号", null));
		mima.setText(pre.getString("密码", null));
		Login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				if(zhanghao.getText().toString().equals("111") && mima.getText().toString().equals("aaa")){
					SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
					if(check.isChecked()){						
						editor.putString("账号", zhanghao.getText().toString());
						editor.putString("密码", mima.getText().toString());
						
					}
					else if(!check.isChecked()){
						editor.clear();
					}
					editor.commit();
					
					Toast.makeText(Shared.this, "登陆成功了，哈哈哈", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
