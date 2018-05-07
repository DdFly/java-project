package com.example.locationtest;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView text;
	private LocationManager locationManager;
	String provider;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		try{
			if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
				provider = LocationManager.NETWORK_PROVIDER;
			}else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
				provider = LocationManager.GPS_PROVIDER;
			}else{
				Toast.makeText(this, "��ǰû�п��õ�λ���ṩ��", Toast.LENGTH_SHORT).show();
				return;
			}
			locationManager.requestLocationUpdates(provider, 1000, 3, locationListener);
		}catch(IllegalArgumentException e){
			Toast.makeText(this, "����", Toast.LENGTH_SHORT).show();
		}
			
	}
	protected void OnDestroy(){
		if(locationManager!=null)
			locationManager.removeUpdates(locationListener);
	}
	LocationListener locationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO �Զ����ɵķ������
			
		}
		
		@Override
		public void onProviderEnabled(String arg0) {
			// TODO �Զ����ɵķ������
			showLocation(locationManager.getLastKnownLocation(arg0));
		}
		
		@Override
		public void onProviderDisabled(String arg0) {
			// TODO �Զ����ɵķ������
			
		}
		
		@Override
		public void onLocationChanged(Location arg0) {
			// TODO �Զ����ɵķ������
			showLocation(arg0);
		}
	};
	Handler handler = new Handler(){
		public void handleMessage(Message message){
			switch(message.what){
			case 1: String address = message.obj.toString();
					text.setText(address);
					Toast.makeText(MainActivity.this, "�ɹ���", Toast.LENGTH_SHORT).show();
					break;
					default:break;
			}
		}
	};
	private void showLocation(final Location location){
		//Toast.makeText(this, provider, Toast.LENGTH_SHORT).show();
//		String currentlocation = "���ȣ�"+location.getLatitude()+"\nγ�ȣ�"+location.getLongitude()+"\n���Σ�"+location.getAltitude()
//			+"\n����"+location.getBearing()+"\n�ٶȣ�"+location.getSpeed();
		new Thread(new Runnable() {
			public void run() {
				
				try {
					String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+location.getLatitude()+","+location.getLongitude()
					+"&sensor=false";
					HttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(url);
					httpGet.addHeader("Accept-Language", "zh-CN");
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if(httpResponse.getStatusLine().getStatusCode()==200){
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity, "utf-8");
						JSONObject jsonObject = new JSONObject(response);
						JSONArray jsonArray = jsonObject.getJSONArray("results");
						if(jsonArray.length()>0){
							JSONObject subObject = jsonArray.getJSONObject(0);
							String adress = subObject.getString("formatted_address");
							Toast.makeText(MainActivity.this, adress, Toast.LENGTH_SHORT).show();
							Message message = new Message();
							message.what=1;
							message.obj=adress.toString();
							handler.sendMessage(message);
						}
						else
							Toast.makeText(MainActivity.this, "��������", Toast.LENGTH_SHORT).show();
					}
					else{
						Toast.makeText(MainActivity.this,"�������", Toast.LENGTH_SHORT).show();
					}
				} catch (ClientProtocolException e) {
					// TODO �Զ����ɵ� catch ��
					Toast.makeText(MainActivity.this,"�������", Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					Toast.makeText(MainActivity.this,"�������", Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				} catch (JSONException e) {
					
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
				
			}
		}).start();
		//text.setText(currentlocation);
	};

}
