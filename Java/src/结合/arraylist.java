package ���;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arraylist {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		String s;
		List<String> list = new ArrayList<String>();
		while(input.hasNext()){
			s = input.nextLine();
			list.add(s);
			list.sort(null);
			System.out.println(list);
			//s = input.nextLine();
		}
	}

}
