package com.example.http01;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.TabActivity;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;
import android.widget.ViewFlipper;

public class Blueteath extends Activity implements OnClickListener {

	private ViewPager vp;
	private LinearLayout tab_device;
	private LinearLayout tab_chat;
	private ImageButton imgBt_de;
	private ImageButton imgBt_ch;
	private ProgressBar search_pro;
	private TextView search_t;

	private PagerAdapter mPagerAdapter;
	private List<View> mViews = new ArrayList<View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_blueteath);
		initView();
		initEvents();

	}

	@SuppressWarnings("deprecation")
	private void initEvents() {
		// TODO 自动生成的方法存根
		tab_device.setOnClickListener(this);
		tab_chat.setOnClickListener(this);
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				resetImg();
				switch(vp.getCurrentItem()){
				case 0:
					imgBt_de.setImageResource(R.drawable.device2);
					break;
				case 1:
					imgBt_ch.setImageResource(R.drawable.chat2);
					break;
				}
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
	}

	private void initView() {
		// TODO 自动生成的方法存根
		vp = (ViewPager) findViewById(R.id.pager);
		tab_device = (LinearLayout) findViewById(R.id.tab1);
		tab_chat = (LinearLayout) findViewById(R.id.tab2);
		imgBt_de = (ImageButton) findViewById(R.id.tab1_img);
		imgBt_ch = (ImageButton) findViewById(R.id.tab2_img);
		search_pro = (ProgressBar) findViewById(R.id.search_progress);
		LayoutInflater inflater = LayoutInflater.from(this);
		View tab01 = inflater.inflate(R.layout.tab1_layout, null);
		View tab02 = inflater.inflate(R.layout.tab2_layout, null);
		mViews.add(tab01);
		mViews.add(tab02);
		search_t = (TextView) findViewById(R.id.search_result);
		//Toast.makeText(this, search_t.getText(), Toast.LENGTH_SHORT).show();
		mPagerAdapter = new PagerAdapter() {

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				// TODO 自动生成的方法存根
				container.removeView(mViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO 自动生成的方法存根
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO 自动生成的方法存根
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO 自动生成的方法存根
				return mViews.size();
			}
		};
		vp.setAdapter(mPagerAdapter);
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		resetImg();
		switch (arg0.getId()) {
		case R.id.tab1:
			vp.setCurrentItem(0);
//			imgBt_de.setImageResource(R.drawable.device2);
			imgBt_de.setImageDrawable(getResources().getDrawable(R.drawable.device2));
			break;
		case R.id.tab2:
			vp.setCurrentItem(1);
			//imgBt_ch.setImageResource(R.drawable.chat2);
			imgBt_ch.setImageDrawable(getResources().getDrawable(R.drawable.chat2));
			break;
		default:
			break;
		}
	}

	private void resetImg() {
//		 imgBt_ch.setImageResource(R.drawable.chat1);
//		 imgBt_de.setImageResource(R.drawable.device1);
		imgBt_de.setImageDrawable(getResources().getDrawable(R.drawable.device1));
		imgBt_ch.setImageDrawable(getResources().getDrawable(R.drawable.chat1));
	}

}
