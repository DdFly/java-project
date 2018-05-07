package 单例模式;

/**
 * 饿汉模式 线程安全 缺点：导致类装载的原因不一定是getSingleton（），也有其他原因，此时实例化Singleton不能达到lazy
 * loading效果
 * 
 * @author 代栋
 *
 */
public class Ehan {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Singleton.getSingleton();
	}

}

class Singleton {
	private static final Singleton singleton = new Singleton();

	private Singleton() {
	};

	public static Singleton getSingleton() {
		return singleton;
	}

	public void doSomething() {

	}
}
