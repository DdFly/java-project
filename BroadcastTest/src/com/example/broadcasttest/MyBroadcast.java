package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO �Զ����ɵķ������
		Toast.makeText(arg0, "�㲥���ͳɹ���", Toast.LENGTH_SHORT).show();
		abortBroadcast();
	}

}
