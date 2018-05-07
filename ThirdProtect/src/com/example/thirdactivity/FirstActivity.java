package com.example.thirdactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Log.d("FirstActivity", this.toString());
		setContentView(R.layout.first_layout);
		Button button1 = (Button)findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				String data = "hahahahaha";
				Intent intent = new Intent(FirstActivity.this,ForthActivity.class);
				intent.putExtra("extra_date",data);
				startActivity(intent);
			}
		});
	}
	/*protected void onActivityResult(int requestCode,int resultCode,Intent intent){
		switch(requestCode){
		case 1:
			if(resultCode==RESULT_OK){
				String string1 = intent.getStringExtra("zhanghao_extra");
				String string2 = intent.getStringExtra("mima_extra");
				Toast.makeText(FirstActivity.this, string1,Toast.LENGTH_SHORT ).show();
				Toast.makeText(FirstActivity.this, string2,Toast.LENGTH_SHORT ).show();
				//System.out.println(string2);
			}
			break;
		default:
		}
	}*/
}
