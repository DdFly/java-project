package com.example.thirdactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.storage.OnObbStateChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity{
	EditText mima;
	EditText zhanghao;
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		Intent intent1 = getIntent();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		String data = intent1.getStringExtra("extra_date");
		Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
		System.out.println(data);
		Log.d("SecondActivity",data);
		setContentView(R.layout.second_layout);
		Button denglu = (Button)findViewById(R.id.denglu);
		denglu.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent2 = new Intent();
				zhanghao = (EditText)findViewById(R.id.zhanghao_edit);
				mima = (EditText)findViewById(R.id.mima_edit);
				intent2.putExtra("zhanghao_extra", zhanghao.getText().toString());
				intent2.putExtra("mima_extra", mima.getEditableText().toString());
				setResult(RESULT_OK, intent2);
				finish();
				
			}
		});
	}
	public void onBackPressed(){
		zhanghao = (EditText)findViewById(R.id.zhanghao_edit);
		mima = (EditText)findViewById(R.id.mima_edit);
		Intent intent = new Intent();
		intent.putExtra("zhanghao_extra", zhanghao.getText().toString());
		intent.putExtra("mima_extra", mima.getEditableText().toString());
		setResult(RESULT_OK,intent);
		finish();
	}
}
