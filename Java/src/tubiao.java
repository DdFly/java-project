import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class tubiao extends JFrame{
	private ImageIcon aaa = new ImageIcon("/Java/66ccbe631f3b0ce2-06138918aa1f7763-de2fadb030f53e1c91b7e7ca6b6760a7.jpg");
	public tubiao(){
		setLayout(new GridLayout(1,4,5,5));
		add(new JButton(aaa));
		add(new JLabel(aaa));
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		tubiao aa = new tubiao();
		aa.setSize(200,200);
		aa.setVisible(true);
	}

}
