package lianxi;
import java.awt.*;
import javax.swing.*;

class Myframe extends JFrame{
	public Myframe(){
		setLocale(null);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class Mypanel extends JPanel{
	public Mypanel(){
		
	}
	public void paintComponent(Graphics g){
		Image img = new ImageIcon("photo/1.jpg").getImage();
		g.drawImage(img, 500, 400, null);
	}
}
public class beijing {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Myframe frame = new Myframe();
		Mypanel panel = new Mypanel();
		frame.add(panel);
		frame.setVisible(true);
	}

}
