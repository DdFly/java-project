package 工厂方法模式;

public class ConcreteFactory extends AbstractFactory {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractProduct> T createProduct(Class<T> c) {
		// TODO 自动生成的方法存根
		AbstractProduct product = null;
		try {
			product = (AbstractProduct) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return (T) product;
	}
}
