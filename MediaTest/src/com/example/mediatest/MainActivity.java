package com.example.mediatest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button button_audio;
	Button button_play;
	Button button_recoder;
	Button button_camera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button_audio = (Button) findViewById(R.id.turnAudio);
		button_play = (Button) findViewById(R.id.mediaPlayer);
		button_recoder = (Button) findViewById(R.id.mediaRecoder);
		button_camera = (Button) findViewById(R.id.camera);
		button_audio.setOnClickListener(this);
		button_play.setOnClickListener(this);
		button_recoder.setOnClickListener(this);
		button_camera.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO �Զ����ɵķ������
		Intent intent;
		switch (arg0.getId()) {
		case R.id.turnAudio:
			intent = new Intent(MainActivity.this, AudioActivity.class);
			break;
		case R.id.mediaPlayer:
			intent = new Intent(MainActivity.this, PlayerActivity.class);
			break;
		case R.id.mediaRecoder:
			intent = new Intent(MainActivity.this, RecoderActivity.class);
			break;
		case R.id.camera:
			intent = new Intent(MainActivity.this, CameraActivity.class);
			break;
		default:
			intent = null;
			break;
		}
		startActivity(intent);
	}

}
