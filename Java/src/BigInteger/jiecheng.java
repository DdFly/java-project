package BigInteger;
import java.math.BigInteger;
import java.util.Scanner;

public class jiecheng {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		BigInteger S = BigInteger.ONE;
		for (int i=1;i<=n;i++){
			S = S.multiply(new BigInteger(i+""));
		}
		System.out.println(S);
	}

}
