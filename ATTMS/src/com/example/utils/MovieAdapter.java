package com.example.utils;

import java.util.List;

import com.example.attms.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieAdapter extends ArrayAdapter<MovieItem> {

	int resourceId;
	public MovieAdapter(Context context, int resource, List<MovieItem> objects) {
		super(context, resource, objects);
		// TODO 自动生成的构造函数存根
		resourceId = resource;
	}
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		MovieItem movieItem = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
		ImageView movieImg = (ImageView) view.findViewById(R.id.item_movie_img);
		TextView movieName = (TextView) view.findViewById(R.id.item_movie_name);
		TextView movieGrade = (TextView) view.findViewById(R.id.item_movie_grade);
		TextView movieText = (TextView) view.findViewById(R.id.item_movie_text);
		movieImg.setImageResource(movieItem.getImgId());
		movieName.setText(movieItem.getName());
		movieGrade.setText(movieItem.getGrade()+"");
		movieText.setText(movieItem.getMText());
		return view;
		
	}

}
