import java.awt.*;
import javax.swing.*;

class MyPanel extends JPanel{
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image icon = new ImageIcon("icon/background1.jpg").getImage();
		g.drawImage(icon, 0, 0, null);
	}
}
public class beijing extends JFrame{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame frame = new JFrame();
		frame.setSize(1024, 768);
		MyPanel panel1 = new MyPanel();
		//panel1.setSize(500,400);
		JPanel panel2 = new JPanel();
		panel2.setSize(500, 400);
		panel2.setLayout(new GridLayout(3, 3));
		panel2.add(new JButton("hahaha"));
		panel2.add(new JButton("hahaha"));
		panel2.add(new JButton("hahaha"));
		panel2.add(new JButton("hahaha"));
		panel2.add(new JButton("hahaha"));
		panel2.add(new JButton("hahaha"));
		panel2.add(new JButton("hahaha"));
		panel2.setOpaque(false);
		panel1.add(panel2);
		frame.add(panel1);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
