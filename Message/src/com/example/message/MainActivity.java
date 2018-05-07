package com.example.message;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private TextView sender;
	private TextView context;
	private Button send;
	private Button call;
	private Button camera;
	private Button music;
	private Button vedio;
	private IntentFilter intentFilter;
//	private MessageReceiver messageReceiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sender = (TextView) findViewById(R.id.number);
		context = (TextView) findViewById(R.id.context);
		send = (Button) findViewById(R.id.sendMessage);
		call = (Button) findViewById(R.id.call_1008611);
		camera = (Button) findViewById(R.id.openCamera);
		music = (Button) findViewById(R.id.mediaPlayer);
		vedio = (Button) findViewById(R.id.videoView);
		camera.setOnClickListener(this);
		send.setOnClickListener(this);
		call.setOnClickListener(this);
		music.setOnClickListener(this);
		vedio.setOnClickListener(this);
		intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVER");
		//intentFilter.addAction();
		//messageReceiver = new MessageReceiver();
		//registerReceiver(messageReceiver, intentFilter);
		
		
	}
//	protected void onDestory(){
//		super.onDestroy();
//		unregisterReceiver(messageReceiver);
//	}
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.sendMessage:
			Intent intent1 = new Intent(Intent.ACTION_SENDTO);
			intent1.setData(Uri.parse("smsto:10086"));
			intent1.putExtra("sms_body", "3053");
			startActivity(intent1);
			break;
		case R.id.call_1008611:
			Intent intent2 = new Intent(Intent.ACTION_CALL);
			intent2.setData(Uri.parse("tel:1008611"));
			startActivity(intent2);
			break;
		case R.id.openCamera:
			Intent intent3 = new Intent("android.media.action.IMAGE_CAPTURE");
			break;
		case R.id.mediaPlayer:
			Intent intent4 = new Intent(MainActivity.this,music.class);
			startActivity(intent4);
			break;
		case R.id.videoView:
			Intent intent5 = new Intent(MainActivity.this,vedio.class);
			startActivity(intent5);
			
			break;
		}
	}
//	class MessageReceiver extends BroadcastReceiver{
//
//		
//		public void onReceive(Context arg0, Intent arg1) {
//			// TODO 自动生成的方法存根
//			//18892080665
//			Bundle bundle = arg1.getExtras();
//			Object[] pdus = (Object[]) bundle.get("pdus");
//			SmsMessage[] messages = new SmsMessage[pdus.length];
//			for (int i=0;i<messages.length;i++){
//				messages[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
//			}
//			String adress = messages[0].getOriginatingAddress();
//			String FullMessage="";
//			for(SmsMessage message:messages){
//				FullMessage += message.getMessageBody();
//			}
//			sender.setText(adress);
//			context.setText(FullMessage);
//		}
//	}

	
}
