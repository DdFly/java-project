package yingyuanguanli;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class yonghujiemian extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yonghujiemian frame = new yonghujiemian();
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
	public yonghujiemian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u83DC\u5355");
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u6211\u7684\u8D26\u53F7");
		menu.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539\u8D44\u6599");
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5145\u503C");
		menu_2.add(menuItem_3);
		
		JMenu menu_3 = new JMenu("\u7535\u5F71\u67E5\u8BE2");
		menu.add(menu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u6309\u540D\u79F0\u67E5\u8BE2");
		menu_3.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u6309\u653E\u6620\u65F6\u95F4\u67E5\u8BE2");
		menu_3.add(menuItem_5);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u7968");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_6 = new JMenuItem("\u7528\u6237\u624B\u518C");
		menu_1.add(menuItem_6);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
	}
}
