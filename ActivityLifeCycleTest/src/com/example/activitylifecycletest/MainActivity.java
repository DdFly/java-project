package com.example.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.storage.OnObbStateChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public static final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState!=null){
			String data = savedInstanceState.getString("date_key");
			Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
		}
		Log.d(TAG,"onCreate");
		setContentView(R.layout.activity_main);
		Button startNormalActivity = (Button)findViewById(R.id.start_normal_activity);
		Button startDialogActivity = (Button)findViewById(R.id.start_dialog_activity);
		startNormalActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this,NormalActivity.class);
				startActivity(intent);
			}
		});
		startDialogActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this,DialogActivity.class);
				startActivity(intent);
			}
		});
	}
	
	public void onStart(){
		super.onStart();
		Log.d(TAG, "onStart");
	}
	
	public void onStop(){
		super.onStop();
		Log.d(TAG, "onStop");
	}
	
	public void onResume(){
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		Log.d(TAG, "onDestory");
	}

	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	protected void onRestart() {
		// TODO 自动生成的方法存根
		super.onRestart();
		Log.d(TAG, "onRestart");
	}
	protected void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		String tempData = "hahahahahahahahaha";
		outState.putString("date_key", tempData);
		
	}
	
	

}
