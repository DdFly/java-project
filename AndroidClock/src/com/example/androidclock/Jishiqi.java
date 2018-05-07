package com.example.androidclock;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

public class Jishiqi extends Activity implements OnClickListener{
	private Chronometer chronmeter = null;
	public Button start;
	public Button stop;
	public Button reset;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jishiqi_xml);
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		reset = (Button) findViewById(R.id.reset);
		chronmeter = (Chronometer) findViewById(R.id.jishiqi);
		chronmeter.setBase(SystemClock.elapsedRealtime());
		//SimpleDateFormat format = new SimpleDateFormat("HH-mm-SS");
		chronmeter.setFormat("%s");
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		reset.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch(v.getId()){
		case R.id.start:
			chronmeter.start();
			break;
		case R.id.stop:
			chronmeter.stop();
			break;
		case R.id.reset:
			chronmeter.setBase(SystemClock.elapsedRealtime());
			chronmeter.stop();
			break;
		}
	}

}
