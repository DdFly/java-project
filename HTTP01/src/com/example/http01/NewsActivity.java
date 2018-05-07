package com.example.http01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.http01.model.NewsBean;
import com.example.http01.view1.NewsAdapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class NewsActivity extends Activity {

	private ListView newsList;
	private ImageButton firstPage;
	private ImageButton videoPage;
	private ImageButton guanzhuPage;
	private ImageButton selfPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_news);
		newsList = (ListView) findViewById(R.id.news_list);
		firstPage = (ImageButton) findViewById(R.id.first_page);
		videoPage = (ImageButton) findViewById(R.id.video_page);
		guanzhuPage = (ImageButton) findViewById(R.id.guanzhu_page);
		selfPage = (ImageButton) findViewById(R.id.self_page);
		String url = "http://www.imooc.com/api/teacher?type=4&num=30";
		// newsList.setAdapter(adapter);
		new NewsAsyncTask().execute(url);
	}

	private List<NewsBean> getJsonData(String url) {
		List<NewsBean> list = new ArrayList<NewsBean>();
		URL httpUrl;
		try {
			httpUrl = new URL(url);
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpUrl.openStream(), "utf-8"));
			String str;
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			Log.d("NewsActivity", sb.toString());
			JSONObject jsonObject = new JSONObject(sb.toString());
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			NewsBean newsBean;
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				newsBean = new NewsBean();
				NewsBean.newsIconUrl = jsonObject.getString("picSmall");
				NewsBean.newsTitle = jsonObject.getString("name");
				NewsBean.newsContent = jsonObject.getString("description");
				list.add(newsBean);
			}

		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return list;
	}

	class NewsAsyncTask extends AsyncTask<String, Void, List<NewsBean>> {

		@Override
		protected List<NewsBean> doInBackground(String... arg0) {
			// TODO 自动生成的方法存根
			return getJsonData(arg0[0]);
		}

		@Override
		protected void onPostExecute(List<NewsBean> result) {
			// TODO 自动生成的方法存根
			super.onPostExecute(result);
			NewsAdapter adapter = new NewsAdapter(result, NewsActivity.this);
			newsList.setAdapter(adapter);
		}

	}

}
