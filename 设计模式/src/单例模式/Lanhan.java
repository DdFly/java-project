package 单例模式;

/**
 * 懒汉模式 线程安全 效率低，synchronized同步准备很耗时
 * 
 * @author 代栋
 *
 */
public class Lanhan {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Singleton2.getSingleton();
	}

}

class Singleton2 {
	private static Singleton2 singleton = null;

	private Singleton2() {
	};

	public static synchronized Singleton2 getSingleton() {
		if (singleton == null)
			singleton = new Singleton2();
		return singleton;
	}

	public void doSomething() {

	}

}
