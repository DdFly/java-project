package com.example.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{
	private int resourceId;
	public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
		super(context, textViewResourceId, objects);
		// TODO 自动生成的构造函数存根
		resourceId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		Fruit fruit = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_id);
		TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
		TextView fruitBeizhu = (TextView) view.findViewById(R.id.fruit_beizhu);
		fruitImage.setImageResource(fruit.getImageId());
		fruitName.setText(fruit.getName());
		fruitBeizhu.setText(fruit.getBeizhu());
		return view;
	}
	


}
