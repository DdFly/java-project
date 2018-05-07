package com.example.message;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class music extends Activity implements OnClickListener{
	private MediaPlayer player;
	private Button start;
	private Button stop;
	private Button pause;
	private ProgressBar bar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mc_layout);
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		pause = (Button) findViewById(R.id.pause);
		bar = (ProgressBar) findViewById(R.id.bar);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		pause.setOnClickListener(this);
		initMediaPlayer();
	}
	@Override
	public void onClick(View arg0) {
		// TODO �Զ����ɵķ������
		
		switch(arg0.getId()){
		case R.id.start:
			if(!player.isPlaying())
				player.start();
			break;
		case R.id.stop:
			if(player.isPlaying()){
				player.reset();
				initMediaPlayer();
			}
				
			break;
		case R.id.pause:
			if(player.isPlaying())
				player.pause();
			break;
		}
	}
	private void initMediaPlayer(){
		File file = new File(Environment.getExternalStorageDirectory(),"/storage/emulated/0/netease/cloudmusic/Music/�����-����.mp3");
		//player = MediaPlayer.create(this, R.raw.cccc);
		bar.setMax(player.getCurrentPosition());
		player = new MediaPlayer();
		try {
			player.setDataSource(file.getPath());
			player.prepare();
		} catch (IllegalArgumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();
		player.stop();
		player.release();
	}
	
	
	
}
