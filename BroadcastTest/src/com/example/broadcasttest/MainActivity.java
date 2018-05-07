package com.example.broadcasttest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private IntentFilter intentfilter; 
	private NetworkChanceRecever network;
	public Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		send = (Button) findViewById(R.id.btn_send);
		intentfilter = new IntentFilter();
		network = new NetworkChanceRecever();
		intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		registerReceiver(network, intentfilter);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent("com.example.broadcasttest.MyBroadcast");
				sendOrderedBroadcast(intent, null);
			}
		});
		
	}
	protected void onDestroy(){
		super.onDestroy();
		unregisterReceiver(network);
	}
	class NetworkChanceRecever extends BroadcastReceiver{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO 自动生成的方法存根
			ConnectivityManager connectmanager = (ConnectivityManager)getSystemService(arg0.CONNECTIVITY_SERVICE);
			NetworkInfo networkinfo = connectmanager.getActiveNetworkInfo();
			if (networkinfo!=null && networkinfo.isAvailable())
				Toast.makeText(arg0, "正在使用网络", Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(arg0, "无网络连接", Toast.LENGTH_SHORT).show();
		}
		
	}


}
