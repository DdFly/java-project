package com.example.notificationtest;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NotificationActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		manager.cancel(1);
		
	}
	

}
