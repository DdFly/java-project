package com.example.secondproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity implements OnClickListener{			
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Button button2 = (Button)findViewById(R.id.button_2);
		button2.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		finish();
		Toast.makeText(SecondActivity.this, "you clicked button 2", Toast.LENGTH_SHORT).show();
		
	}
}
