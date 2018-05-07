package com.example.attms;

import java.util.ArrayList;
import java.util.List;

import com.example.utils.ActivityCollector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private List<Fragment> fragments = new ArrayList<Fragment>();
	private ViewPager viewPager;
	private LinearLayout linearTab1, linearTab2, linearTab3, linearTab4;
	private ImageView imageTab1, imageTab2, imageTab3, imageTab4, imageCurrent;
	private TextView textTab1, textTab2, textTab3, textTab4, textCurrent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();

		initView();
		initData();
	}

	@SuppressWarnings("deprecation")
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		linearTab1 = (LinearLayout) findViewById(R.id.tab1);
		linearTab2 = (LinearLayout) findViewById(R.id.tab2);
		linearTab3 = (LinearLayout) findViewById(R.id.tab3);
		imageTab1 = (ImageView) findViewById(R.id.tab1_img);
		imageTab2 = (ImageView) findViewById(R.id.tab2_img);
		imageTab3 = (ImageView) findViewById(R.id.tab3_img);
		textTab1 = (TextView) findViewById(R.id.tab1_text);
		textTab2 = (TextView) findViewById(R.id.tab2_text);
		textTab3 = (TextView) findViewById(R.id.tab3_text);
		linearTab1.setOnClickListener(this);
		linearTab2.setOnClickListener(this);
		linearTab3.setOnClickListener(this);
		imageTab1.setSelected(true);
		textTab1.setSelected(true);
		imageCurrent = imageTab1;
		textCurrent = textTab1;

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
		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
		viewPager.setAdapter(adapter);
	}

	private void changeTab(int position) {
		// TODO 自动生成的方法存根
		imageCurrent.setSelected(false);
		textCurrent.setSelected(false);
		switch (position) {
		case R.id.tab1:
			viewPager.setCurrentItem(0);
			imageTab1.setSelected(true);
			textTab1.setSelected(true);
			imageCurrent = imageTab1;
			textCurrent = textTab1;
			break;
		case R.id.tab2:
			viewPager.setCurrentItem(1);
			imageTab2.setSelected(true);
			textTab2.setSelected(true);
			imageCurrent = imageTab2;
			textCurrent = textTab2;
			break;
		case R.id.tab3:
			viewPager.setCurrentItem(2);
			imageTab3.setSelected(true);
			textTab3.setSelected(true);
			imageCurrent = imageTab3;
			textCurrent = textTab3;
			break;
		case R.id.tab4:
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
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		ActivityCollector.finishAll();
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		changeTab(arg0.getId());
	}

}
