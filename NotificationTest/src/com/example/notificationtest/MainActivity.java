package com.example.notificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	NotificationManager manager;
	Button send;
	Button cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		send = (Button) findViewById(R.id.send);
		cancel = (Button) findViewById(R.id.cancel);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Notification notification = new Notification(R.drawable.movie7,"通知创建成功了",System.currentTimeMillis());				
				Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
				PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT); 
				notification.setLatestEventInfo(MainActivity.this, "这是通知标题", "哈哈哈，这是通知内容", pi);
//				long[] vibrates = {0,500,500,500};
//				notification.vibrate = vibrates;
//				notification.ledARGB=Color.RED;
//				notification.ledOnMS=1000;
//				notification.ledOffMS=1000;
//				notification.flags = Notification.FLAG_SHOW_LIGHTS;
				notification.defaults = Notification.DEFAULT_ALL;
				manager.notify(1, notification);
				
				
			}
		});
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				manager.cancel(1);
			}
		});
	}

}
