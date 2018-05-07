package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

public class List_3 extends ListActivity{
	
	//@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
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
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
		for(int i=0;i<arr.length;i++){
			Map<String,Object> listItem = new HashMap<String, Object>();
			listItem.put("header", icons[i]);
			listItem.put("name", arr[i]);
			listItem.put("desc", arr2[i]);
			listItems.add(listItem);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.fruit_item, new String[]{"name","header","desc"}, new int[]{R.id.fruit_name,R.id.fruit_id,R.id.fruit_beizhu});
		
		setListAdapter(adapter);
	}

	

}
