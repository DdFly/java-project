package com.example.UI;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class barTest extends Activity{

	private Button start;
	private Button login;
	private TextView view1;
	private TextView view2;
	private SeekBar seekBar;
	Handler handler;
	private int barStatus = 0;
	ProgressBar bar1;
	ProgressBar bar2;
	ProgressBar bar3;
	ProgressBar bar4;
	ProgressBar bar5;
	RatingBar starBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bar_layout);
		start = (Button) findViewById(R.id.bar_start);
		login = (Button) findViewById(R.id.login);
		view1 = (TextView) findViewById(R.id.view);
		view2 = (TextView) findViewById(R.id.star);
		seekBar = (SeekBar) findViewById(R.id.seekBar);
		starBar = (RatingBar) findViewById(R.id.starbar);
		bar1 = (ProgressBar) findViewById(R.id.bar1);
		bar2 = (ProgressBar) findViewById(R.id.bar2);
		bar3 = (ProgressBar) findViewById(R.id.bar3);
		bar4 = (ProgressBar) findViewById(R.id.bar4);
		bar5 = (ProgressBar) findViewById(R.id.bar5);
		handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO 自动生成的方法存根
				if(msg.what==1){
					bar1.setProgress(barStatus);
					bar2.setProgress(barStatus);
					bar3.setProgress(barStatus);
					bar4.setProgress(barStatus);
					bar5.setProgress(barStatus);
					view1.setText("进度："+barStatus);
				}
				else{
					bar1.setVisibility(View.GONE);
					bar2.setVisibility(View.GONE);
					bar3.setVisibility(View.GONE);
					bar4.setVisibility(View.GONE);
					Toast.makeText(barTest.this, "进度已完成", Toast.LENGTH_SHORT).show();
				}
			}
			
		};
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				int result = starBar.getProgress();
				float rating = starBar.getRating();
				Toast.makeText(barTest.this, "进度："+result+"，等级："+rating, Toast.LENGTH_SHORT).show();
				view2.setText("等级："+rating);
			}
		});
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO 自动生成的方法存根
				Toast toast = new Toast(barTest.this);
				toast.setDuration(Toast.LENGTH_SHORT);
				LinearLayout lin = new LinearLayout(barTest.this);
				ImageView image = new ImageView(barTest.this);
				image.setScaleType(ScaleType.FIT_XY);
				image.setAdjustViewBounds(true);
				image.setMaxWidth(100);
				image.setMaxHeight(100);
				image.setImageResource(R.drawable.help);
				image.setPadding(0, 0, 5, 0);
				lin.addView(image);
				TextView text = new TextView(barTest.this);
				text.setText("停止滑动");
				text.setTextSize(24);
				lin.addView(text);
				toast.setView(lin);
				toast.setGravity(Gravity.BOTTOM, 0, 0);
				//toast
				toast.show();
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO 自动生成的方法存根
				Toast toast = new Toast(barTest.this);
				toast.setDuration(Toast.LENGTH_SHORT);
				LinearLayout lin = new LinearLayout(barTest.this);
				ImageView image = new ImageView(barTest.this);
				image.setScaleType(ScaleType.FIT_XY);
				image.setAdjustViewBounds(true);
				image.setMaxWidth(100);
				image.setMaxHeight(100);
				image.setImageResource(R.drawable.help);
				image.setPadding(0, 0, 5, 0);
				lin.addView(image);
				TextView text = new TextView(barTest.this);
				text.setText("开始滑动");
				text.setTextSize(24);
				lin.addView(text);
				toast.setView(lin);
				toast.setGravity(Gravity.BOTTOM, 0, 0);
				//toast.setGravity(Gravity., xOffset, yOffset);
				toast.show();
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO 自动生成的方法存根
				barStatus=arg1;
				Message m = new Message();
				m.what=1;
				handler.sendMessage(m);
			}
		});
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				new Thread(new Runnable() {
					public void run() {
						while(true){
							Message m = new Message();
							if(barStatus<100){
								try {
									Thread.sleep(50);								
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
								barStatus+=1;
								m.what=1;
								handler.sendMessage(m);
							}
							else{
								m.what=0;
								handler.sendMessage(m);
								break;
							}
							
							
						}
					}
				}).start();
			}
		});
	}
	
}
