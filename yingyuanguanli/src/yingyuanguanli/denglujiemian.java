package yingyuanguanli;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;

import java.awt.FlowLayout;
import java.awt.Scrollbar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JEditorPane;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import java.awt.Component;
import java.awt.Dimension;
public class denglujiemian extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					denglujiemian frame = new denglujiemian();
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
	public denglujiemian() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\1.jpg"));
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 600, 500);
		contentPane = new JPanel();
		//JScrollBar JSC = new JScrollBar();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u67D0\u67D0\u67D0\u7535\u5F71\u9662");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("�����п�", Font.PLAIN, 30));
		label.setForeground(Color.GREEN);
		contentPane.add(label, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		JScrollPane js = new JScrollPane(panel_1);
		//js.setPreferredSize(new Dimension(200, 100));
		js.setAlignmentX(Component.RIGHT_ALIGNMENT);
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panel.add(js, BorderLayout.NORTH);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setToolTipText("\u8FD9\u662F\u4E00\u4E2A\u5F88\u597D\u770B\u7684\u7535\u5F71");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\5.jpg"));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton_2.setToolTipText("\u8FD9\u4E5F\u662F");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\2.jpg"));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\6.jpg"));
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("\u6700\u65B0\u7535\u5F71");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		js.setColumnHeaderView(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u767B\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(3, 1, 0, 5));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");
		panel_3.add(label_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		panel_4.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel_4.add(passwordField);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton button_1 = new JButton("\u767B\u5F55");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((textField.getText().equals("10086"))&&(passwordField.getText().equals("123456"))){
					JOptionPane.showMessageDialog(panel,"��ӭʹ�ã�", "�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(panel, "������������µ�¼��","����", JOptionPane.INFORMATION_MESSAGE);
				}
					
			}
		});
		panel_5.add(button_1);
		
		JButton button = new JButton("\u53D6\u6D88");
		panel_5.add(button);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6700\u65B0\u5F71\u8BAF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		panel.add(panel_6, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setAutoscrolls(true);
		panel.add(panel_7, BorderLayout.EAST);

		//java.util.Date data=new java.util.Date();
		
		panel_7.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u65F6\u95F4\uFF1A");
		label_3.setFont(new Font("����", Font.BOLD, 25));
		panel_7.add(label_3);
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		panel_7.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("\u661F\u671F\u56DB");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		panel_7.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));
		class SysTime extends Thread{ 
		 	public void run(){
		 		try { while(true){ 
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
					lblNewLabel_1.setText(sdf1.format(new Date()));
					lblNewLabel_3.setText(sdf2.format(new Date()));
		 			sleep(1000); } 
				} catch (Exception ex) { ex.printStackTrace(); }
			 } 
		}
		new SysTime().start();
		panel_7.add(lblNewLabel_3);
		panel_7.updateUI();
		
		JPanel panel_8 = new JPanel();
		panel_8.setToolTipText("");
		panel_8.setBorder(new TitledBorder(null, "\u5F71\u9662\u4ECB\u7ECD", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GREEN));
		contentPane.add(panel_8, BorderLayout.SOUTH);

		}
	

}