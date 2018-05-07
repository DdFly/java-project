package lianxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Myframe1 extends JFrame{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Myframe1 frame = new Myframe1();
		Myframe frame2 = new Myframe();
		frame2.setAlwaysOnTop(true);
		frame2.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(300,200);
		JButton button = new JButton("点我");
		frame.add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				frame2.setVisible(true);
			}
			
		});
		frame.setVisible(true);
	}

}
