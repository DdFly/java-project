package com.example.lianxiren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class FirstFragment extends ListFragment {
	ListView listView;
	EditText edit;
	Cursor cursor = null;
	ContentResolver resolver;
	List<Map<String, String>> lists = MainActivity.lists;
	SimpleAdapter adapter;

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO 自动生成的方法存根
		super.onListItemClick(l, v, position, id);
		Map<String, String> search = lists.get(position);
		String num = search.get("num");
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:"+num));
		startActivity(intent);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.list_frag, container, false);
		edit = (EditText) getActivity().findViewById(R.id.input_search);	
		listView = (ListView) getActivity().findViewById(android.R.id.list);
		resolver = getActivity().getContentResolver();
		cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,"sort_key");
		adapter = MainActivity.adapter;
		try{
			lists.clear();
			if(cursor.moveToFirst()){
				do{
					Map<String,String> list = new HashMap<String, String>();
					String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
					String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					list.put("name", name);
					list.put("num", number);
					lists.add(list);
				}while(cursor.moveToNext());
			};
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			cursor.close();
		}
		setListAdapter(adapter);
		return view;
	}
}


