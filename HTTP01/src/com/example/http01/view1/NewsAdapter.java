package com.example.http01.view1;

import java.util.List;

import com.example.http01.R;
import com.example.http01.model.NewsBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {

	private List<NewsBean> mList;
	private Context context;

	public NewsAdapter(List<NewsBean> mList, Context context) {
		// TODO 自动生成的构造函数存根
		this.context = context;
		this.mList = mList;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return mList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO 自动生成的方法存根
		return mList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO 自动生成的方法存根
		LayoutInflater inflater = LayoutInflater.from(context);
		ViewHolder viewHolder = null;
		if (viewHolder == null) {
			viewHolder = new ViewHolder();
			arg1 = inflater.inflate(R.layout.news_item, null);
			viewHolder.imageView = (ImageView) arg1.findViewById(R.id.news_img);
			viewHolder.tvTitle = (TextView) arg1.findViewById(R.id.news_title);
			viewHolder.tvContext = (TextView) arg1.findViewById(R.id.news_text);
			arg1.setTag(viewHolder);
		} else {
			arg1.setTag(viewHolder);
		}
		mList.get(arg0);
		viewHolder.tvTitle.setText(NewsBean.newsTitle);
		mList.get(arg0);
		viewHolder.tvContext.setText(NewsBean.newsContent);

		return arg1;
	}

	class ViewHolder {
		ImageView imageView;
		TextView tvTitle, tvContext;
	}

}
