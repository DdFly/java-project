package 代理模式;

/**
 * 代理模式的标准范例 客户端同时访问代理对象和实际对象
 * 
 * @author 代栋
 *
 */
public class SimpleProxy {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ISubject subject = new RealSubject();
		ISubject proxy = new Proxy(subject);
		proxy.request();

	}

}

class Proxy implements ISubject {

	private ISubject subject = null;

	public Proxy() {
		// TODO 自动生成的构造函数存根
	}

	public Proxy(ISubject subject) {
		this.subject = subject;
	}

	@Override
	public void request() {
		// TODO 自动生成的方法存根
		subject.request();
	}

}

class RealSubject implements ISubject {

	@Override
	public void request() {
		// TODO 自动生成的方法存根

	}

}
