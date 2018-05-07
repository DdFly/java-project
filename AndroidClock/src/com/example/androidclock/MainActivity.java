package com.example.androidclock;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected static final int GUINOTIFIER = 0x1234;
	public TextView textview;
	public TextView textview1;
	public TextView textview2;
	public AnalogClock analogClock;
	public Calendar calendar;
	public int minutes;
	public int hour;
	public int second;
	public int year;
	public int mouth;
	public int day;
	public int week;
	public Handler handler;
	public Thread thread;
	public Button miaobiao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textview2 = (TextView) findViewById(R.id.TextView2);
		textview1 = (TextView) findViewById(R.id.TextView1);
		textview = (TextView)findViewById(R.id.TextView);
		analogClock = (AnalogClock) findViewById(R.id.AnalogClock);
		handler = new Handler(){
			public void handleMessage(Message msg){
				switch(msg.what){
				case MainActivity.GUINOTIFIER:
					textview.setText(year+"年"+mouth+"月"+day+"日");
					switch(week){
					case 1:textview1.setText("星期日");break;
					case 2:textview1.setText("星期一");break;
					case 3:textview1.setText("星期二");break;
					case 4:textview1.setText("星期三");break;
					case 5:textview1.setText("星期四");break;
					case 6:textview1.setText("星期五");break;
					case 7:textview1.setText("星期六");break;
					}
					textview2.setText(hour+":"+minutes+":"+second);
					break;
				}
				super.handleMessage(msg);
			}
		};
		thread = new LooperThread();
		thread.start();
		miaobiao = (Button) findViewById(R.id.miaobiao);
		miaobiao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this,Jishiqi.class);
				startActivity(intent);
			}
		});
	}
	
	class LooperThread extends Thread{
		public void run(){
			super.run();
			try{
				do{
					long time = System.currentTimeMillis();
					final Calendar calendar = Calendar.getInstance();
					year = calendar.get(Calendar.YEAR);
					mouth = calendar.get(Calendar.MONTH);
					day = calendar.get(Calendar.DAY_OF_MONTH);
					week = calendar.get(Calendar.DAY_OF_WEEK);
					hour = calendar.get(Calendar.HOUR_OF_DAY);
					minutes = calendar.get(Calendar.MINUTE);
					second = calendar.get(Calendar.SECOND);
					Message m = new Message();
					m.what = MainActivity.GUINOTIFIER;
					MainActivity.this.handler.sendMessage(m);
					Thread.sleep(1000);
					
				}while(MainActivity.LooperThread.interrupted()==false);
			}catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(MainActivity.this, "钟表异常", Toast.LENGTH_SHORT);
				finish();
			}
		}
	}

}
