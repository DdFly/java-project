package com.game2048.app.UI;

import java.util.Iterator;
import java.util.List;

import com.game2048.app.util.Move;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.GridLayout;
import android.widget.Toast;

public class GameView extends GridLayout{
	Move m = Move.getMove();
	public GameView(Context context) {
		super(context);
		// TODO �Զ����ɵĹ��캯�����
		initGameView();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO �Զ����ɵĹ��캯�����
		initGameView();
	}

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO �Զ����ɵĹ��캯�����
		initGameView();
	}
	int wight;
	public static Card[][] cardNab = new Card[4][4];
	public void initGameView(){
		
		setColumnCount(4);
		setBackgroundColor(0xffbbada0);
		setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO �Զ����ɵķ������
				//Toast.makeText(getContext(), "2222222", Toast.LENGTH_SHORT).show();
				m.getAction(arg1);
				return true;
			}
		});
		
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO �Զ����ɵķ������
		super.onSizeChanged(w, h, oldw, oldh);
		wight=(Math.min(w, h)-5)/4;		
		addCard();
		m.start();
	}
	
	private void addCard(){
		Card c;
		for (int i = 0; i <4; i++) {
			for (int j = 0; j <4; j++) {
				c = new Card(getContext());
				c.setNum(0);
				addView(c,wight,wight);
				cardNab[i][j]=c;
				
			}
		}
	}



}
