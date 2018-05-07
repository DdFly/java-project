package com.example.broadcasttest2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private LocalBroadcastManager localManager;
	private IntentFilter intentfilter;
	private LocalReceiver local;
	public Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		send = (Button) findViewById(R.id.sendLocal);
		localManager = LocalBroadcastManager.getInstance(this);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent("com.example.broadcasttest2.AnotherBroadcastReceiver");
				localManager.sendBroadcast(intent);
				intentfilter = new IntentFilter();
				local = new LocalReceiver();
				intentfilter.addAction("com.example.broadcasttest2.AnotherBroadcastReceiver");
				localManager.registerReceiver(local, intentfilter);
										
			}
		});		
	}
	protected void onDestroy(){
		super.onDestroy();
		localManager.unregisterReceiver(local);
	}

}
