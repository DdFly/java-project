package com.example.myclock;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener{

	private List<Clock> clockList = new ArrayList<Clock>();
	ListView listview;
	Button addClock;
	Button setting;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		addClock = (Button) findViewById(R.id.add);
		setting = (Button) findViewById(R.id.set);
		listview = (ListView) findViewById(R.id.clockList);
		setting.setOnClickListener(this);
		addClock.setOnClickListener(this);
		clockAdapter adapter = new clockAdapter(MainActivity.this, R.layout.clocklist_item, clockList);
		listview.setAdapter(adapter);
	}
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.add:
			
			break;
		case R.id.set:
			
			break;
			default:
		}
	}

}
