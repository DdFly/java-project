package com.example.at;

import java.io.ByteArrayOutputStream;

import com.example.utils.SpUtils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import dao.MyDatabaseHelper;

public class AddMovieActivity extends Activity implements OnClickListener {

	private EditText mName, mTime, mProject;
	private ImageView mImage;
	private ImageButton fanhuiBt, wanchengBt;
	private CheckBox check0, check1, check2, check3, check4, check5, check6, check7, check8, check9, check10;
	private MyDatabaseHelper dbHelper;
	private SQLiteDatabase db;
	private Bitmap bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_add_movie);
		dbHelper = new MyDatabaseHelper(this, "TTMS.db", null, 1);
		db = dbHelper.getWritableDatabase();
		mName = (EditText) findViewById(R.id.movie_edit_name);
		mTime = (EditText) findViewById(R.id.movie_edit_time);
		mProject = (EditText) findViewById(R.id.movie_edit_text);
		mImage = (ImageView) findViewById(R.id.movie_edit_img);
		fanhuiBt = (ImageButton) findViewById(R.id.open_drewer);
		wanchengBt = (ImageButton) findViewById(R.id.add_bt);
		bt = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		mImage.setOnClickListener(this);
		fanhuiBt.setOnClickListener(this);
		wanchengBt.setOnClickListener(this);
//		wanchengBt.setEnabled(false);
		mName.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO 自动生成的方法存根
				if(!hasFocus){
					Cursor cursor = db.query("movie", null,"name=?", new String[]{mName.getText().toString()}, null, null, null);
					if(cursor.getCount()!=0){
						Toast.makeText(getApplicationContext(), "该电影已经存在", Toast.LENGTH_SHORT).show();
					}else if((mName.getText().toString()==null)||(mName.getText().toString()=="")){
						Toast.makeText(getApplicationContext(), "电影名不能为空", Toast.LENGTH_SHORT).show();
					}						
				} 
				
			}
		});
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.movie_edit_img:
			Intent intent = new Intent(Intent.ACTION_PICK, null);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			startActivityForResult(intent, 0);
			break;
		case R.id.open_drewer:
			finish();
			break;
		case R.id.add_bt:
			ContentValues values = new ContentValues();
			// 开始组装第一条数据
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bt.compress(Bitmap.CompressFormat.PNG, 100, stream);
			values.put("name", mName.getText().toString());
			values.put("time", Integer.parseInt(mTime.getText().toString()));
			values.put("jieshao", mProject.getText().toString());
			values.put("image", stream.toByteArray());
			db.insert("movie", null, values);
			Toast.makeText(getApplicationContext(), "添加成功！！！", Toast.LENGTH_SHORT).show();
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			// 直接进入相册
			case 0:
				// buqianqie(data.getData());
				startPhotoZoom(data.getData());
				break;
			// // 处理结果，剪切图片
			case 1:
				Bundle extras = data.getExtras();
				if (extras != null) {
					bt = extras.getParcelable("data");
					// stream = new ByteArrayOutputStream();
					// photo.compress(Bitmap.CompressFormat.PNG, 100, stream);//
					// (0-100)压缩文件
					mImage.setImageBitmap(bt); // 把图片显示在ImageView控件上
				}
				break;
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void startPhotoZoom(Uri uri) {
		// Log.d("DDD", "正在执行startPhotoZoom()方法");
		Intent intent = new Intent("com.android.camera.action.CROP");
		// urii = uri;
		// filePath = getUrlFromUri(this, uri);
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 64);
		intent.putExtra("outputY", 64);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, 1);
	}

}
