package com.example.myview;

import java.util.MissingFormatArgumentException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.provider.ContactsContract.AggregationExceptions;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {

	Button xz;
	Button tm;
	Button yd;
	Button sf;
	Button fh;
	Button MyRec;
	Button dl;
	AnimationSet as;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		xz = (Button) findViewById(R.id.reBt);
		tm = (Button) findViewById(R.id.scalBt);
		yd = (Button) findViewById(R.id.moveBt);
		sf = (Button) findViewById(R.id.suoBt);
		fh = (Button) findViewById(R.id.sumBt);
		dl = (Button) findViewById(R.id.drawList_bt);
		MyRec = (Button) findViewById(R.id.myRect);
		as = new AnimationSet(true);
		as.setDuration(1000);
		MyRec.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, MoveRec.class);
				startActivity(intent);
				
			}
		});
		tm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				AlphaAnimation aa = new AlphaAnimation(0, 1);
				aa.setDuration(1000);
				as.addAnimation(aa);
				arg0.startAnimation(aa);
//				arg0.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.aa));
				Intent intent = new Intent(MainActivity.this, DrawListLayout.class);
				startActivity(intent);
			}
		});
		xz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
				ra.setDuration(1000);
				as.addAnimation(ra);
				arg0.startAnimation(ra);
				//arg0.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.ra));
			}
		});
		yd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 200);
				ta.setDuration(2000);
				as.addAnimation(ta);
				arg0.startAnimation(ta);
//				arg0.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.ta));
			}
		});
		sf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				//ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
				//ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, 100,100);
				ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);			
				sa.setDuration(1000);
				as.addAnimation(sa);
				arg0.startAnimation(sa);
//				arg0.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.sa));
				
			}
		});
		fh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				//arg0.startAnimation(as);
				arg0.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim));
				
			}
		});
		dl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
//				Intent intent = new Intent(MainActivity.this, cls)
			}
		});
	}
}
