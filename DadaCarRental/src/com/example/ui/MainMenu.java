package com.example.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainMenu {
	public static MainMenu m;
	public static Login l;
	public static Register r;
	public static String user;
	public static Boolean loginStatus = false;
	JFrame frame = new JFrame();
	Image background = new ImageIcon("icon/title_background.PNG").getImage();
	Image background_ex= new ImageIcon("icon/exhibition.jpg").getImage();
	Image background_crr= new ImageIcon("icon/car_Rental_Record1.png").getImage();
	Image background_pi= new ImageIcon("icon/personal_information.jpg").getImage();
	JPanel title = new Paintpanel(background);
	JPanel user1 = new JPanel();
	JPanel user2 = new JPanel();
	JPanel menu = new JPanel();
	Exhibition ex = new Exhibition();
	Car_Rental_Record crr = new Car_Rental_Record();
	Personal_information pi = new Personal_information();
	JPanel exhibition = new Paintpanel(background_ex);
	JPanel car_Rental_Record = new Paintpanel(background_crr);
	JPanel personal_information = new Paintpanel(background_pi);
	JPanel relet = new JPanel();
	JPanel enterprise_Car_Rental = new JPanel();
	JPanel special_Car = new JPanel();
	JPanel leaseCar = new JPanel();
	JPanel rent = new JPanel();
	ImageIcon status1 = new ImageIcon("icon/login_status1.PNG");
	ImageIcon status2 = new ImageIcon("icon/login_status2.PNG");
	ImageIcon backIcon = new ImageIcon("icon/back.png");
	JLabel login_status1 = new JLabel(status1);
	JLabel login_status2 = new JLabel(status2);
	JLabel user_name = new JLabel("");
	JButton login = new JButton("µÇÂ¼");
	JButton register =new JButton("×¢²á"); 
	JButton logoff = new JButton("×¢Ïú");
	JButton back = new JButton(backIcon);
	
	public static void main(String[] args) {
		m = new MainMenu();
		l = new Login();
		r = new Register();
		new LoginEvent();
		new RegisterEvent();
		l.dispose();
		r.dispose();
	}
	
	public MainMenu() {
		
		frame.setLayout(null);
		frame.setResizable(false);
		title.setLayout(null);
		menu.setLayout(null);
		user1.setBackground(Color.CYAN);
		user2.setBackground(Color.CYAN);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		exhibition.setBackground(Color.BLACK);
		car_Rental_Record.setBackground(Color.PINK);
		personal_information.setBackground(Color.GRAY);
		relet.setBackground(Color.BLUE);
		enterprise_Car_Rental.setBackground(Color.YELLOW);
		special_Car.setBackground(Color.RED);
		leaseCar.setBackground(Color.GREEN);
		rent.setBackground(Color.ORANGE);
		user1.add(login_status1);
		user2.add(login_status2);
		user2.add(user_name);
		user1.add(login);
		user1.add(register);
		user2.add(logoff);
		title.add(user1);
		title.add(user2);
		menu.add(exhibition);
		menu.add(car_Rental_Record);
		menu.add(personal_information);
		menu.add(relet);
		menu.add(enterprise_Car_Rental);
		menu.add(special_Car);
		menu.add(leaseCar);
		menu.add(rent);
		frame.add(title);
		frame.add(menu);
		user1.setBounds(1000,0,280,80);
		user2.setBounds(1000,0,280,80);
		title.setBounds(0,0,1280,80);
		menu.setBounds(0, 80, 1280, 640);
		exhibition.setBounds(0, 0, 320, 640);
		car_Rental_Record.setBounds(320, 0, 340, 213);
		personal_information.setBounds(660, 0, 340, 213 );
		relet.setBounds(1000, 0, 280, 213);
		enterprise_Car_Rental.setBounds(320, 213, 480, 213);
		special_Car.setBounds(800, 213, 480, 213);
		leaseCar.setBounds(320, 426, 680, 213);
		rent.setBounds(1000, 426, 280 , 213);
		frame.setSize(1280, 720);
		frame.setVisible(true);
		user1.setVisible(true);
		user2.setVisible(false);
		
		exhibition.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				menu.setVisible(false);
				ex.setVisible(true);
				ex.panel.add(back);
				ex.changePanel();
				back.setBounds(1200, 560, 80, 60);
				frame.add(ex);
				back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						menu.setVisible(true);
						frame.remove(ex);
					}
				});
			}
		});
		
		car_Rental_Record.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					menu.setVisible(false);
					crr.setVisible(true);
					
					back.setBounds(1200, 560, 80, 60);
					crr.panel.add(back);
					
					
					frame.add(crr);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(crr);
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "ÇëÏÈ½øÐÐµÇÂ¼»ò×¢²á");
			}
		});
		
		personal_information.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					menu.setVisible(false);
					pi.setVisible(true);
					pi.panel1.add(back);
					back.setBounds(1200, 560, 80, 60);
					frame.add(pi);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(pi);
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "ÇëÏÈ½øÐÐµÇÂ¼»ò×¢²á");
			
				}
			});
		

		
		relet.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					
				}
			}
		});
		
		enterprise_Car_Rental.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					
				}
			}
		});
		
		special_Car.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					
				}
			}
		});
	}
	
	public void setUser1() {
		user1.setVisible(true);
		user2.setVisible(false);
	}
	
	public void setUser2() {
		user1.setVisible(false);
		user2.setVisible(true);
	}
	
	public void setUserName(String username) {
		user_name.setText(username+"   ");
		user_name.setForeground(Color.RED);
		user_name.setFont(new Font("ËÎÌå", Font.PLAIN, 30)); 
	}
	
	public JButton getLogin() {
		return login;
	}
	public JButton getRegister() {
		return register;
	}
	public JButton getLogoff() {
		return logoff;
	}
}

class Paintpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image = null;
	public Paintpanel(Image image) {
		this.image = image;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null, this);
	}
}

