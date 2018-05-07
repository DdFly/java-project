package com.example.thirdactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class ThirdActivity extends Activity{
	ProgressBar bar;
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
		bar = (ProgressBar)findViewById(R.id.progress_bar);
		Button button = (Button)findViewById(R.id.bar_button);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				int progress = bar.getProgress();
				progress +=10;
				bar.setProgress(progress);
			}
		});
	}
}
