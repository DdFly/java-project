package com.example.ui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ������Ϣ
 *
 */
public class Personal_information extends JPanel{
	private static final long serialVersionUID=1L;
	Image background = new ImageIcon("icon/background_pi.jpg").getImage();
	JPanel panel1 = new Paintpanel(background);
	JPanel panel2 = new JPanel();
	JLabel user_account = new JLabel("�û�����");
	JLabel user_name = new JLabel("������");
	JLabel user_idnum = new JLabel("���֤��");
	JLabel user_sex = new JLabel("�Ա�");
	JLabel user_company = new JLabel("��˾��");
	JLabel user_tel = new JLabel("�绰��");
	JLabel user_drilicense = new JLabel("��ʻ֤��");
	JLabel user_address = new JLabel("��ַ��");
	JButton complete = new JButton("������Ϣ");
	
	public Personal_information(){
		this.setLayout(null);
		panel1.setLayout(null);
		panel2.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel1.setBounds(0, 0, 1280, 640);
		panel2.setBounds(280, 0, 720, 640);
		user_account.setBounds(50, 20, 100, 40);
		user_account.setFont(new Font("����", Font.PLAIN, 20));
		user_name.setBounds(380, 20, 100, 40);
		user_name.setFont(new Font("����", Font.PLAIN, 20));
		complete.setBounds(320, 560, 100, 40);
		user_idnum.setBounds(50, 100, 100, 40);
		user_idnum.setFont(new Font("����", Font.PLAIN, 20));
		user_sex.setBounds(380, 100, 100, 40);
		user_sex.setFont(new Font("����", Font.PLAIN, 20));
		user_company.setBounds(50, 180, 100, 40);
		user_company.setFont(new Font("����", Font.PLAIN, 20));
		user_tel.setBounds(380, 180, 100, 40);
		user_tel.setFont(new Font("����", Font.PLAIN, 20));
		user_drilicense.setBounds(50, 260, 100, 40);
		user_drilicense.setFont(new Font("����", Font.PLAIN, 20));
		user_address.setBounds(380, 260, 100, 40);
		user_address.setFont(new Font("����", Font.PLAIN, 20));
		complete.setBounds(320, 560, 100, 40);
		panel2.add(user_account);
		panel2.add(user_name);
		panel2.add(user_idnum);
		panel2.add(user_sex);
		panel2.add(user_company);
		panel2.add(user_tel);
		panel2.add(user_drilicense);
		panel2.add(user_address);
		panel2.add(complete);
		panel1.add(panel2);
		this.add(panel1);
		
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(MainMenu.user);
			}
		});
		
	}
	
}
