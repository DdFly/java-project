package com.example.at;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Fragment extends Fragment{

	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			// TODO 自动生成的方法存根
			View view = inflater.inflate(R.layout.tab1_fragment, container, false);
			MovieListFragment list = new MovieListFragment();
			MovieChangeFragment change = new MovieChangeFragment();
			getFragmentManager().beginTransaction().add(R.id.tab1_fram, list).commit();
			return view;
	 }
    

}



