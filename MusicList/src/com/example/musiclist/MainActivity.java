package com.example.musiclist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	ListView musicList;
	long[] _id;
	String[] _title;
	String[] _url;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		musicList = (ListView) findViewById(R.id.musicList);
		ContentResolver myResolver = getContentResolver();
		Cursor cursor = null;
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
		try{
			cursor= myResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
			cursor.moveToFirst();
			_id = new long[cursor.getCount()];
			_title = new String[cursor.getCount()];
			_url = new String[cursor.getCount()];
			for (int i=0;i<cursor.getCount();i++){
				Map<String,Object> listItem = new HashMap<String,Object>();
				_id[i]=cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
				_title[i]=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
				_url[i] = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
				listItem.put("_id", _id[i]);
				listItem.put("_title", _title[i]);
				listItem.put("_url", _url[i]);
				listItems.add(listItem);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			cursor.close();
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.music_item, new String[]{"_id","_title","_url"}, new  int[]{R.id.music_id,R.id.title,R.id.url});
		musicList.setAdapter(adapter);
		
	}
	
	


}

