package com.example.chronometer_test;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends Activity {

	private Chronometer chronometer = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		chronometer = (Chronometer) findViewById(R.id.chronometer);
	}
	public void onReset(View view){
		chronometer.setBase(SystemClock.elapsedRealtime());
	}
	public void onStop(View view){
		chronometer.stop();
	}
	public void onStart(View view){
		chronometer.start();
	}
}
