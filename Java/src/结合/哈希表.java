package ���;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ��ϣ�� {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String s1,s2,s3;
		Scanner input = new Scanner(System.in);
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("����绰��(noname����):");
		s1 = input.next();
		while(!s1.equals("noname")){
			s2 = input.next();
			map.put(s1, s2);
			s1 = input.next();
		}
		input.nextLine();
		System.out.println("������ҵ�������");
		s3 = input.nextLine();
		if (map.containsKey(s3)==true){
			System.out.println(map.get(s3));
		}
		else
			System.out.println("δ�ҵ����ˣ�\n");
	}

}
