package com.example.broadcastpractice;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	public Button back;
	SharedPreferences pre;
	TextView zhanghao;
	TextView save;
	TextView silence;
	TextView hide;
	TextView both;
	TextView accSys;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		zhanghao = (TextView) findViewById(R.id.user);
		save = (TextView) findViewById(R.id.save_password);
		silence = (TextView) findViewById(R.id.silence_login);
		hide = (TextView) findViewById(R.id.hide_login);
		both = (TextView) findViewById(R.id.accept_accounts);
		accSys = (TextView) findViewById(R.id.accept_troopmsg);
		pre = getSharedPreferences("data", MODE_APPEND);
		//Editor editor = pre.edit();
		back = (Button) findViewById(R.id.xiaxian);
		zhanghao.setText(zhanghao.getText().toString());
		//save.setText(save.getText()+pre.getBoolean("savePassword",false));
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
				sendBroadcast(intent);
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO 自动生成的方法存根
		super.onBackPressed();
		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("退出询问");
		builder.setMessage("是否突出登录？");		
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO 自动生成的方法存根
				
			}
		});
		builder.setNegativeButton("取消", null);
		builder.create().show();
		
	}
	


}
