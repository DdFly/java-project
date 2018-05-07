package com.example.coolweather.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.coolweather.R;
import com.example.coolweather.db.CoolWeatherDB;
import com.example.coolweather.model.City;
import com.example.coolweather.model.County;
import com.example.coolweather.model.Province;
import com.example.coolweather.util.HttpCallbackListener;
import com.example.coolweather.util.HttpUtil;
import com.example.coolweather.util.Utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseAreaActivity extends Activity {

	public static final int LEVEL_PROVINCE = 0;
	public static final int LEVEL_CITY = 1;
	public static final int LEVEL_COUNTY = 2;
	private ProgressDialog progressDialogg;
	private TextView titleText;
	private ListView listView;
	private ArrayAdapter<String> adapter;	
	private CoolWeatherDB coolWeatherDB;
	private List<String> dataList = new ArrayList<String>();		//空列表
	private List<Province> provinceList;	//省列表
	private List<City> cityList;			//市列表
	private List<County> countyList;		//县列表
	private Province selectedProvince;		//选中的省份
	private City selectedCity;				//选中的城市
	private int currentlevel;				//当前级别
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_area);
		titleText = (TextView) findViewById(R.id.city_name);
		listView = (ListView) findViewById(R.id.list_id);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
		listView.setAdapter(adapter);
		coolWeatherDB = CoolWeatherDB.getInstance(this);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				if(currentlevel==LEVEL_PROVINCE){
					selectedProvince = provinceList.get(arg2);
					queryCity();
				}
				else if(currentlevel==LEVEL_CITY){
					selectedCity = cityList.get(arg2);
					queryCounty();
				}
				else{
					
				}
			}
		});
		queryProvince();	
	}
	
	private void queryProvince(){
		provinceList = coolWeatherDB.loadProvince();
		if(provinceList.size()>0){
			dataList.clear();
			for(Province province:provinceList){
				dataList.add(province.getProvinceName());
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText("����");
			currentlevel=LEVEL_PROVINCE;
			
		}
		else{
			queryFromServer(null,"province");
		}
	}
	
	private void queryCity(){
		cityList = coolWeatherDB.loadCity(selectedProvince.getId());
		if(cityList.size()>0){
			dataList.clear();
			for(City city:cityList){
				dataList.add(city.getCityName());
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText(selectedProvince.getProvinceName());
			currentlevel = LEVEL_CITY;
		}
		else{
			queryFromServer(selectedProvince.getProvinceCode(), "city");
		}
	}
	
	private void queryCounty(){
		countyList = coolWeatherDB.loadCounty(selectedCity.getId());
		if(countyList.size()>0){
			dataList.clear();
			for(County county:countyList){
				dataList.add(county.getCountyName());
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText(selectedCity.getCityName());
			currentlevel = LEVEL_COUNTY;
		}
		else{
			queryFromServer(selectedCity.getCityCode(), "county");
		}
	}
	
	private void queryFromServer(final String code,final String type){
		String adress;
		if(!TextUtils.isEmpty(code)){
			adress = "http://www.weather.com.cn/data/list3/city"+code+".xml";
		}
		else{
			adress = "http://www.weather.com.cn/data/list3/city.xml";
		}
		showProgressDialog();
		HttpUtil.sendHttpRequest(adress, new HttpCallbackListener() {
			
			@Override
			public void onFinish(String response) {
				
				boolean result = false;
				if("province".equals(type)){
					result = Utility.handleProvinceResponse(coolWeatherDB, response);
				}
				else if("city".equals(type)){
					result = Utility.handleCityResponse(coolWeatherDB, response, selectedProvince.getId());
				}
				else if("county".equals(type))
					result = Utility.handleCountyResponse(coolWeatherDB, response, selectedCity.getId());
				if(result){
					runOnUiThread(new Runnable() {
						public void run() {
							closeProgressDialog();
							if(type.equals("province")){
								queryProvince();
								
							}
							else if(type.equals("city")){
								queryCity();
							}
							else if(type.equals("county")){
								queryCounty();
							}
						}
					});
				}
			}
			
			@Override
			public void onError(Exception e) {
				// TODO ������������������
				runOnUiThread(new Runnable() {
					public void run() {
						closeProgressDialog();
						Toast.makeText(ChooseAreaActivity.this, "��������", Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
	}
	
	private void showProgressDialog(){
		if(progressDialogg==null){
			progressDialogg = new ProgressDialog(this);
			progressDialogg.setMessage("��������...");
			progressDialogg.setCanceledOnTouchOutside(false);
		}
		progressDialogg.show();
	}
	private void closeProgressDialog(){
		if(progressDialogg!=null){
			progressDialogg.dismiss();
		}
	}

	@Override
	public void onBackPressed() {
		// TODO ������������������
		if(currentlevel==LEVEL_COUNTY){
			queryCity();
		}
		else if(currentlevel==LEVEL_CITY){
			queryProvince();
		}
		else if(currentlevel==LEVEL_PROVINCE){
			finish();
		}
	}
	
	
}
