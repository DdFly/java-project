package 一;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverTest {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ServerSocket sever;
		Socket socket;
		String s;		
		try {
			sever = new ServerSocket(8989);
			System.out.println("等待连接。。。。。。");
			socket = sever.accept();
			System.out.println("连接成功。。。。。。");
			System.out.println(sever.getLocalSocketAddress().toString());
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			DataInputStream din = new DataInputStream(in);
			DataOutputStream dout = new DataOutputStream(out);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("等待客户端发送消息。。。。。。");
			while(true){
				s = din.readUTF();
				System.out.println("接受到的消息为："+s);
				dout.writeUTF("您发送的是："+s);
				if(s.trim().equals("exit"))
					break;
			}
			din.close();
			dout.close();
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
