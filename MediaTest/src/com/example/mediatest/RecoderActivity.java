package com.example.mediatest;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class RecoderActivity extends Activity implements OnClickListener {

	ImageButton bt4, bt5, bt6, bt7;
	ListView list;
	TextView text;
	boolean sdCardExit;
	ArrayList<String> recordFiles = null;
	ArrayAdapter<String> adapter;
	File myDir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recoder_layout);
		bt4 = (ImageButton) findViewById(R.id.startRecord);
		bt5 = (ImageButton) findViewById(R.id.stopRecord);
		bt6 = (ImageButton) findViewById(R.id.playRecord);
		bt7 = (ImageButton) findViewById(R.id.deletRecord);
		list = (ListView) findViewById(R.id.recodList);
		text = (TextView) findViewById(R.id.recordFlag);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		bt6.setOnClickListener(this);
		bt7.setOnClickListener(this);
		bt5.setEnabled(false);
		bt6.setEnabled(false);
		bt7.setEnabled(false);
		sdCardExit = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
		if (sdCardExit) {
			myDir = Environment.getExternalStorageDirectory();
			getRecordFiles();
		} else
			text.setText("�洢������");
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recordFiles);
		list.setAdapter(adapter);

	}

	@Override
	public void onClick(View arg0) {
		// TODO �Զ����ɵķ������
		switch (arg0.getId()) {
		case R.id.startRecord:

			break;
		case R.id.stopRecord:

			break;
		case R.id.playRecord:

			break;
		case R.id.deletRecord:

			break;
		}
	}

	private void getRecordFiles() {
		recordFiles = new ArrayList<String>();
		if (sdCardExit) {
			File[] files = myDir.listFiles();
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().indexOf(".") > 0) {
						String file = files[i].getName().substring(files[i].getName().indexOf("."));
						if (file.toLowerCase().equals(".mp3"))
							recordFiles.add(files[i].getName());
					}

				}
			}
		}
	}

}
