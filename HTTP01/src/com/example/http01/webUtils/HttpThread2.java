package com.example.http01.webUtils;

import android.os.Handler;
import android.webkit.WebView;

public class HttpThread2 extends Thread {
	private String url;
	private Handler handler;
	private WebView webview;

	public HttpThread2(String url, WebView webview, Handler handler) {
		// TODO 自动生成的构造函数存根
		this.handler = handler;
		this.url = url;
		this.webview = webview;
	}

	@Override
	public void run() {
		// URL httpUrl = new URL(url);
		// HttpsURLConnection conn = (HttpsURLConnection)
		// httpUrl.openConnection();
		// conn.setReadTimeout(2000);
		// conn.setRequestMethod("Get");
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(conn.getInputStream()));
		// final StringBuffer sb = new StringBuffer();
		// String str;
		// while((str=reader.readLine())!=null){
		// sb.append(str);
		// }
		handler.post(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				webview.loadUrl(url);
			}
		});
	}
}
