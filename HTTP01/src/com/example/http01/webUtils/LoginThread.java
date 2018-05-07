package com.example.http01.webUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class LoginThread extends Thread {

	private String url;
	private String name;
	private String pass;

	public LoginThread(String url, String name, String pass) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.pass = pass;
		this.url = url;
	}

	private void doGet() {
		// TODO 自动生成的方法存根
		URL httpUrl;
		try {
			httpUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
			conn.setReadTimeout(2000);
			conn.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String str = new String();
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}

		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		doGet();
	}
}
