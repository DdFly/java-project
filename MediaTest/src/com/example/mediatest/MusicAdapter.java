package com.example.mediatest;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MusicAdapter extends ArrayAdapter<Music> {

	private int resourceId;

	public MusicAdapter(Context context, int textViewResourceId, List<Music> objects) {
		super(context, textViewResourceId, objects);
		// TODO �Զ����ɵĹ��캯�����
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �Զ����ɵķ������
		Music music = getItem(position);
		Date date = new Date(music.getDuration());
		Format format = new SimpleDateFormat("mm:ss");
		String time = format.format(date);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		TextView text1 = (TextView) view.findViewById(R.id.mediaName);
		TextView text2 = (TextView) view.findViewById(R.id.mediaTime);
		// TextView text3 = (TextView) view.findViewById(R.id.mediaUrl);
		text1.setText(music.getName());
		text2.setText(time);
		// text3.setText(music.getUrl());
		return view;

	}

}
