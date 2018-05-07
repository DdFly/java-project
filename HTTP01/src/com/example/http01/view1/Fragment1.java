package com.example.http01.view1;

import com.example.http01.Blueteath;
import com.example.http01.LoginActivity;
import com.example.http01.MainActivity;
import com.example.http01.NewsActivity;
import com.example.http01.R;
import com.example.http01.Wuziqi;
import com.example.http01.webUtils.HttpThread2;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Fragment1 extends Fragment {

	private Button log;
	private Button news;
	private Button youxi;
	private Button lanya;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.fragment1, container, false);
		log = (Button) view.findViewById(R.id.test);
		news = (Button) view.findViewById(R.id.newsWeb);
		youxi = (Button) view.findViewById(R.id.bt_youxi);
		lanya = (Button) view.findViewById(R.id.bt_blueteath);
		log.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
				startActivity(intent);
			}
		});
		news.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(getActivity().getApplicationContext(), NewsActivity.class);
				startActivity(intent);
			}
		});
		youxi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(getActivity().getApplicationContext(), Wuziqi.class);
				startActivity(intent);
			}
		});
		lanya.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(getActivity().getApplicationContext(), Blueteath.class);
				startActivity(intent);
			}
		});
		return view;
	}
}
