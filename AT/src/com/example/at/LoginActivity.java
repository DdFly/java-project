package com.example.at;

import com.example.utils.ActivityCollector;
import com.example.utils.SpUtils;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import dao.MyDatabaseHelper;

public class LoginActivity extends BaseActivity {

	private Button bt_login;
	private CheckBox autoLogin;
	private EditText username;
	private EditText userpass;
	private MyDatabaseHelper dbHelper;
	private ImageView userimage;
	private SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		bt_login = (Button) findViewById(R.id.signin_button);
		autoLogin = (CheckBox) findViewById(R.id.check_savepsw);
		username = (EditText) findViewById(R.id.username_edit);
		userpass = (EditText) findViewById(R.id.password_edit);
		userimage = (ImageView) findViewById(R.id.login_user_img);
		dbHelper = new MyDatabaseHelper(this, "TTMS.db", null, 1);
		db = dbHelper.getWritableDatabase();
		username.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO 自动生成的方法存根
				if(!hasFocus){
					Cursor cursor = db.query("user", new String[]{"image"}, "name=?", new String[]{username.getText().toString()}, null	, null, null);
					if(cursor.moveToFirst()){
						byte[] photo = cursor.getBlob(cursor.getColumnIndex("image"));
						if (photo!=null) {
							Bitmap bt = BitmapFactory.decodeByteArray(photo, 0, photo.length);
							userimage.setImageBitmap(bt);
						}		
					}
				}
			}
		});
		bt_login.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if((username.getText().toString().equals(""))||(userpass.getText().toString().equals(""))){
					Toast.makeText(getApplicationContext(), "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
				}
				else {
					
					// 查询Book表中所有的数据
					Cursor cursor = db.query("user", new String[]{"name","password"}, "name=?", new String[]{username.getText().toString()}, null, null, null);
					cursor.moveToFirst();
					if(cursor.getCount()==0){
						Toast.makeText(getApplicationContext(), "用户不存在", Toast.LENGTH_SHORT).show();
						return;
					}
					else if(!userpass.getText().toString().equals(cursor.getString(cursor.getColumnIndex("password")))){
						Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();
						return;
					}
					if (autoLogin.isChecked()==true) {
						SpUtils.putBoolean(getApplicationContext(), "Is_Auto_Login", true);
					}else{       
						SpUtils.putBoolean(getApplicationContext(), "Is_Auto_Login", false);
					}
					SpUtils.putString(getApplicationContext(),"User_Name",username.getText().toString());
					SpUtils.putString(getApplicationContext(),"User_Pass",userpass.getText().toString() );
					Intent intent = new Intent(getBaseContext(), MainActivity.class);				
					startActivity(intent);
					finish();
				}				
			}
		});
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}

	

}
