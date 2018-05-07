package com.game2048.app.UI;

import android.R.bool;
import android.content.Context;
import android.content.pm.LabeledIntent;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout{

	public Card(Context context) {
		super(context);
		// TODO 自动生成的构造函数存根
		label = new TextView(getContext());
		label.setGravity(Gravity.CENTER);
		label.setBackgroundColor(0x33ffffff);
		label.setTextSize(19);
		LayoutParams lp = new LayoutParams(-1, -1);
		lp.setMargins(10, 10, 0, 0);
		addView(label, lp);
		setNum(num);
		
		
	}
	private int num=0;
	private TextView label;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		if(num<=0)
			label.setText(" ");
		else
			label.setText(num+"");
	}
	public boolean equals(Card c){
		return getNum()==c.getNum();
	}
	

}
