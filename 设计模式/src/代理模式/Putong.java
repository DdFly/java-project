package 代理模式;

/**
 * 必须知道代理的存在 客户端只能访问代理对象，不能访问实际对象
 * 
 * @author 代栋
 *
 */

public class Putong {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ISubject proxy = new Proxy2();
		proxy.request();
	}
}

class Proxy2 implements ISubject {

	private ISubject subject = null;

	public Proxy2() {
		// TODO 自动生成的构造函数存根
		subject = new RealSubject2();
	}

	@Override
	public void request() {
		// TODO 自动生成的方法存根
		subject.request();
	}

}

class RealSubject2 implements ISubject {

	@Override
	public void request() {
		// TODO 自动生成的方法存根

	}

}
