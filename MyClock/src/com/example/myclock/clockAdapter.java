package com.example.myclock;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

public class clockAdapter extends ArrayAdapter<Clock>{

	private int listItemId;
	public clockAdapter(Context context, int textViewResourceId, List<Clock> objects) {
		super(context, textViewResourceId, objects);
		// TODO 自动生成的构造函数存根
		listItemId = textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		Clock clock = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(listItemId, null);
		TextView title = (TextView) view.findViewById(R.id.listTitle_time);
		TextView information = (TextView) view.findViewById(R.id.list_inf);
		Switch turn = (Switch) view.findViewById(R.id.listclock_tog);
		title.setText(clock.getTime());
		information.setText(clock.getInf());
		turn.setChecked(clock.getTurn());
		return view;
	}
	

}
