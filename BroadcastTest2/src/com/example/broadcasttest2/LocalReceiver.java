package com.example.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO �Զ����ɵķ������
		Toast.makeText(arg0, "���ع㲥���ͳɹ���", Toast.LENGTH_SHORT).show();
	}
		
}
