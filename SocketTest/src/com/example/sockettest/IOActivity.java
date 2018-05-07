package com.example.sockettest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IOActivity extends Activity {

	Socket socket;
	InputStream in;
	OutputStream out;
	BufferedReader sin;
	DataInputStream din;
	DataOutputStream dout;
	String s;
	TextView retText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_io);
		try {
			socket = new Socket("169.254.143.7",8989);
		} catch (UnknownHostException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		retText = (TextView) findViewById(R.id.ret_text);
		din = new DataInputStream(in);
		dout = new DataOutputStream(out);
		try {
			in = socket.getInputStream();
			out  = socket.getOutputStream();
			sin = new BufferedReader(new InputStreamReader(System.in));
			s = din.readUTF();
			retText.setText(s);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}


}
