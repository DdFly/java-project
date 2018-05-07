package 工厂方法模式;

public abstract class AbstractFactory {
	public abstract <T extends AbstractProduct> T createProduct(Class<T> c);
}
