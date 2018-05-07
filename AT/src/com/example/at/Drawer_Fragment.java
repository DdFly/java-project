package com.example.at;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Drawer_Fragment extends Fragment implements OnClickListener{

	private List<Fragment> fragments = new ArrayList<Fragment>();
	private ViewPager viewPager;
	private LinearLayout linearTab1, linearTab2, linearTab3, linearTab4;
	private ImageView imageTab1, imageTab2, imageTab3, imageTab4, imageCurrent;
	private TextView textTab1, textTab2, textTab3, textTab4, textCurrent;
	private static int position;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.main_layout, container);
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onActivityCreated(savedInstanceState);
		initView();
		initData();
	}
	
	@SuppressWarnings("deprecation")
	private void initView() {
		viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);
		linearTab1 = (LinearLayout) getActivity().findViewById(R.id.tab1);
		linearTab2 = (LinearLayout) getActivity().findViewById(R.id.tab2);
		linearTab3 = (LinearLayout) getActivity().findViewById(R.id.tab3);
		linearTab4 = (LinearLayout) getActivity().findViewById(R.id.tab4);
		imageTab1 = (ImageView) getActivity().findViewById(R.id.tab1_img);
		imageTab2 = (ImageView) getActivity().findViewById(R.id.tab2_img);
		imageTab3 = (ImageView) getActivity().findViewById(R.id.tab3_img);
		imageTab4 = (ImageView) getActivity().findViewById(R.id.tab4_img);
		textTab1 = (TextView) getActivity().findViewById(R.id.tab1_text);
		textTab2 = (TextView) getActivity().findViewById(R.id.tab2_text);
		textTab3 = (TextView) getActivity().findViewById(R.id.tab3_text);
		textTab4 = (TextView) getActivity().findViewById(R.id.tab4_text);
		linearTab1.setOnClickListener(this);
		linearTab2.setOnClickListener(this);
		linearTab3.setOnClickListener(this);
		linearTab4.setOnClickListener(this);
		imageTab1.setSelected(true);
		textTab1.setSelected(true);
		imageCurrent = imageTab1;
		textCurrent = textTab1;
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO 自动生成的方法存根
				changeTab(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO 自动生成的方法存根
				
			}
		});

		// viewPager.setOffscreenPageLimit(1);

	}

	private void initData() {

		Fragment tab1Fragment = new Tab1Fragment();
		Fragment tab2Fragment = new Tab2Fragment();
		Fragment tab3Fragment = new Tab3Fragment();
		Fragment tab4Fragment = new Tab4Fragment();
		fragments.add(tab1Fragment);
		fragments.add(tab2Fragment);
		fragments.add(tab3Fragment);
		fragments.add(tab4Fragment);
		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getFragmentManager(), fragments);
		viewPager.setAdapter(adapter);
	}

	private void changeTab(int position) {
		// TODO 自动生成的方法存根
		imageCurrent.setSelected(false);
		textCurrent.setSelected(false);
		this.position=position;
		switch (position) {
		case R.id.tab1:
		case 0:
			viewPager.setCurrentItem(0);
			imageTab1.setSelected(true);
			textTab1.setSelected(true);
			imageCurrent = imageTab1;
			textCurrent = textTab1;
			break;
		case R.id.tab2:
		case 1:
			viewPager.setCurrentItem(1);
			imageTab2.setSelected(true);
			textTab2.setSelected(true);
			imageCurrent = imageTab2;
			textCurrent = textTab2;
			break;
		case R.id.tab3:
		case 2:
			viewPager.setCurrentItem(2);
			imageTab3.setSelected(true);
			textTab3.setSelected(true);
			imageCurrent = imageTab3;
			textCurrent = textTab3;
			break;
		case R.id.tab4:
		case 3:
			viewPager.setCurrentItem(3);
			imageTab4.setSelected(true);
			textTab4.setSelected(true);
			imageCurrent = imageTab4;
			textCurrent = textTab4;
			break;
		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		changeTab(v.getId());
	}
	public static int getCurrent(){
		return position;
	}


}
