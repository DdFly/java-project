package 一;

import java.util.Scanner;

class Myrandom extends Thread{
	double x,y;
	public void run() {
		for(int i=0;i<a.m/a.t;i++){
			x=Math.random();
			y=Math.random();
			if(x*x+y*y<1)
				a.n++;
		}	
	}	
}

public class a {

	static int n,t;
	static long m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x,y;
		Scanner input = new Scanner(System.in);
		System.out.println("输入模拟个数：");
		m = input.nextLong();
		System.out.println("输入线程数：");
		t=input.nextInt();		
		long l1=System.currentTimeMillis();
		for(int i=0;i<t;i++){
			new Myrandom().run();
		}
		long l2=System.currentTimeMillis();
		long time=l2-l1;
		System.out.println("并行所用时间"+time+"毫秒");
		System.out.println("圆周率："+n*1.0/m*4);
		n=0;
		l1=System.currentTimeMillis();
		for(int i=0;i<m;i++){
			x=Math.random();
			y=Math.random();
			if(x*x+y*y<1)
				n++;
		}
		l2=System.currentTimeMillis();
		time=l2-l1;
		System.out.println("串行所用时间"+time+"毫秒");
		System.out.println("圆周率："+n*1.0/m*4);
		
	}

}
