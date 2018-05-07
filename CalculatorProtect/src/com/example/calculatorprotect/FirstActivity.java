package com.example.calculatorprotect;

import com.example.calculatorprotect.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity implements OnClickListener{
	//public static final String ACTION = "com.example.calculatorprotect.intent.action.FirstActivity";
	Button  ONE;
	Button TWO;
	Button THREE;
	Button FOUR;
	Button FIVE;
	Button SIX;
	Button SEVEN;
	Button EIGHT;
	Button NINE;
	Button ZERO;
	Button PLUS;
	Button DEVIDE;
	Button MULTIPLY;
	Button MINUS;
	Button POINT;
	Button EQUAL;
	EditText TEXT;
	String s="";
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		ONE = (Button)findViewById(R.id.one);
		TWO = (Button)findViewById(R.id.two);
		THREE = (Button)findViewById(R.id.three);
		FOUR = (Button)findViewById(R.id.four);
		FIVE = (Button)findViewById(R.id.five);
		SIX = (Button)findViewById(R.id.six);
		SEVEN = (Button)findViewById(R.id.seven);
		EIGHT = (Button)findViewById(R.id.eight);
		NINE = (Button)findViewById(R.id.nine);
		ZERO = (Button)findViewById(R.id.zero);
		PLUS = (Button)findViewById(R.id.plus);
		MINUS = (Button)findViewById(R.id.minus);
		MULTIPLY = (Button)findViewById(R.id.multiply);
		DEVIDE = (Button)findViewById(R.id.devide);
		EQUAL = (Button)findViewById(R.id.equal);
		POINT = (Button)findViewById(R.id.point);
		TEXT = (EditText)findViewById(R.id.text_1);
		ONE.setOnClickListener(this);
		TWO.setOnClickListener(this);
		THREE.setOnClickListener(this);
		FOUR.setOnClickListener(this);
		FIVE.setOnClickListener(this);
		SIX.setOnClickListener(this);
		SEVEN.setOnClickListener(this);
		EIGHT.setOnClickListener(this);
		NINE.setOnClickListener(this);
		ZERO.setOnClickListener(this);
		PLUS.setOnClickListener(this);
		MINUS.setOnClickListener(this);
		MULTIPLY.setOnClickListener(this);
		DEVIDE.setOnClickListener(this);
		EQUAL.setOnClickListener(this);
		POINT.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch(v.getId()){
			case R.id.equal:
				TEXT.setText(s);
				break;
			case R.id.plus:
				Intent intent = new Intent(SecondActivity.ACTION);
				startActivity(intent);
				break;
			default:
				s = s+((Button)findViewById(v.getId())).getText();
				TEXT.setText(s);
				break;
			
			
		}
		
	}
}
