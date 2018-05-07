package com.example.baidumap;



import java.util.List;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	private LocationManager locationManager = null;
	private String provider;
	private MapView mapview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_main);
		mapview = (MapView) findViewById(R.id.map_view);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		List<String> providerList = locationManager.getProviders(true);
		if(providerList.contains(LocationManager.GPS_PROVIDER)){
			provider=LocationManager.GPS_PROVIDER;
		}else if(providerList.contains(LocationManager.NETWORK_PROVIDER)){
			provider = LocationManager.NETWORK_PROVIDER;
		}else{
			Toast.makeText(this, "没有位置提供器可用", Toast.LENGTH_SHORT).show();
			return;
		}
		Location location =  locationManager.getLastKnownLocation(provider);
		if(location!=null){
//			navigateTo(location);
		}else
			Toast.makeText(this, "未获取到位置", Toast.LENGTH_SHORT).show();
		
		
		
		
	}
	@Override
	protected void onResume() {
		// TODO 自动生成的方法存根
		mapview.onResume();

		super.onResume();
	}
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		mapview.onDestroy();

		super.onDestroy();
	}
	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		mapview.onPause();

		super.onPause();
	}
//	void navigateTo(Location location){
//		MapController controller = mapview.getController();
//		controller.setZoom(13);
//		GeoPoint point = new GeoPoint((int)(location.getLatitude()*1E6), (int)(location.getLongitude()*1E6));
//		Toast.makeText(this, location.getLatitude()+"\n"+location.getLongitude(), Toast.LENGTH_SHORT).show();
//		controller.setCenter(point);
//	}

}
