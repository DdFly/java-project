package test;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.*;

class Mysite extends JButton{
	static int num=0;
	int t=0;
	public Mysite(){
		setBorderPainted(false);
		setContentAreaFilled(false);		
	}
}

class MyPanel extends JPanel{
	LinkedList select = new LinkedList();
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
							select.add(bt);
							bt.num++;
							//System.out.println();
						}
						else if(bt.num==6&&bt.t==0){
							JOptionPane.showMessageDialog(null, "一次最多只能选六个");
							
						}
						else if(bt.t==1){
							bt.setIcon(ic1);
							bt.t=0;
							/*for(int i=0;i<bt.num;i++){
								if (select[i]!=bt)
									i++;
								else{
									for(int j=i;j<bt.num;j++){
										select[j]=select[j+1];
									}
									bt.num--;
									break;
								}
							}*/
							select.remove(bt);
							bt.num--;
						}
						
					}
					
				});
			}	
		}

		p3.setLayout(null);
		p3.setBounds(30,350, 550, 50);
		JLabel bt1 = new JLabel();bt1.setBounds(100,0,30,20);bt1.setIcon(ic1);
		JLabel bt2 = new JLabel();bt2.setBounds(200,0,30,20);bt2.setIcon(ic2);
		JLabel bt3 = new JLabel();bt3.setBounds(300,0,30,20);bt3.setIcon(ic3);
		JLabel lb1 = new JLabel("可选");lb1.setBounds(100,20,40,20);
		JLabel lb2 = new JLabel("不可选");lb2.setBounds(195,20,40,20);
		JLabel lb3 = new JLabel("已选");lb3.setBounds(300,20,40,20);
		p3.add(bt1);p3.add(lb1);
		p3.add(bt2);p3.add(lb2);
		p3.add(bt3);p3.add(lb3);
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(4, 1));
		p4.add(new JLabel("这是电影名字"));
		p4.add(new JLabel("已选："));
		JPanel p4_1 = new JPanel();
		p4_1.setLayout(new GridLayout(3, 2));
		p4_1.setPreferredSize(new Dimension(200, 100));
		p4.add(p4_1);
		JButton tijiao = new JButton("提交");
		tijiao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				/*for(int i=0;i<Mysite.num;i++){
					select[i].setIcon(ic2);
				}*/
				Iterator<JButton> iter = select.iterator();
				while(iter.hasNext()){
					iter.next().setIcon(ic2);
				}
			}
		});
		p4.add(tijiao);
		p4.setBounds(600, 150, 150, 200);
		
		P1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		this.add(P1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
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

public class zuowei {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame frame = new JFrame();
		MyPanel panel = new MyPanel();
		frame.add(panel);
		frame.setSize(1024, 768);
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			
	}

}
