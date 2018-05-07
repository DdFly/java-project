package com.example.attms;

import java.util.Arrays;
import java.util.LinkedList;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tab2Fragment extends Fragment {

	private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",  
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",  
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",  
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",  
            "Allgauer Emmentaler" };  
    private LinkedList<String> mListItems;  
    private PullToRefreshListView mPullRefreshListView;
    private ArrayAdapter<String> mAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.tab2_fragment, container,false);
		return view;	
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onActivityCreated(savedInstanceState);
		mPullRefreshListView = (PullToRefreshListView) getActivity().findViewById(R.id.pull_to_refresh_list2);  
		  
        // Set a listener to be invoked when the list should be refreshed.  
        mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {  
            @Override  
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {  
                String label = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(),  
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);  
  
                // Update the LastUpdatedLabel  
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);  
  
                // Do work to refresh the list here.  
                //new GetDataTask(mPullRefreshListView, mListItems, mAdapter).execute();
            }  
        });  
  
        mListItems = new LinkedList<String>();  
        mListItems.addAll(Arrays.asList(mStrings));  
  
        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mListItems);  
  
        //这两个绑定方法用其一  
        // 方法一  
//       mPullRefreshListView.setAdapter(mAdapter);  
        //方法二  
        ListView actualListView = mPullRefreshListView.getRefreshableView();  
        actualListView.setAdapter(mAdapter);  
    }  

}
