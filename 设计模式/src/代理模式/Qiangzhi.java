package 代理模式;

/**
 * 强制代理 客户端必须从实际对象获取代理对象 不能直接访问代理,也不能直接访问实际对象
 * 
 * @author 代栋
 *
 */

public class Qiangzhi {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ISubject2 subject = new RealSubject3();
		ISubject2 proxy = subject.getProxy();
		// ISubject2 proxy2 = new Proxy3(subject);
		proxy.request();
		// proxy2.request();
		// subject.request();
	}

}

class Proxy3 implements ISubject2 {

	private ISubject2 subject = null;

	public Proxy3(ISubject2 subject) {
		this.subject = subject;
	}

	@Override
	public void request() {
		// TODO 自动生成的方法存根
		subject.request();
	}

	@Override
	public ISubject2 getProxy() {
		// TODO 自动生成的方法存根
		return this;
	}

}

class RealSubject3 implements ISubject2 {

	private ISubject2 proxy = null;

	@Override
	public void request() {
		// TODO 自动生成的方法存根
		if (proxy == null)
			System.out.println("请使用指定代理");
		else
			System.out.println("哈哈哈");
	}

	@Override
	public ISubject2 getProxy() {
		// TODO 自动生成的方法存根
		proxy = new Proxy3(this);
		return proxy;
	}

}
