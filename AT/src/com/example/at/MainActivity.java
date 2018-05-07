package com.example.at;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.example.idao.User;
import com.example.utils.SpUtils;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import dao.MyDatabaseHelper;

public class MainActivity extends BaseActivity implements OnClickListener {

	ImageView userImg;
	TextView userName;
	private Button exitApp,exitLogin,config;
	ImageButton drawer_Ibt,add_Bt;
	private DrawerLayout draw_layout;
	public static User u;
	private MyDatabaseHelper dbHelper;
	private SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		userImg = (ImageView) findViewById(R.id.user_img);
		userName = (TextView) findViewById(R.id.user_name);
		exitApp = (Button) findViewById(R.id.zhuxiao_bt);
		config = (Button) findViewById(R.id.bt_config);
		exitLogin = (Button) findViewById(R.id.bt4);
		drawer_Ibt = (ImageButton) findViewById(R.id.open_drewer);
		add_Bt = (ImageButton) findViewById(R.id.add_bt);
		draw_layout = (DrawerLayout) findViewById(R.id.base_layout);
		dbHelper = new MyDatabaseHelper(this, "TTMS.db", null, 1);
		userImg.setOnClickListener(this);
		userName.setOnClickListener(this);
		exitApp.setOnClickListener(this);
		config.setOnClickListener(this);
		drawer_Ibt.setOnClickListener(this);
		exitLogin.setOnClickListener(this);
		add_Bt.setOnClickListener(this);
		db = dbHelper.getWritableDatabase();
		Cursor cursor = db.query("user", new String[]{"image"}, "name=?", new String[]{SpUtils.getString(this, "User_Name")}, null, null, null);
		cursor.moveToFirst();
		if(cursor.getCount()==0){
//			userImg.setImageResource(R.drawable.ic_launcher);
		}else{
			byte[] photo = cursor.getBlob(cursor.getColumnIndex("image"));
			if (photo!=null) {
				Bitmap bt = BitmapFactory.decodeByteArray(photo, 0, photo.length);
				userImg.setImageBitmap(bt);
			}		
		}
		userName.setText(SpUtils.getString(this, "User_Name"));
		
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.user_img:
			Intent intent = new Intent(Intent.ACTION_PICK,null);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			startActivityForResult(intent, 0);
			break;
		case R.id.user_name:
			break;
		case R.id.open_drewer:
			draw_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
			draw_layout.openDrawer(Gravity.START);
			break;
		case R.id.add_bt:
			if(Drawer_Fragment.getCurrent()==0){
				Intent intent3 = new Intent(this, AddMovieActivity.class);
				startActivity(intent3);
			}
			break;
		case R.id.bt4:
			SpUtils.putBoolean(this, "Is_Auto_Login", false);
			Intent intent2 = new Intent(this, LoginActivity.class);
			startActivity(intent2);
			finish();
		case R.id.zhuxiao_bt:
			finish();
		default:
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
//                buqianqie(data.getData());  
                startPhotoZoom(data.getData());  
                break;  
            // 相机方法监听  
//            case GET_IMAGE_VIA_CAMERA:  
//                File f = new File(Environment.getExternalStorageDirectory()  
//                        + "/" + localTempImgDir + "/" + localTempImgFileName);  
//                try {  
//                    Uri u = Uri.parse(android.provider.MediaStore.Images.Media  
//                            .insertImage(getContentResolver(),  
//                                    f.getAbsolutePath(), null, null));  
//                    // u就是拍摄获得的原始图片的uri，剩下的你想干神马坏事请便……  
//                     startPhotoZoom(u);  
//                //  buqianqie(u);  
//                } catch (Exception e) {  
//                    // TODO Auto-generated catch block  
//                    e.printStackTrace();  
//                }  
//                break;  
            // // 处理结果，剪切图片  
             case 1:  
            	 Bundle extras = data.getExtras();  
            	 if (extras != null) {  
            		 	Bitmap photo = extras.getParcelable("data");  
            		 		ByteArrayOutputStream stream = new ByteArrayOutputStream();  
            		 		photo.compress(Bitmap.CompressFormat.PNG, 100, stream);//  
            		 		//   (0-100)压缩文件  
            		 		userImg.setImageBitmap(photo); // 把图片显示在ImageView控件上  
            		 		ContentValues values = new ContentValues();
            		 		values.put("image", stream.toByteArray());         		 		
            				db.update("user", values, "name = ?",new String[]{SpUtils.getString(this, "User_Name")} );
             }  
             break;  
            }  
        }  
        super.onActivityResult(requestCode, resultCode, data);  
	}
	public void startPhotoZoom(Uri uri) {  
//        Log.d("DDD", "正在执行startPhotoZoom()方法");  
        Intent intent = new Intent("com.android.camera.action.CROP");  
//        urii = uri;  
//        filePath = getUrlFromUri(this, uri);  
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
