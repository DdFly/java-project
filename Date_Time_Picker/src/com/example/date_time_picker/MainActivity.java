package com.example.date_time_picker;

import java.util.MissingFormatArgumentException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button1;
	private DatePicker date;
	private TimePicker time;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) findViewById(R.id.dateSelect);
		date = (DatePicker) findViewById(R.id.datePic1);
		time = (TimePicker) findViewById(R.id.timePic1);
		time.setIs24HourView(true);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				int h = time.getCurrentHour();
				int m = time.getCurrentMinute();
				int c = time.getChildCount();
				int y = date.getYear();
				int M = date.getMonth();
				int d = date.getDayOfMonth();
				//Toast.makeText(MainActivity.this, y+"年"+M+"月"+d+"日", Toast.LENGTH_SHORT).show();
				Toast.makeText(MainActivity.this, y+"年"+M+"月"+d+"日  "+h+":"+m+":"+c, Toast.LENGTH_SHORT).show();
			}
		});
		time.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				// TODO 自动生成的方法存根
				Toast.makeText(MainActivity.this,arg1+":"+arg2, Toast.LENGTH_SHORT).show();
			}
		});
		/*button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
			}
		});*/
	}


}
