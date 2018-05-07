package com.example.utils;

import java.util.LinkedList;

import com.example.attms.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.os.AsyncTask;

public class GetDataTask extends AsyncTask<Void, Void, MovieItem> {

	private LinkedList<MovieItem> mListItems;
	private PullToRefreshListView mPullRefreshListView;
	private MovieAdapter adapter;

	public GetDataTask(PullToRefreshListView mPullRefreshListView, LinkedList<MovieItem> mListItems,
			MovieAdapter adapter) {
		// TODO 自动生成的构造函数存根
		this.mPullRefreshListView = mPullRefreshListView;
		this.mListItems = mListItems;
		this.adapter = adapter;
	}
	// 后台处理部分

	@Override
	protected MovieItem doInBackground(Void... params) {
		// Simulates a background job.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		return new MovieItem(R.drawable.i2, "烈日灼心", 9.8, R.id.login_div, "哈哈哈哈哈哈哈哈哈哈呵呵呵呵呵呵");
	}

	// 这里是对刷新的响应，可以利用addFirst（）和addLast()函数将新加的内容加到LISTView中
	// 根据AsyncTask的原理，onPostExecute里的result的值就是doInBackground()的返回值

	@Override
	protected void onPostExecute(MovieItem result) {
		// 在头部增加新添内容
		mListItems.addFirst(result);
		
		// 通知程序数据集已经改变，如果不做通知，那么将不会刷新mListItems的集合
		adapter.notifyDataSetChanged();
		// Call onRefreshComplete when the list has been refreshed.
		mPullRefreshListView.onRefreshComplete();
		super.onPostExecute(result);
	}
}
