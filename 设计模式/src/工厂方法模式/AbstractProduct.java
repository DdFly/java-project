package 工厂方法模式;

public abstract class AbstractProduct {
	// 产品类的公共方法
	public void method1() {
		System.out.println("这是公共方法！");
	}

	// 抽象方法
	public abstract void method2();
}
