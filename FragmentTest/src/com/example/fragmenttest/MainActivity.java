package com.example.fragmenttest;

import java.util.zip.Inflater;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		Fragment first = new FirstFragement();
//		getFragmentManager().beginTransaction().add(R.id.main, first)
//		getFragmentManager().beginTransaction().add(R.id.main, first)
		getFragmentManager().beginTransaction().add(R.id.main, first).commit();
	}

}
