package com.example.at;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends  FragmentPagerAdapter{

	List<Fragment> fragments;
	public MyFragmentPagerAdapter(FragmentManager fragmentManager,List<Fragment> fragments) {
		super(fragmentManager);
		// TODO 自动生成的构造函数存根
		this.fragments = fragments;
	}


	@Override
	public Fragment getItem(int arg0) {
		// TODO 自动生成的方法存根
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return fragments.size();
	}

}
