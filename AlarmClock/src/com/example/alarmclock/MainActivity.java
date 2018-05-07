package com.example.alarmclock;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	TimePicker picker;
	Calendar c;
	Button bt1;
	Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt1 = (Button) findViewById(R.id.set);
		bt2 = (Button) findViewById(R.id.select);
		picker = (TimePicker) findViewById(R.id.time);
		c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		picker.setIs24HourView(true);
		picker.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
		picker.setCurrentMinute(c.get(Calendar.MINUTE));
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Bundle bundle = new Bundle();
				
				Intent intent = new Intent(MainActivity.this,AlarmService.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
				AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
				c.set(Calendar.HOUR_OF_DAY, picker.getCurrentHour());
				c.set(Calendar.MINUTE, picker.getCurrentMinute());
				manager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
				Toast.makeText(MainActivity.this,"闹钟设置成功", Toast.LENGTH_SHORT).show();
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				ListView list = new ListView(getBaseContext());
				new AlertDialog.Builder(getBaseContext())
				.setTitle("选择闹钟铃声").setView(list)
				.create().show();
				
			}
		});
		
		
	}

	
}
