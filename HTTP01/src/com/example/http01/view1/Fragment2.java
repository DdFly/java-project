package com.example.http01.view1;

import com.example.http01.R;
import com.example.http01.webUtils.HttpThread2;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fragment2 extends Fragment {
	private WebView webview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.fragment2, container, false);
		webview = (WebView) view.findViewById(R.id.web);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebViewClient(new WebViewClient() {

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO 自动生成的方法存根
				view.loadUrl(url);
				return true;
			}
		});
		new HttpThread2("https://www.baidu.com", webview, new Handler()).start();
		return view;
	}
}
