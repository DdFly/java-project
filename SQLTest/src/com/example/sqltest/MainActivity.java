package com.example.sqltest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button create;
	private Button add;
	private Button delete;
	private Button updata;
	private Button requre;
	private MyDatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);
		create = (Button) findViewById(R.id.create);
		add = (Button) findViewById(R.id.add);
		updata = (Button) findViewById(R.id.undata);
		requre = (Button) findViewById(R.id.select);
		delete = (Button) findViewById(R.id.delete);
		create.setOnClickListener(this);
		add.setOnClickListener(this);
		updata.setOnClickListener(this);
		delete.setOnClickListener(this);
		requre.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		SQLiteDatabase db;
		ContentValues values;
		switch(arg0.getId()){
		case R.id.create:
			dbHelper.getWritableDatabase();
			break;
		case R.id.add:
			db = dbHelper.getWritableDatabase();
			values = new ContentValues();
			values.put("category_name", "aaa");
			values.put("category_code", 1);
			db.insert("category", null, values);
			break;
		case R.id.undata:
			db = dbHelper.getWritableDatabase();
			values = new ContentValues();
			values.put("price", 15.8);
			db.update("Book", values, "name=?", new String[]{"你的孤独，虽败犹荣"});
			break;
		case R.id.select:
			db = dbHelper.getWritableDatabase();
			Cursor cursor = db.query("Book", null, null, null, null, null, null);
			if(cursor.moveToFirst()){
				do{
					Log.d("MainActivity",""+cursor.getInt(cursor.getColumnIndex("id")));
					Log.d("MainActivity",cursor.getString(cursor.getColumnIndex("name")));
					Log.d("MainActivity",cursor.getString(cursor.getColumnIndex("author")));
					Log.d("MainActivity",""+cursor.getInt(cursor.getColumnIndex("pages")));
					Log.d("MainActivity",""+cursor.getDouble(cursor.getColumnIndex("price")));
					Log.d("MainActivity",""+cursor.getInt(cursor.getColumnIndex("category_id")));
				}while(cursor.moveToNext());
			}
			cursor.close();
			Cursor cursor2 = db.query("Category", null, null, null, null, null, null);
			if(cursor2.moveToFirst()){
				do{
					Log.d("MainActivity",""+cursor2.getInt(cursor2.getColumnIndex("id")));
					Log.d("MainActivity",cursor2.getString(cursor2.getColumnIndex("category_name")));
					Log.d("MainActivity",""+cursor2.getInt(cursor2.getColumnIndex("category_id")));
				}while(cursor2.moveToNext());
			}
			cursor2.close();
			break;
		case R.id.delete:
			db = dbHelper.getWritableDatabase();
			db.delete("Book", "id=?", new String[]{"2"});
			db.delete("Book", "id=?", new String[]{"3"});
			db.delete("Book", "id=?", new String[]{"4"});
			db.delete("Book", "id=?", new String[]{"5"});
			break;
			default:
		
		}
		
	}
	
}
