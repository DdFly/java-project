 package com.example.coolweather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.coolweather.activity.ChooseAreaActivity;

import android.widget.Toast;

public class HttpUtil {

	public static void sendHttpRequest(final String adress,final HttpCallbackListener listener){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				HttpURLConnection connection = null;
				try{
					URL url = new URL(adress);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while((line = reader.readLine())!=null){
						response.append(line);
					}
					if(listener!=null){
						listener.onFinish(response.toString());
					}
//					HttpClient httpClient = new DefaultHttpClient();
//					HttpGet httpGet = new HttpGet(adress);
//					HttpResponse response = httpClient.execute(httpGet);
//					if(response.getStatusLine().getStatusCode()==200){
//						HttpEntity entity = response.getEntity();
//						String string = EntityUtils.toString(entity, "UTF-8");
//						if(listener!=null){						
//							listener.onFinish(string);
//						}
//					}
//					else{
//						throw new Exception();
//					}
					
				}catch(Exception e){
					if(listener!=null){
						listener.onError(e);
					}
				}
				finally {
					if(listener!=null){
						connection.disconnect();
					}
				}
			}
		}).start();
	}
}
