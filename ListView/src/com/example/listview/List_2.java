package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

public class List_2 extends Activity{
	private List<Fruit> fruitList = new ArrayList<Fruit>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list2_layout);
		initFruit();
		FruitAdapter adapter = new FruitAdapter(List_2.this,R.layout.fruit_item,fruitList);
		ListView list = (ListView) findViewById(R.id.list_view2);
		list.setAdapter(adapter);
		
	}
	public void initFruit(){
		String[] arr = getResources().getStringArray(R.array.name);
		int[] icons = {R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app,
						R.drawable.app,R.drawable.app,R.drawable.app,R.drawable.app};
		String[] arr2 = getResources().getStringArray(R.array.beizhu);
		for(int i=0;i<arr.length;i++){
			fruitList.add(new Fruit(arr[i],icons[i],arr2[i]));
		}
		
	}
	

}
