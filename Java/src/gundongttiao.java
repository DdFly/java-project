import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Scrollbar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class gundongttiao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gundongttiao frame = new gundongttiao();
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
	public gundongttiao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\5.jpg"));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\5.jpg"));
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\4.jpg"));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\4.jpg"));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\6.jpg"));
		panel.add(button_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\\u4EE3\u680B\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939 (2)\\5.jpg"));
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		contentPane.add(scrollPane);
	}

}
