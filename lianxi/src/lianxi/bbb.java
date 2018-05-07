package lianxi;
import java.awt.*;
import javax.swing.*;

class MFrame extends JFrame{
	public MFrame(){
		setSize(300,300);
		setTitle("背景面板");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
		
	}
}
class Bjpanel extends JPanel{
	Image im; 
	public Bjpanel() { 
		im=Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\1.jpg");//需要注意的是如果用相对路径载入图片,则图片文件必须放在类文件所在文件夹或项目的根文件夹中,否则必须用绝对路径。 
	} 
	public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
		int imWidth=im.getWidth(this); 
		int imHeight=im.getHeight(this); //定义图片的宽度、高度 
		int FWidth=getWidth(); 
		int FHeight=getHeight();//定义窗口的宽度、高度 
		int x=(FWidth-imWidth)/2; 
		int y=(FHeight-imHeight)/2;//计算图片的坐标,使图片显示在窗口正中间 
		g.drawImage(im,x,y,null);//绘制图片 
	} 
}
public class bbb {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MFrame frame = new MFrame();
		Bjpanel pan = new Bjpanel();
		JButton button = new JButton("哈哈哈！");
		pan.add(button,BorderLayout.CENTER);
		frame.add(pan);
		frame.setVisible(true);
	}

}
