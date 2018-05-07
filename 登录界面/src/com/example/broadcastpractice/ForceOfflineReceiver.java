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
		// TODO �Զ����ɵķ������
		AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(context);
		dialogbuilder.setTitle("����");
		dialogbuilder.setMessage("δ֪ԭ������ǿ�����ߣ������µ�¼");
		dialogbuilder.setCancelable(false);
		dialogbuilder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO �Զ����ɵķ������
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
