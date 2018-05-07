package com.example.myview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrawListLayout extends Activity implements OnItemClickListener {

	DrawerLayout mdl;
	ListView mlv;
	ArrayList<String> mlist;
	ArrayAdapter<String> madapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_draw_list_layout);
		mdl = (DrawerLayout) findViewById(R.id.drawer_layiout);
		mlv = (ListView) findViewById(R.id.left_drawer);
		mlist = new ArrayList<String>();
		for(int i=0;i<5;i++){
			mlist.add("哈哈哈哈哈"+i);
		}
		madapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, mlist);
		mlv.setAdapter(madapter);
		mlv.setOnItemClickListener(this);
		
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO 自动生成的方法存根
		
	}
	

}
