package com.example.mediatest;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class AudioActivity extends Activity implements OnClickListener {

	ImageButton bt1, bt2, bt3, bt4, bt5;
	ImageView modeImg;
	ProgressBar bar;
	AudioManager audioMa;
	int value = 0;
	int mode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.audio_layout);
		bt1 = (ImageButton) findViewById(R.id.upButton);
		bt2 = (ImageButton) findViewById(R.id.downButton);
		bt3 = (ImageButton) findViewById(R.id.nomolButton);
		bt4 = (ImageButton) findViewById(R.id.vibrateButton);
		bt5 = (ImageButton) findViewById(R.id.muteButton);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		modeImg = (ImageView) findViewById(R.id.mode_img);
		bar = (ProgressBar) findViewById(R.id.audioProgress);
		audioMa = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		bar.setMax(audioMa.getStreamMaxVolume(AudioManager.STREAM_RING));
		switchMode();

	}

	@Override
	public void onClick(View arg0) {
		// TODO �Զ����ɵķ������
		switch (arg0.getId()) {
		case R.id.upButton:
			audioMa.adjustVolume(AudioManager.ADJUST_RAISE, 0);
			switchMode();
			break;
		case R.id.downButton:
			audioMa.adjustVolume(AudioManager.ADJUST_LOWER, 0);
			switchMode();
			break;
		case R.id.nomolButton:
			audioMa.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			switchMode();
			break;
		case R.id.muteButton:
			audioMa.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			switchMode();
			break;
		case R.id.vibrateButton:
			audioMa.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			switchMode();
			break;
		}
	}

	void switchMode() {
		value = audioMa.getStreamVolume(AudioManager.STREAM_RING);
		mode = audioMa.getRingerMode();
		bar.setProgress(value);
		if (mode == AudioManager.RINGER_MODE_NORMAL) {
			modeImg.setImageDrawable(getResources().getDrawable(R.drawable.power));
		} else if (mode == AudioManager.RINGER_MODE_SILENT) {
			modeImg.setImageDrawable(getResources().getDrawable(R.drawable.mute1));
		} else if (mode == AudioManager.RINGER_MODE_VIBRATE) {
			modeImg.setImageDrawable(getResources().getDrawable(R.drawable.zhendong1));
		}
	}

}
