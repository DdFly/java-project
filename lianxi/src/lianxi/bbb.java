package lianxi;
import java.awt.*;
import javax.swing.*;

class MFrame extends JFrame{
	public MFrame(){
		setSize(300,300);
		setTitle("�������");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
		
	}
}
class Bjpanel extends JPanel{
	Image im; 
	public Bjpanel() { 
		im=Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\1.jpg");//��Ҫע�������������·������ͼƬ,��ͼƬ�ļ�����������ļ������ļ��л���Ŀ�ĸ��ļ�����,��������þ���·���� 
	} 
	public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
		int imWidth=im.getWidth(this); 
		int imHeight=im.getHeight(this); //����ͼƬ�Ŀ�ȡ��߶� 
		int FWidth=getWidth(); 
		int FHeight=getHeight();//���崰�ڵĿ�ȡ��߶� 
		int x=(FWidth-imWidth)/2; 
		int y=(FHeight-imHeight)/2;//����ͼƬ������,ʹͼƬ��ʾ�ڴ������м� 
		g.drawImage(im,x,y,null);//����ͼƬ 
	} 
}
public class bbb {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MFrame frame = new MFrame();
		Bjpanel pan = new Bjpanel();
		JButton button = new JButton("��������");
		pan.add(button,BorderLayout.CENTER);
		frame.add(pan);
		frame.setVisible(true);
	}

}
