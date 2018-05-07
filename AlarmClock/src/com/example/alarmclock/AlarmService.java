package com.example.alarmclock;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.Window;
import android.view.WindowManager;

public class AlarmService extends Activity{
	MediaPlayer player = new MediaPlayer();
	private PowerManager.WakeLock mWakelock;
	Vibrator vibrator;
	@Override
	protected void onPause() {
		// TODO �Զ����ɵķ������
		super.onPause();
		releaseWakeLock();
	}

	private void releaseWakeLock(){
		if(mWakelock != null && mWakelock.isHeld()){
			mWakelock.release();
			mWakelock = null;
		}
	}
	@Override
	protected void onResume() {
		// TODO �Զ����ɵķ������
		super.onResume();
		acquireWakeLock();
	}
	private void acquireWakeLock(){
		if(mWakelock ==null){
			PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
			mWakelock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, this.getClass().getCanonicalName());
			mWakelock.acquire();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
		long[] v = {1000,1000,1000,1000};
		winParams.flags = (WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED 
				| WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		Builder dialog = new AlertDialog.Builder(this);
		//setRequestedOrientation(0);
		try {
			File file = new File(Environment.getExternalStorageDirectory(),"/Music/�°�Сҹ��.mp3");
			player.setDataSource(file.getPath());
			player.prepare();
		} catch (IllegalArgumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		dialog.setTitle("���ӣ�����");
		dialog.setMessage("��������,������");
		dialog.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO �Զ����ɵķ������
				player.stop();
				player.release();
				vibrator.cancel();
				finish();
			}
		});
		dialog.setCancelable(false);
		dialog.create().show();
		player.start();
		vibrator.vibrate(v, 0);


	}


}