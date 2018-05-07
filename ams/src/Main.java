import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int r = input.nextInt();
		int avg = input.nextInt();
		int[] a = new int[n];;
		int[] b = new int[n];
		int[] d = new int[n];
		for(int i=0;i<n;i++){
			a[i]=input.nextInt();
			b[i]=input.nextInt();
		}
		int c1 = r*avg;
		int c2 = 0;
		for(int i=0;i<n;i++){
			c2=c2+a[i];
		}
		int c3 = c1-c2;
		d=b;
		
	}

}
