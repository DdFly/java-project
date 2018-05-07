package com.example.attms;

import java.util.LinkedList;

import com.example.utils.GetDataTask;
import com.example.utils.MovieAdapter;
import com.example.utils.MovieItem;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Tab1Fragment extends Fragment implements OnItemClickListener {

	  
    private PullToRefreshListView mPullRefreshListView;
    private LinkedList<MovieItem> movieList = new LinkedList<MovieItem>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.tab1_fragment, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onActivityCreated(savedInstanceState);
		initMovies();
		final MovieAdapter adapter = new MovieAdapter(getActivity(), R.layout.movie_item, movieList);
		mPullRefreshListView = (PullToRefreshListView) getActivity().findViewById(R.id.pull_to_refresh_list1);  
		  
        // 设置拉动监听器  
        mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {  
            @Override  
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {  
            	//最后一次刷新时间
                String label = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(),  
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);  
  
                // 更新时间  
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);  
  
                // 异步执行  
                new GetDataTask(mPullRefreshListView,movieList,adapter).execute();  
            }  
        });  
   
//        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mListItems);  
  
        //这两个绑定方法用其一  
        // 方法一  
//       mPullRefreshListView.setAdapter(mAdapter);  
        //方法二  
        mPullRefreshListView.setMode(Mode.PULL_FROM_END);
        ListView actualListView = mPullRefreshListView.getRefreshableView();  
        actualListView.setAdapter(adapter); 
        actualListView.setOnItemClickListener(this);
    }  
	
	private void initMovies(){
		for(int i=0;i<20;i++){
			movieList.add(new MovieItem(R.drawable.baomihua, 
					"非凡任务", 8.2, R.id.login_div, "哈哈哈这个电影真他妈的好看"));
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO 自动生成的方法存根
		
	}
  
    

}



