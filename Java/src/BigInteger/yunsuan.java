package BigInteger;
import java.math.BigInteger;
import java.util.Scanner;

public class yunsuan {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		String n1,n2,n3;
		n3 = input.nextLine();
		n1 = input.nextLine();
		n2 = input.nextLine();
		System.out.println(n1+"\n+\n"+n2+"\n=\n"+new BigInteger(n1).add(new BigInteger(n2)));
		System.out.println(n1+"\n-\n"+n2+"\n=\n"+new BigInteger(n1).subtract(new BigInteger(n2)));
		System.out.println(n1+"\n*\n"+n2+"\n=\n"+new BigInteger(n1).multiply(new BigInteger(n2)));
		System.out.println(n1+"\n/\n"+n2+"\n=\n"+new BigInteger(n1).divide(new BigInteger(n2)));


	}

}
