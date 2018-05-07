package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO 自动生成的方法存根
		Toast.makeText(arg0, "广播发送成功了", Toast.LENGTH_SHORT).show();
		abortBroadcast();
	}

}
