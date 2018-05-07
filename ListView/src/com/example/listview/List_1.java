package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List_1 extends Activity{
	//String s[] = {"布鲁","方丈","董球","唐年","杨超","徐康","李瑞","代栋","狗蛋","二蛋","毛蛋","蛋蛋","球蛋","大锤","猴子"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list1_layout);
		/*ListView view = (ListView) findViewById(R.id.list_view1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(List_1.this,android.R.layout.simple_list_item_1, s);
		view.setAdapter(adapter);*/
		
	}
	
}
