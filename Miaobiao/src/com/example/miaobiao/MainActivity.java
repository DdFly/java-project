package com.example.miaobiao;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private Button start,stop,reset;
	private TextView text;
	public LooperThread thread;
	public Handler handle;
	int time=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		thread = new LooperThread();
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		reset = (Button) findViewById(R.id.reset);
		text = (TextView) findViewById(R.id.text);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		reset.setOnClickListener(this);
		handle = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO 自动生成的方法存根
				super.handleMessage(msg);
				if (msg.what==1){
					text.setText(time+"");
				}
			}
			
		};
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.start:
			thread.start();
			break;
		case R.id.stop:
			thread.suspend();			
			break;
			
		case R.id.reset:
			thread.stop();
			time=0;
			text.setText(0);
			break;
		}
	}
	
	class LooperThread extends Thread{

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			super.run();
			do{
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				time=time+1;
				Message message = new Message();
				message.what=1;
				MainActivity.this.handle.sendMessage(message);
				
			}while(MainActivity.LooperThread.interrupted()==false);
		}
	}

}

