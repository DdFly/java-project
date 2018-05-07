package 一;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			Socket socket = new Socket("169.254.143.7",8989);
			System.out.println("success");
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
