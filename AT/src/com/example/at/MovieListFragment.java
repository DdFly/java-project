package com.example.at;

import java.util.LinkedList;

import com.example.utils.GetDataTask;
import com.example.utils.MovieAdapter;
import com.example.utils.MovieItem;
import com.example.utils.SpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import dao.MyDatabaseHelper;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MovieListFragment extends Fragment implements OnItemClickListener {

	private PullToRefreshListView mPullRefreshListView;
    private LinkedList<MovieItem> movieList = new LinkedList<MovieItem>();
    private Button delBt;
    private MyDatabaseHelper dbHelper;
	private SQLiteDatabase db;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		  View view = inflater.inflate(R.layout.movie_list_fragment, container, false);
		  return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onActivityCreated(savedInstanceState);
		delBt = (Button) getActivity().findViewById(R.id.movie_item_del);
		final MovieAdapter adapter = new MovieAdapter(getContext(), R.layout.movie_item, movieList);
//		mPullRefreshListView = (PullToRefreshListView) getActivity().findViewById(R.id.pull_to_refresh_list1); 
		dbHelper = new MyDatabaseHelper(getActivity().getApplication(), "TTMS.db", null, 1);
		db = dbHelper.getWritableDatabase();
		Cursor cursor = db.query("movie", null, null, null, null, null, null);
		initMovies(cursor);
//		bt = (ImageButton) getActivity().findViewById(R.id.bt_add_movie);
//		bt.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO 自动生成的方法存根
//				Toast.makeText(getContext(), "啊啊啊啊啊啊啊", Toast.LENGTH_SHORT).show();
//
//			}
//		});
		  
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
        mPullRefreshListView.setMode(Mode.PULL_FROM_START);
        ListView actualListView = mPullRefreshListView.getRefreshableView();  
        actualListView.setAdapter(adapter); 
        actualListView.setOnItemClickListener(this);
//        mPullRefreshListView.setOnItemClickListener(this);
    }  
	
	private void initMovies(Cursor cursor){
////		for(int i=0;i<20;i++){
////			movieList.add(new MovieItem(R.drawable.baomihua, 
////					"非凡任务", 8.2, R.id.login_div, "哈哈哈这个电影真他妈的好看"));
////		}
//		Cursor cursor = db.query("movie", null, null, null, null, null, null);
		movieList.clear();
		if (cursor.moveToFirst()) {
			do {
				// 遍历Cursor对象，取出数据并打印
				String name = cursor.getString(cursor. getColumnIndex("name"));
				int time = cursor.getInt(cursor. getColumnIndex("time"));
				String project = cursor.getString(cursor.getColumnIndex ("jieshao"));
				byte[] photo = cursor.getBlob(cursor.getColumnIndex("image"));
				Bitmap bt = BitmapFactory.decodeByteArray(photo, 0, photo.length);
				MovieItem item = new MovieItem(bt, name, 0, 0, project,time);
				movieList.add(item);
			} while (cursor.moveToNext());
		}
		cursor.close();
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO 自动生成的方法存根
		Fragment fragment = new MovieChangeFragment();
		getFragmentManager().beginTransaction().replace(R.id.tab1_fram, fragment).addToBackStack(null).commit();
//		Toast.makeText(getContext(), "啊啊啊啊啊啊啊", Toast.LENGTH_SHORT).show();

		
	}
	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		onActivityCreated(null);
	}
	
	
}
