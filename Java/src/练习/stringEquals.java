package 练习;

import java.util.Scanner;

public class stringEquals {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String s,S[];
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			s = input.nextLine();
			S = s.split(" ");
			s=check(S);
			if(s.length()>0)
				System.out.println("The commom prefix is "+s);
			else
				System.out.println("No common prefix");
		}

	}
	public static String check(String S[]){
		int i=0;
		for(i=0;i<(S[0].length()>S[1].length()?S[0].length():S[1].length());i++){
			if(S[0].charAt(i)!=S[1].charAt(i)){
				break;
			}
		}
		return S[0].substring(0, i);
		
	}

}
