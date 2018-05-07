package com.example.message;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;

public class vedio extends Activity implements OnClickListener{

	private VideoView view;
	private Button start;
	private Button stop;
	private Button pause;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dio_layout);
		view = (VideoView) findViewById(R.id.vidio_view);
		start = (Button) findViewById(R.id.dio_start);
		stop = (Button) findViewById(R.id.dio_stop);
		pause = (Button) findViewById(R.id.dio_pause);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		pause.setOnClickListener(this);
		initVidioPath();
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.dio_start:
			view.start();
			break;
		case R.id.dio_stop:
			view.resume();
			break;
		case R.id.dio_pause:
			view.pause();
			break;
		}
	}
	protected void onDestory(){
		super.onDestroy();
		view.suspend();
	}
	private void initVidioPath(){
		File file = new File("/activity.mp4");
		view.setVideoPath(file.getParent());
	}
	
}
