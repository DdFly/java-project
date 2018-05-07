package com.example.contacts;

import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	TabHost host;
	Tab tab;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		host = (TabHost) findViewById(android.R.id.tabhost);
		host.setup();
		LayoutInflater inflater = LayoutInflater.from(this);
		inflater.inflate(R.id.tab01, host.getTabContentView());
		inflater.inflate(R.id.tab02, host.getTabContentView());
		TabSpec tab1 = host.newTabSpec("tab1").setIndicator("ÁªÏµÈË").setContent(R.id.tab01);
		host.addTab(tab1);
		TabSpec tab2 = host.newTabSpec("tab2").setIndicator("²¦ºÅ").setContent(R.id.tab02);
		host.addTab(tab2);
	}

}
