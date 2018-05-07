package com.example.sockettest;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ipText;
	EditText duankou;
	Button ipGet;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ipText = (EditText) findViewById(R.id.ip_input);
		ipGet = (Button) findViewById(R.id.get_ip);
		duankou = (EditText) findViewById(R.id.dk_input);
		ipText.setText("169.254.133.130");
		duankou.setText("8989");
		ipGet.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
					//Toast.makeText(getApplicationContext(),ipText.getText().toString()+Integer.parseInt(duankou.getText().toString()),Toast.LENGTH_SHORT).show();
//					try {
//						IOActivity.socket = new Socket("169.254.143.7",8989);
//						//System.out.println(IOActivity.socket.getLocalAddress().toString());
//						//Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();
////						Intent intent = new Intent(getApplicationContext(), IOActivity.class);	
////						startActivity(intent);
//					} catch (UnknownHostException e) {
//						// TODO 自动生成的 catch 块
//						System.out.println("ip地址错误");
//					} catch (IOException e) {
//						// TODO 自动生成的 catch 块
//						System.out.println("其他错误");
//					}
//				
				Intent intent = new Intent(getApplicationContext(), IOActivity.class);
				startActivity(intent);
				Toast.makeText(getApplicationContext(), "艾西", Toast.LENGTH_SHORT).show();
			}
		});
	}


}
