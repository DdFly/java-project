package com.example.lianxiren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.sax.TransformerHandler;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore.Images;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	ListView listView;
	EditText edit;
	TextView text;
	FragmentTransaction transformation;
	Cursor cursor = null;
	Button bt1;
	static SimpleAdapter adapter;
	static List<Map<String, String>> lists = new ArrayList<Map<String,String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit = (EditText) findViewById(R.id.input_search);
		text = (TextView) findViewById(R.id.search_text);
		bt1 = (Button) findViewById(R.id.add);
		bt1.setOnClickListener(this);
		adapter = new SimpleAdapter(this, lists, R.layout.list_item, new String[]{"name","num"}, new int[]{R.id.name,R.id.number});
		final ContentResolver resolver = getContentResolver();
		final FirstFragment fragment = new FirstFragment();
		FragmentManager manager = getFragmentManager();
		cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,"sort_key");
		transformation = manager.beginTransaction();
		transformation.add(R.id.list_id, fragment).commit();
		edit.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO 自动生成的方法存根
				if(cursor.moveToFirst()){
					lists.clear();
					do{
						Map<String,String> list = new HashMap<String, String>();
						String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
						String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						if(name.contains(edit.getText().toString()) || number.toString().contains(edit.getText().toString())){
							list.put("name", name);
							list.put("num", number);
							lists.add(list);
						}
	
					}while(cursor.moveToNext());
					runOnUiThread(new Runnable() {
						public void run() {
							text.setText("共查找到"+lists.size()+"个联系人：");							
							adapter.notifyDataSetChanged();
							text.setVisibility(View.VISIBLE);
						}
					});
					
				}	
				if(TextUtils.isEmpty(edit.getText())){
					text.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		switch(arg0.getId()){
		case R.id.add:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			TableLayout layout = (TableLayout) getLayoutInflater().inflate(R.layout.addcontact_layout, null);
			builder.setTitle("添加通讯录").setView(layout);
			builder.setPositiveButton("添加", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO 自动生成的方法存根
					EditText name = (EditText) findViewById(R.id.name_input);
					EditText num = (EditText) findViewById(R.id.num_input);
					if((!TextUtils.isEmpty(name.getText()))&& (!TextUtils.isEmpty(num.getText()))){
						
					}
					else
						new AlertDialog.Builder(getApplicationContext()).setTitle("错误").setMessage("姓名或账号不能为空！").create().show();
				}
			});
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO 自动生成的方法存根
					
				}
			});
			builder.create().show();
			break;
		}
	}

	



	
}
