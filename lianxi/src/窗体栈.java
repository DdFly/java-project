
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class 窗体栈 extends JFrame {
	public 窗体栈() {
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Stack stack = new Stack();
		MyFrame frame = new MyFrame();
		frame.getContentPane().setLayout(new GridLayout(3,4));
		JPanel panel_1 = new JPanel();
		JButton bt =  new JButton("aaa");
		panel_1.add(bt);
		stack.push(panel_1);
		JPanel panel_2 = new JPanel();
		JButton bt2 = new JButton("bbb");
		panel_2.add(bt2);
		stack.push(panel_2);
		JPanel p;
		p=(JPanel) stack.pop();
		frame.getContentPane().add(p);
		
		bt2.addActionListener(new ActionListener()  {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (e.getSource()==bt2){
					System.out.println("aopjfoaijruaejioriephfi");
				p.setVisible(false);
				frame.getContentPane().remove(p);
				JPanel p1=(JPanel) stack.pop();
				frame.getContentPane().add(p1);
				p1.setVisible(true);
				}
				
			}
		});
		p.setVisible(true);
		frame.setVisible(true);
		
	}

}
class MyFrame extends JFrame{
	public MyFrame(){
		this.setTitle("我的界面");
		this.setSize(200, 200);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
	}
}
