package test;
import java.awt.*;
import javax.swing.*;

class Myframe extends JFrame{
	public Myframe(){
		setTitle("chuangti");
		setSize(400,220);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout());
		setResizable(false);
		
	}
}
public class gundong {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Myframe frame = new Myframe();
		JPanel p = new JPanel();
		//p.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()));
		p.setLayout(new GridLayout(1,8));
		ImageIcon icon = new ImageIcon("photo/1.jpg");
		JButton jb1 = new JButton(icon);
		jb1.setIcon(icon);
		JButton jb2 = new JButton(icon);
		JButton jb3 = new JButton(icon);
		JButton jb4 = new JButton(icon);
		JButton jb5 = new JButton(icon);
		JButton jb6 = new JButton(icon);
		JButton jb7 = new JButton(icon);
		JButton jb8 = new JButton(icon);
		p.add(jb1);p.add(jb2);p.add(jb3);p.add(jb4);
		p.add(jb5);p.add(jb6);p.add(jb7);p.add(jb8);
		JScrollPane js = new JScrollPane(p);
		//js.setBounds(0,0, 1080, 500);
		frame.add(js);
		JPanel p2 = new JPanel();
		JTextArea jt = new JTextArea("asjfpaoefjiaWJIFIEOAPAJ[IWOFJAE[OR["); 
		p2.add(jt);
		frame.add(p2,BorderLayout.SOUTH);
		frame.setVisible(true);
	}

}
