package com.example.mediatest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerActivity extends Activity
		implements OnClickListener, OnErrorListener, OnCompletionListener, OnItemClickListener {

	ImageButton bt1, bt2, bt3;
	TextView text;
	ListView mlview;
	MediaPlayer mp;
	boolean isPaused = false;
	boolean sdCardExit;
	ArrayList<String> musicFiles = null;
	MusicAdapter adapter;
	File myDir;
	ArrayList<Music> musicList;
	ContentResolver mResolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_layout);
		bt1 = (ImageButton) findViewById(R.id.playMusic);
		bt2 = (ImageButton) findViewById(R.id.pauseMusic);
		bt3 = (ImageButton) findViewById(R.id.stopMusic);
		text = (TextView) findViewById(R.id.musicText);
		mlview = (ListView) findViewById(R.id.musicList);
		mResolver = getContentResolver();
		musicList = new ArrayList<Music>();
		mlview.setOnItemClickListener(this);

		sdCardExit = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		if (sdCardExit) {
			myDir = Environment.getExternalStorageDirectory();
			// getMusicFiles();
			reader();
		} else {
			text.setText("点击播放"); //$NON-NLS-1$
		}
		adapter = new MusicAdapter(this, R.layout.media_item, musicList);
		mlview.setAdapter(adapter);
		bt2.setEnabled(false);
		bt3.setEnabled(false);
		mp = new MediaPlayer();
		try {
			mp.setDataSource(PlayerActivity.this,Uri.parse(musicList.get(1).getUrl()));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		mp.setOnCompletionListener(this);
		mp.setOnErrorListener(this);

	}

	@Override
	public void onClick(View arg0) {
		try{
			switch (arg0.getId()) {
			case R.id.playMusic:
//				if (mp != null) {
//					mp.reset();
//				}
				mp.prepare();
				mp.start();
				text.setText("正在播放"); //$NON-NLS-1$
				bt2.setEnabled(true);
				bt1.setEnabled(false);
				break;
			case R.id.pauseMusic:
				if (mp != null) {
					if (isPaused == false) {
						mp.pause();						
						text.setText("已暂停"); //$NON-NLS-1$
						isPaused = true;
					} else {
						mp.start();
						text.setText("正在播放"); //$NON-NLS-1$
						isPaused = false;
					}
				}
				break;
			case R.id.stopMusic:
				if (mp != null) {
					mp.reset();
					text.setText("停止播放"); //$NON-NLS-1$
					bt2.setEnabled(false);
					bt1.setEnabled(true);
				}

				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
		mp.release();
		text.setText("播放出错"); //$NON-NLS-1$
		return false;
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		mp.release();
		text.setText("播放完成"); //$NON-NLS-1$
	}

	void reader() {
		Cursor cursor = mResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
				MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
		while (cursor.moveToNext()) {
			String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
			String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
			long time = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
			musicList.add(new Music(name, url, time));
		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO �Զ����ɵķ������
		Cursor cursor = mResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
		if (cursor.moveToNext()) {
			String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
			mp.reset();
			try {
				mp.setDataSource(PlayerActivity.this, Uri.parse(url));
				mp.prepare();
				mp.start();
				text.setText("正在播放");
				bt2.setEnabled(true);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} 

		} else {

		}
		Toast.makeText(getBaseContext(), musicList.get(arg2).getName().toString(), Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		mp.release();
	}
}
