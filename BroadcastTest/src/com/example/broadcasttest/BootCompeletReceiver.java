package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompeletReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO �Զ����ɵķ������
		Toast.makeText(arg0, "�����ɹ�", Toast.LENGTH_SHORT).show();
	}

}
