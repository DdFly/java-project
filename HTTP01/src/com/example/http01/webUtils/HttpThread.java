package com.example.http01.webUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.os.Handler;
import android.webkit.WebView;

public class HttpThread extends Thread {
	private WebView webview;
	private String url;
	private Handler handler;

	public HttpThread(WebView webview, String url, Handler handler) {
		// TODO 自动生成的构造函数存根
		this.webview = webview;
		this.url = url;
		this.handler = handler;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			URL httpUrl = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) httpUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(5000);
			final StringBuffer sb = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str;
			while ((str = reader.readLine()) != null) {
				sb.append(str);
				System.out.println(str);
			}

			handler.post(new Runnable() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					webview.loadData(sb.toString(), "text/html;charset=utf-8", null);
				}
			});
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
