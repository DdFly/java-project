package com.example.UI;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener{

	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	ActionBar bar;
	TextView text;
	private boolean flag = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bar = getActionBar();
		bt1 = (Button) findViewById(R.id.false_head);
		bt2 = (Button) findViewById(R.id.false_tittle);
		bt3 = (Button) findViewById(R.id.progressBar);
		bt4 = (Button) findViewById(R.id.tabhostId);
		bt5 = (Button) findViewById(R.id.scroll);
		text = (TextView) findViewById(R.id.text);	
		registerForContextMenu(text);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);	
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		registerForContextMenu(bt3);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO 自动生成的方法存根
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.contextmenu,menu);
		menu.setHeaderTitle("设置颜色");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		switch(item.getItemId()){
		case R.id.color1:
			text.setTextColor(Color.RED);
			break;
		case R.id.color2:
			text.setTextColor(Color.GREEN);
			break;
		case R.id.color3:
			text.setTextColor(Color.BLUE);
			break;
		case R.id.default_color:
			text.setTextColor(Color.BLACK);
			
		}	
			
		return true;
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.false_head:
			if(bar.isShowing()){
				bar.hide();
				bt1.setText("开启动作栏");
			}
			else{
				bar.show();
				bt1.setText("隐藏动作栏");
			}
				
			break;
		case R.id.false_tittle:
			if(!bar.isShowing())
				Toast.makeText(this, "动作栏未开启", Toast.LENGTH_SHORT).show();
			else{
				if(flag){
					bar.setDisplayShowTitleEnabled(false);
					bt2.setText("打开标题");
					flag=false;
				}
				else{
					bar.setDisplayShowTitleEnabled(true);
					bt2.setText("隐藏标题");
					flag=true;
				}
			}
			break;
		case R.id.progressBar:
			Intent intent = new Intent(MainActivity.this,barTest.class);
			startActivity(intent);
			break;
		case R.id.tabhostId:
			Intent intent2 = new Intent(MainActivity.this,tabHost.class);
			startActivity(intent2);
			break;
		case R.id.scroll:
			Intent intent3 = new Intent(MainActivity.this,scrollbar.class);
			startActivity(intent3);
			break;
		}
	}

}
