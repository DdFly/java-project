package com.example.UI;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.ViewFlipper;

public class tabHost extends TabActivity implements OnGestureListener{
	TabHost tabHost;
	ViewFlipper flipper;
	GestureDetector detector;
	private Animation leftin;
	private Animation leftout;
	private Animation rightin;
	private Animation rightout;
	final int DISTANCE = 100;
	int currentView=0;
	Animation[] animations = new Animation[4];
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_layout);
		detector = new GestureDetector(this, this);
		flipper = (ViewFlipper) this.findViewById(android.R.id.tabcontent);
		tabHost = getTabHost();
		TabSpec sp1 = tabHost.newTabSpec("tab01").setIndicator("δ������").setContent(R.id.layout01);
		TabSpec sp2 = tabHost.newTabSpec("tab02").setIndicator("�ѽ�����").setContent(R.id.layout02);
		TabSpec sp3 = tabHost.newTabSpec("tab01").setIndicator("�Ѳ�����").setContent(R.id.layout03);
		leftin = AnimationUtils.loadAnimation(this, R.anim.left_in);
		leftout = AnimationUtils.loadAnimation(this, R.anim.left_out);
		rightin = AnimationUtils.loadAnimation(this, R.anim.right_in);
		rightout = AnimationUtils.loadAnimation(this, R.anim.right_out);
//		flipper.addView(findViewById(R.id.layout01));
//		flipper.addView(findViewById(R.id.layout02));
//		flipper.addView(findViewById(R.id.layout03));
		tabHost.setup();
		tabHost.addTab(sp1);
		tabHost.addTab(sp2);
		tabHost.addTab(sp3);
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO �Զ����ɵķ������
		return detector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
		// TODO �Զ����ɵķ������
		if((arg0.getX()-arg1.getX())>DISTANCE && Math.abs(arg2)>200){
			if(currentView == 2)
				currentView=0;
			else
				currentView++;
			flipper.setInAnimation(leftin);
			flipper.setOutAnimation(leftout);
			flipper.showNext();
			tabHost.setCurrentTab(currentView);
			
		}
		else if((arg1.getX()-arg0.getX())>DISTANCE && Math.abs(arg2)>200){
			if(currentView == 0)
				currentView=2;
			else
				currentView--;
			flipper.setInAnimation(rightin);
			flipper.setOutAnimation(rightout);
			flipper.showPrevious();
			tabHost.setCurrentTab(currentView);
			
		}
		
		return true;
	}
	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO �Զ����ɵķ������
		return false;
	}
}
