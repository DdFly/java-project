package com.example.at;

import com.example.utils.SpUtils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import dao.MyDatabaseHelper;

public class SplashActivity extends BaseActivity{
	
	private boolean zidonglogin;
	private MyDatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		boolean isFirstOpen = SpUtils.getBoolean(this, "FIRST_APP");
        // 如果是第一次启动，则先进入功能引导页
        if (!isFirstOpen) {
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // 如果不是第一次启动app，则正常显示启动屏
        setContentView(R.layout.activity_splash);
        dbHelper = new MyDatabaseHelper(getApplicationContext(), "TTMS.db", null, 1);
		dbHelper.getWritableDatabase();
		zidonglogin  = SpUtils.getBoolean(getApplicationContext(), "Is_Auto_Login");
//        Thread t = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO 自动生成的方法存根
//				
//				
//			}
//		});
//        t.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHomeActivity(zidonglogin);
            }
        }, 1000);
        
    }

    private void enterHomeActivity(boolean b) {
    	Intent intent;
    	if (b==true)
    		intent = new Intent(this, MainActivity.class);
    	else
    		intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

	
}
