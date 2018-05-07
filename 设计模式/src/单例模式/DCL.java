package routine;

public class DCL {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}

class Singleton {
	private volatile static Singleton singleton = null;

	private Singleton() {
	};

	public static Singleton getSingelton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
