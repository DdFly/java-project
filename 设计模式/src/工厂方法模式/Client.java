package 工厂方法模式;

public class Client {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		AbstractFactory factory = new ConcreteFactory();
		AbstractProduct product = factory.createProduct(ConcreteProtect.class);
		product.method1();
		product.method2();
	}

}
