package com.example.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{

	Button send1;
	Button send2;
	TextView text;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		send1 = (Button) findViewById(R.id.send1);
		send1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent(MainActivity.this,HttpClientTest.class);
				startActivity(intent);
			}
		});
		text = (TextView) findViewById(R.id.Intent_text);
		sendRequest1();
				
	}
	
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO �Զ����ɵķ������
			switch(msg.what){
			case 0:
				String string = (String) msg.obj;
				
				Toast.makeText(MainActivity.this, msg.getData().getString("string", "null"), Toast.LENGTH_SHORT).show();
				
				text.setText(string);
				break;
			case 1:
				break;
				default:
			}
		}
		
	};
	
	private void sendRequest1(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				HttpURLConnection connection = null;
				try{
					URL url = new URL("http://www.baidu.com");
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while((line=reader.readLine())!=null){
						
						response.append(line);
					}
					
					Message message = new Message();
					message.what=0;
					Bundle bundle = new Bundle();
					bundle.putString("string", response.toString());
					message.setData(bundle);
					message.obj=response.toString();
					handler.sendMessage(message);
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					if(connection!=null)
						connection.disconnect();
				}
			}
		}).start();
	}
	private void sendRequest2(){
		
	}

}
