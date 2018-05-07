package com.game2048.app.activity;

import com.game2048.app.R;
import com.game2048.app.model.record;
import com.game2048.app.util.Move;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity{
	
	static TextView scoreL;
	static TextView stepL;
	static TextView maxL;
	Move m;
	record r;
	SharedPreferences pref;
	SharedPreferences.Editor editor; 
	public MainActivity() {
		// TODO �Զ����ɵĹ��캯�����
		m=Move.getMove();
		r=record.getRecord();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_layout);
		scoreL=(TextView) findViewById(R.id.score);
		stepL=(TextView) findViewById(R.id.step);
		maxL=(TextView) findViewById(R.id.high_record);	
		pref = getSharedPreferences("record", MODE_PRIVATE);
		editor = pref.edit();
		init();	
	}

	private void init(){
		r.setRecore(0);
		r.setStep(0);
		r.setMax(pref.getInt("Max", 0));
		update(r.getRecore(),r.getStep(),r.getMax());
		
	}
	public static void update(int i,int j,int k){
		scoreL.setText(i+"");
		stepL.setText(j+"");
		maxL.setText(k+"");
	}
	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();		
	}
	
	@Override
	protected void onStop() {
		// TODO �Զ����ɵķ������
		super.onStop();
//		AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//		dialog.setCancelable(true);
//		dialog.setTitle("������Ϸ");
//		dialog.setMessage("�Ƿ��˳���Ϸ��");
//		dialog.setPositiveButton("ȷ��", new OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface arg0, int arg1) {
//				// TODO �Զ����ɵķ������
////				editor.putInt("Max", r.getMax());
//			}
//		});
//		dialog.setNegativeButton("����һ���", null);
//		dialog.show();
		editor.putInt("Max", r.getMax());
		editor.commit();
	}
	
}
