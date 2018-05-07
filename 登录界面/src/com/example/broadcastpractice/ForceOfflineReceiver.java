package com.example.broadcastpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(final Context context, Intent arg1) {
		// TODO 自动生成的方法存根
		AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(context);
		dialogbuilder.setTitle("错误");
		dialogbuilder.setMessage("未知原因。您已强制下线！请重新登录");
		dialogbuilder.setCancelable(false);
		dialogbuilder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO 自动生成的方法存根
				ActivityCollector.finishAll();
				Intent intent = new Intent(context,LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		AlertDialog alertdialog = dialogbuilder.create();
		alertdialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertdialog.show();	
	}
	

}
