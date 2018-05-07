package com.example.intentproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1=(Button)findViewById(R.id.start_1);
		button2=(Button)findViewById(R.id.start_2);
		button3=(Button)findViewById(R.id.start_3);
		button4=(Button)findViewById(R.id.start_4);
		button5=(Button)findViewById(R.id.start_5);
		button6=(Button)findViewById(R.id.start_6);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		Intent intent;
		switch(v.getId()){
		case R.id.start_1:
			intent = new Intent(MainActivity.this,Activity_1.class);
			intent.putExtra("value_1",((Button)findViewById(v.getId())).getText());
			startActivity(intent);
			break;
		case R.id.start_2:
			intent = new Intent(Activity_2.ACTION);
			intent.putExtra("value_2",((Button)findViewById(v.getId())).getText());
			startActivity(intent);
			break;
		case R.id.start_3:
			intent = new Intent("com.example.calculatorprotect.intent.action.SecondActivity");
			//intent.putExtra("vlaue_3", ((Button)findViewById(v.getId())).getText());
			startActivity(intent);
			Toast.makeText(MainActivity.this, "启动成功", Toast.LENGTH_SHORT).show();
			break;
		case R.id.start_4:
			intent = new Intent(Activity_4.ACTION);
			intent.putExtra("value_4", "传过来的字符串");
			startActivityForResult(intent, 1);
			break;
		case R.id.start_5:
			intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:10086"));
			startActivity(intent);
			break;
		case R.id.start_6:
			intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://www.baidu.com"));
			startActivity(intent);
			break;
		default:
			break;
			
		}
	}
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		switch(requestCode){
		case 1:
			if (resultCode==RESULT_OK)
				Log.d("MainActivity", data.getStringExtra("value_return"));
		}
	}
}
