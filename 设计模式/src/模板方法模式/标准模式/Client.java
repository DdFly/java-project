package 模板方法模式.标准模式;

public class Client {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		AbstractModel model1 = new ConcreteModel1();
		AbstractModel model2 = new ConcreteModel2();
		model1.templateMethod();
		model2.templateMethod();
	}

}
abstract class AbstractModel{
	protected abstract void method1();
	public void templateMethod(){
		method1();
	}
}
class ConcreteModel1 extends AbstractModel{

	@Override
	protected void method1() {
		// TODO 自动生成的方法存根
		System.out.println("第一个样品");
	}	
}
class ConcreteModel2 extends AbstractModel{

	@Override
	protected void method1() {
		// TODO 自动生成的方法存根
		System.out.println("第二个样品");
	}	
}