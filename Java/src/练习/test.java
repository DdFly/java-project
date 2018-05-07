package 练习;

class Fan{
	final int SLOW =1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Fan(){
		
	}
	public String toString(){
		if(on){
			return "速度："+speed+"，\t颜色："+color+"，\t半径："+radius;
		}
		else
			return "fan is off"+"，\t颜色："+color+"，\t半径："+radius;
	}
}
public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		f1.setSpeed(3);
		f1.setRadius(10);
		f1.setColor("yellow");
		f1.setOn(true);
		f2.setSpeed(2);
		f2.setRadius(5);
		//f2.setColor("yellow");
		f2.setOn(false);
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
	}

}
