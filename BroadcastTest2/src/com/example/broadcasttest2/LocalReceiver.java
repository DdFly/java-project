package com.example.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO 自动生成的方法存根
		Toast.makeText(arg0, "本地广播发送成功！", Toast.LENGTH_SHORT).show();
	}
		
}
