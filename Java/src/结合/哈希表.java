package 结合;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 哈希表 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String s1,s2,s3;
		Scanner input = new Scanner(System.in);
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("输入电话簿(noname结束):");
		s1 = input.next();
		while(!s1.equals("noname")){
			s2 = input.next();
			map.put(s1, s2);
			s1 = input.next();
		}
		input.nextLine();
		System.out.println("输入查找的姓名：");
		s3 = input.nextLine();
		if (map.containsKey(s3)==true){
			System.out.println(map.get(s3));
		}
		else
			System.out.println("未找到该人！\n");
	}

}
