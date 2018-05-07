package com.example.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragement extends Fragment{
	Button replace;
	AnotherFragment another;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		View view = inflater.inflate(R.layout.fragment, container, false);
		replace = (Button)view.findViewById(R.id.btn1);
		replace.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				another = new AnotherFragment();
				MovieChangeFragment m = new MovieChangeFragment();
				getFragmentManager().beginTransaction().replace(R.id.main, m).addToBackStack(null).commit();
				
			}
		});
		return view;
		
	}
}
