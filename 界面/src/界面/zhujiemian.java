package 界面;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.*;

class Mysite extends JButton{
	static int num=0;
	int t=0;
	public Mysite(){
		setBorderPainted(false);
		setContentAreaFilled(false);		
	}
}

class MyPanel extends JPanel{
	public MyPanel(){
		this.setPreferredSize(new Dimension(600,500));
		this.setLayout(null);
		JPanel P1 = new JPanel();
		P1.setLayout(null);
		P1.setBounds(10, 50, 20, 300);
		for (int i=1;i<=10;i++){
			JLabel label = new JLabel(i+"");
			label.setBounds(0,i*25,20,20);
			P1.add(label);
		}
		Icon ic1 = new ImageIcon("photo/sit1.png");
		Icon ic2 = new ImageIcon("photo/sit2.png");
		Icon ic3 = new ImageIcon("photo/sit3.png");
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(30,50,550,300);
		
		for (int i = 1;i<=16;i++){
			for (int j = 1;j<=10;j++){
				Mysite bt = new Mysite();
				bt.setToolTipText(j+"排"+i+"座");
				bt.setIcon(ic1);
				bt.setBounds(i*30,j*25, 30, 20);				
				p2.add(bt);
				bt.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						if (bt.t==0&&bt.num<6){
							bt.setIcon(ic3);
							bt.t=1;
							bt.num++;
							System.out.println();
						}
						else if(bt.num==6&&bt.t==0){
							System.out.println("满了");
						}
						else if(bt.t==1){
							bt.setIcon(ic1);
							bt.t=0;
							bt.num--;
						}
						
					}
					
				});
			}	
		}

		p3.setLayout(null);
		p3.setBounds(30,350, 550, 50);
		JLabel bt1 = new JLabel();bt1.setBounds(100,0,30,20);bt1.setIcon(new ImageIcon("photo/sit1.png"));
		JLabel bt2 = new JLabel();bt2.setBounds(200,0,30,20);bt2.setIcon(new ImageIcon("photo/sit2.png"));
		JLabel bt3 = new JLabel();bt3.setBounds(300,0,30,20);bt3.setIcon(new ImageIcon("photo/sit3.png"));
		JLabel lb1 = new JLabel("可选");lb1.setBounds(100,20,40,20);
		JLabel lb2 = new JLabel("不可选");lb2.setBounds(195,20,40,20);
		JLabel lb3 = new JLabel("已选");lb3.setBounds(300,20,40,20);
		p3.add(bt1);p3.add(lb1);
		p3.add(bt2);p3.add(lb2);
		p3.add(bt3);p3.add(lb3);
		P1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		this.add(P1);
		this.add(p2);
		this.add(p3);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//Image img = new ImageIcon("photo/7.jpg").getImage();
		//g.drawImage(img, 0, 0, null);
		g.drawRoundRect(120, 15, 360, 30, 10, 10);
		//g.drawLine(275, 60, 275, 450);
		g.drawString("某某电影院   2号厅", 260,30);

	}
}
class MyFrame extends JFrame{
	public MyFrame(){
		setTitle("***电影院");
		setSize(800,550);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u4EE3\u680B\\Pictures\\66ccbe631f3b0ce2-06138918aa1f7763-de2fadb030f53e1c91b7e7ca6b6760a7.jpg"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}

//根面板
class panel_1{
	public panel_1(JPanel p1){
		p1.setLayout(new BorderLayout());
		JLabel zhuti = new JLabel("某某某电影院");
		zhuti.setFont(new Font("华文行楷", Font.PLAIN, 30));
		zhuti.setHorizontalAlignment(SwingConstants.CENTER);
		zhuti.setForeground(Color.GREEN);
		p1.add(zhuti, BorderLayout.NORTH);
		JPanel p2 = new JPanel();
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1,10,5,0));
		ImageIcon icon = new ImageIcon("C:\\Users\\代栋\\Desktop\\新建文件夹 (2)\\3.jpg");
		JLabel l1 = new JLabel(icon);
		JLabel l2 = new JLabel(icon);
		JLabel l3 = new JLabel(icon);
		JLabel l4 = new JLabel(icon);
		JLabel l5 = new JLabel(icon);
		JLabel l6 = new JLabel(icon);
		JLabel l7 = new JLabel(icon);
		JLabel l8 = new JLabel(icon);
		p4.add(l1);
		p4.add(l2);
		p4.add(l3);
		p4.add(l4);
		p4.add(l5);
		p4.add(l6);
		p4.add(l7);
		p4.add(l8);
		p4.add(l8);
		p4.add(l8);
		p4.add(l8);
		p4.add(l8);
		JScrollPane js = new JScrollPane(p4);
		js.setPreferredSize(new Dimension(800, 130));
		js.setBorder(new TitledBorder(null,"最新电影", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GREEN));
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		p2.add(js);
		JPanel p5 = new JPanel();
		//p5.setPreferredSize(new Dimension(180,200));
		p5.setBorder(new TitledBorder(null, "登录", TitledBorder.LEFT, TitledBorder.TOP, null));
		p5.setLayout(new GridLayout(4,1,5,5));
		JButton denglu = new JButton("登录");
		JButton quxiao = new JButton("取消");
		JRadioButton r1 = new JRadioButton("用户",true);
		JRadioButton r2 = new JRadioButton("管理员");
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);bg.add(r2);
		denglu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (true){
					zhujiemian.stack.push(zhujiemian.pp1);
					MyPanel mp = new MyPanel();
					zhujiemian.pp1.setVisible(false);
					zhujiemian.frame.remove(zhujiemian.pp1);
					zhujiemian.frame.add(mp);
					
					
				}
				
			}
		});
		JLabel zh = new JLabel("账号：");
		JLabel mm = new JLabel("密码：");
		JTextField ZH = new JTextField(8);
		JPasswordField MM = new JPasswordField(8);
		JPanel p5_1 = new JPanel();
		JPanel p5_2 = new JPanel();
		JPanel p5_3 = new JPanel();
		JPanel p5_4 = new JPanel();
		p5_1.add(zh);p5_1.add(ZH);
		p5_2.add(mm);p5_2.add(MM);
		p5_3.add(r1);p5_3.add(r2);
		p5_4.add(denglu);p5_4.add(quxiao);
		p5.add(p5_1);p5.add(p5_2);p5.add(p5_3);p5.add(p5_4);
		p2.add(p5, BorderLayout.WEST);
		JPanel p6 = new JPanel();
		//p6.setSize(500,400);
		p6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "最新影讯", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		p6.setPreferredSize(new Dimension(400,200));
		p2.add(p6,BorderLayout.CENTER);
		JPanel p7 = new JPanel();
		p7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "当前时间", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		p7.setLayout(new GridLayout(4,1,5,5));
		p7.setPreferredSize(new Dimension(200,200));
		//JLabel jt = new JLabel("当前时间：");
		//p7.add(jt);
		//jt.setFont(new Font("宋体", Font.BOLD, 25));
		p2.add(p7,BorderLayout.EAST);
		p1.add(p2, BorderLayout.CENTER);
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(800,120));
		p3.setBorder(new TitledBorder(null, "影院介绍", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GREEN));
		p1.add(p3, BorderLayout.SOUTH);
	}
	
}

public class zhujiemian {
	static MyFrame frame = new MyFrame();
	static Stack stack = new Stack();
	static JPanel pp1 = new JPanel();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage("photo/sit1.png"));
		
		panel_1 p = new panel_1(pp1);
		frame.add(pp1);
		//frame.setLayout(null);
		frame.setVisible(true);
	}
}
