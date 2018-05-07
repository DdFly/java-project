package com.example.jishiqi;

import java.text.Format;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.TaskStackBuilder;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class Miaobiao extends Activity implements OnClickListener{
	
//	public Timer timer;
//	public TimerTask task;
	String format;
	Thread thread = new Thread(){
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			super.run();
			do{
				try {
					sleep(1000);
					time+=1;
					Message message = new Message();
					message.what=1;
					handler.sendMessage(message);					
				
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}while(thread.interrupted()==false);
			
			
			
		}
	};
	public TextView text_time;
	
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.miaobiao);
		findViewById(R.id.btn_miaobiao_start).setOnClickListener(this);
		findViewById(R.id.btn_miaobiao_stop).setOnClickListener(this);
		findViewById(R.id.btn_miaobiao_reset).setOnClickListener(this);
		text_time = (TextView) findViewById(R.id.text_miaobiao);

	};
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO 自动生成的方法存根
			super.handleMessage(msg);
			if(msg.what==1)
				text_time.setText(time+"");
			
		}
	};
	int time=0;
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.btn_miaobiao_start:			
			thread.start();
			break;
		case R.id.btn_miaobiao_stop:
			try {
				thread.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		case R.id.btn_miaobiao_reset:
			thread.stop();
			text_time.setText("0");
			break;
		}
	}

}
