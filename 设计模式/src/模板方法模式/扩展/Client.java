package 模板方法模式.扩展;
/**
 * 带钩子方法的模板
 * 由子类决定父类的运行结果
 * @author 代栋
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ConcreteModel model = new ConcreteModel();
		model.setFlag(true);
		model.templateMethod();
	}

}
abstract class AbstractModel{
	protected abstract void Method();
	public void templateMethod(){
		if(GMethod())
			System.out.println("钩子方法返回True");
		else
			System.out.println("钩子方法返回False");
		Method();
	}
	protected boolean GMethod(){
		return true;
	}
}
class ConcreteModel extends AbstractModel{
	boolean flag = false;
	@Override
	protected boolean GMethod() {
		// TODO 自动生成的方法存根
		
		return flag;
	}
	@Override
	protected void Method() {
		// TODO 自动生成的方法存根
		System.out.println("样品产生");
	}
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	
}
