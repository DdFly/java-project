package com.example.chijiuhua;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WenjianSave extends Activity{

	private Button save;
	private EditText edit1;
	private Button clear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wenjian_layout);
		save = (Button) findViewById(R.id.SAVE);
		edit1 = (EditText) findViewById(R.id.edit1);
		clear = (Button) findViewById(R.id.clear);
		clear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				deleteFile("data");
			}
		});
		String input = load();
		//Toast.makeText(WenjianSave.this, input, Toast.LENGTH_SHORT).show();
		if(!TextUtils.isEmpty(input)){
			edit1.setText(input);
			edit1.setSelection(input.length());
		}
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				String s = edit1.getText().toString();
				Save(s);
				edit1.setText("");
				
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();
		String s = edit1.getText().toString();
		if(!TextUtils.isEmpty(s)){
			Linshi(s);
		}
	}
	public void Save(String string){
		FileOutputStream out;
		BufferedWriter writer = null;
		try {
			out = openFileOutput("data", Context.MODE_APPEND);
			String s = getFilesDir().toString();
			Toast.makeText(WenjianSave.this, s, Toast.LENGTH_SHORT).show();
			writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write(string);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
	public void Linshi(String string){
		FileOutputStream out;
		BufferedWriter writer=null;
		try {
			out = openFileOutput("Temp", Context.MODE_PRIVATE);
			writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write(string);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
				try {
					if(writer!=null){
					writer.close();
					}
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		
		
	}
	public String load(){
		FileInputStream in =  null;
		BufferedReader reader=null;
		StringBuilder context = new StringBuilder();
		String line="";
		try {
			in = openFileInput("data");
			reader = new BufferedReader(new InputStreamReader(in));
			while((line=reader.readLine())!=null){
				//Toast.makeText(WenjianSave.this, line, Toast.LENGTH_SHORT).show();
				context.append(line);
			}
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		//Toast.makeText(WenjianSave.this, context.toString(), Toast.LENGTH_SHORT).show();
		return context.toString();
		
	}

}

