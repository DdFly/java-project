package com.example.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

public class HttpClientTest extends Activity{

	TextView text2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpclient_layout);
		text2 = (TextView) findViewById(R.id.Intent_text2);
		sendRequestWithHttpClient();
		
	}
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO 自动生成的方法存根
			switch(msg.what){
			case 1:
				String string = (String) msg.obj;
				Toast.makeText(HttpClientTest.this, string, Toast.LENGTH_SHORT).show();
				
				text2.setText(string);
				break;
			case 0:
				break;
				default:
			}
		}
		
	};
	
	private void sendRequestWithHttpClient(){
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet= new HttpGet("http://www.baidu.com");
				try {
					HttpResponse response = httpClient.execute(httpGet);
					if(response.getStatusLine().getStatusCode()==200){
						HttpEntity entity = response.getEntity();
						String line = EntityUtils.toString(entity, "UTF-8");
						Message message = new Message();
						message.what=1;
						message.obj=line.toString();
						handler.sendMessage(message);
						
					}
				} catch (ClientProtocolException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}).start();
	}
	
	
	
}
