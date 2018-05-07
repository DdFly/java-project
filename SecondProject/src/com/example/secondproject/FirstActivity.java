package com.example.secondproject;

import android.app.Activity;
import android.content.Intent;
//import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity{
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.add_item:Toast.makeText(FirstActivity.this, "you clicked Add item", Toast.LENGTH_SHORT).show();break;
		case R.id.remove_item:Toast.makeText(FirstActivity.this, "you clicked Remove item", Toast.LENGTH_SHORT).show();break;
		default:
		}
		return true;
	}
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1 = (Button)findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
				startActivity(intent);
				Toast.makeText(FirstActivity.this, "you clicked button 1", Toast.LENGTH_SHORT).show();;
			}

		});
	}
}
