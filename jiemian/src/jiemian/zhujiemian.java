package jiemian;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

public class zhujiemian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zhujiemian frame = new zhujiemian();
					frame.setSize(800, 449);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	class Bjpanel extends JPanel{
		Image im; 
		public Bjpanel() { 
			im=Toolkit.getDefaultToolkit().getImage("1433123805856.jpg"); 
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
	public zhujiemian(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 1, 0, 0));
		
		Bjpanel panel = new Bjpanel();
		contentPane.add(panel);
	}

}
