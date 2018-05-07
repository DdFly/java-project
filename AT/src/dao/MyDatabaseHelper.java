package dao;

import javax.xml.transform.stream.StreamResult;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	
	public static final String CREATE_USER = "create table user ( id integer primary key autoincrement,"
			+" name text, image binary, sex text, age integer, phone text, password text)";
	public static final String CREATE_MOVIE= "create table movie ( id integer primary key autoincrement,"
			+" name text,image binary, time integer, grade real, type text, jieshao text)";
	private Context mContext;
	public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO 自动生成的构造函数存根
		mContext = context;
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		db.execSQL(CREATE_USER);
		db.execSQL(CREATE_MOVIE);
		ContentValues values = new ContentValues();
		// 开始组装第一条数据
		values.put("name", "daidong");
		values.put("sex", "男");
		values.put("age", 22);
		values.put("phone", "18292459148");
		values.put("password", "aaaaa");
		
		db.insert("user", null, values); // 插入第一条数据
		values.put("name", "aoifjojff");
		values.put("jieshao", "asjdfihioia");
		db.insert("movie", null, values);
		Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根

	}

}
