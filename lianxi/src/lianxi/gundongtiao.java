package lianxi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Scrollbar;
import java.awt.ScrollPane;

public class gundongtiao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gundongtiao frame = new gundongtiao();
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
	public gundongtiao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane JS = new JScrollPane(getContentPane());
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("aoejfi");
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		JList list = new JList();
		list.setVisibleRowCount(5);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"apple", "banana", "cat", "car", "pig", "con", "monkey", "dog"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);
		
		//ScrollPane scrollPane = new ScrollPane();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"qwe", "wertr", "wert", "retrytu", "wesd", "retry"}));
		comboBox.setToolTipText("");
		panel.add(comboBox);
	}

}
