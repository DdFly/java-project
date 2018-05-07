package com.example.coolweather.activity;

import com.example.coolweather.R;
import com.example.coolweather.model.County;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeatherActivity extends Activity implements OnClickListener{

	private static final TextView TextView = null;

	private LinearLayout weatherInfoLayout;
	
	private TextView cityNameText;
	
	private TextView publishText;
	
	private TextView WeatherInfo;
	
	private TextView temp1Text;
	
	private TextView temp2Text;
	
	private TextView currentTime;
	
	private Button switchCity;
	
	private Button refreshWeather;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
		weatherInfoLayout = (LinearLayout) findViewById(R.id.weathew_info_layout);
		cityNameText =(TextView) findViewById(R.id.city_name);
		publishText = (TextView) findViewById(R.id.publish_text);
		WeatherInfo = (android.widget.TextView) findViewById(R.id.weather_desp);
		temp1Text = (android.widget.TextView) findViewById(R.id.temp1);
		temp2Text = (android.widget.TextView) findViewById(R.id.temp2);
		currentTime = (android.widget.TextView) findViewById(R.id.current_date);
		switchCity = (Button) findViewById(R.id.switch_city);
		refreshWeather = (Button) findViewById(R.id.refresh_weather);
		switchCity.setOnClickListener(this);
		String countryCode = getIntent().getStringExtra("county_code");
		if(!TextUtils.isEmpty(countryCode)){
			publishText.setText("正在更新...");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			
		}
		else
			showWeather();
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		
	}
	
	private void queryWeatherInfo(){
		
	}
	
	private void showWeather(){
		
	}
	
	
	
}
