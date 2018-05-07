package 单例模式;

/**
 * 内部类模型 线程安全 解决了类加载问题
 * 
 * @author 代栋
 *
 */
public class Neibulei {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Singleton3.getSingleton();
	}

}

class Singleton3 {
	private static class singleClass {
		private static Singleton3 singleton = new Singleton3();
	}

	private Singleton3() {
	};

	public static Singleton3 getSingleton() {
		return singleClass.singleton;
	}

	public void doSomething() {

	}
}
