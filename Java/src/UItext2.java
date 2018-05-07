
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
public class UItext2 {
	public static void main(String[] args) {
		new Menu();	
	}
}
class Paintpanel extends JPanel {
	private Image image = null;
	public Paintpanel(Image image) {
		this.image = image;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null, this);
	}
}

class Administratorpanel extends JPanel {
	Image moviePoster1 = new ImageIcon("icon/movie1.jpg").getImage();
	Image moviePoster2 = new ImageIcon("icon/movie2.jpg").getImage();
	Image moviePoster3 = new ImageIcon("icon/movie3.jpg").getImage();
	Image moviePoster4 = new ImageIcon("icon/movie4.jpg").getImage();
	Image moviePoster5 = new ImageIcon("icon/movie5.jpg").getImage();
	Image moviePoster6 = new ImageIcon("icon/movie6.jpg").getImage();
	Image moviePoster7 = new ImageIcon("icon/movie7.jpg").getImage();
	Image bottomBackground = new ImageIcon("icon/bottom.gif").getImage();
	ImageIcon preIcon = new ImageIcon("icon/pre.png");
	ImageIcon nextIcon = new ImageIcon("icon/next.png");
	ImageIcon filmIcon = new ImageIcon("icon/film.png");
	ImageIcon hallIcon = new ImageIcon("icon/hall.png");
	ImageIcon addIcon = new ImageIcon("icon/add.png");
	ImageIcon deleteIcon = new ImageIcon("icon/delete.png");
	ImageIcon modifyIcon = new ImageIcon("icon/modify.png");
	ImageIcon searchIcon = new ImageIcon("icon/search.png");
	JPanel cardPanel = new JPanel();
	CardLayout card = new CardLayout();
	JButton preButton = new JButton(preIcon);
	JButton nextButton = new JButton(nextIcon);
	JButton filmButton = new JButton(filmIcon);
	JButton hallButton = new JButton(hallIcon);
	JButton addButton = new JButton(addIcon);
	JButton deleteButton = new JButton(deleteIcon);
	JButton modifyButton = new JButton(modifyIcon);
	JButton searchButton = new JButton(searchIcon);
	JPanel movie1 = new Paintpanel(moviePoster1);
	JPanel movie2 = new Paintpanel(moviePoster2);
	JPanel movie3 = new Paintpanel(moviePoster3);
	JPanel movie4 = new Paintpanel(moviePoster4);
	JPanel movie5 = new Paintpanel(moviePoster5);
	JPanel movie6 = new Paintpanel(moviePoster6);
	JPanel movie7 = new Paintpanel(moviePoster7);
	JPanel bottomPanel = new Paintpanel(bottomBackground);
	
	public Administratorpanel() {
		this.setLayout(null);
		this.setVisible(false);
		cardPanel.setLayout(card);
		bottomPanel.setLayout(null);
		cardPanel.add(movie1);
		cardPanel.add(movie2);
		cardPanel.add(movie3);
		cardPanel.add(movie4);
		cardPanel.add(movie5);
		cardPanel.add(movie6);
		cardPanel.add(movie7);
		bottomPanel.add(addButton);
		bottomPanel.add(deleteButton);
		bottomPanel.add(modifyButton);
		bottomPanel.add(searchButton);
		this.add(cardPanel);
		this.add(bottomPanel);
		this.add(preButton);
		this.add(nextButton);
		this.add(filmButton);
		this.add(hallButton);
		cardPanel.setBounds(50, 0, 900, 600);
		bottomPanel.setBounds(0, 600, 1024, 168);;
		preButton.setBounds(10, 300, 20, 80);
		nextButton.setBounds(970, 300, 20, 80);
		filmButton.setBounds(0, 0, 50, 50);
		hallButton.setBounds(955, 0, 50, 50);
		addButton.setBounds(70, 20, 80, 80);
		deleteButton.setBounds(326, 20, 80, 80);
		modifyButton.setBounds(582, 20, 80, 80);
		searchButton.setBounds(838, 20, 80, 80);
		preButton.setBorderPainted(false);
		nextButton.setBorderPainted(false);
		filmButton.setBorderPainted(false);
		hallButton.setBorderPainted(false);
		addButton.setBorderPainted(false);
		deleteButton.setBorderPainted(false);
		modifyButton.setBorderPainted(false);
		searchButton.setBorderPainted(false);
		preButton.setContentAreaFilled(false);
		nextButton.setContentAreaFilled(false);
		filmButton.setContentAreaFilled(false);
		hallButton.setContentAreaFilled(false);
		addButton.setContentAreaFilled(false);
		deleteButton.setContentAreaFilled(false);
		modifyButton.setContentAreaFilled(false);
		searchButton.setContentAreaFilled(false);
		
		modifyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
			
		nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.next(cardPanel);
             }
         });
		
		preButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.previous(cardPanel);
             }
         });
		
		hallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Menu.filmhall.setVisible(true);
            	Menu.administrator.setVisible(false);
                Menu.frame.getContentPane().add(Menu.filmhall);
             }
         });
		searchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				Menu.search.setVisible(true);
				
			}
			
		});
		
	}
}

class searchDialog extends JDialog{
	JButton search = new JButton("查询");
	JLabel search_name = new JLabel("片名");
	JLabel search_time = new JLabel("放映时间");
	JTextField file_name = new JTextField();
	JTextField file_time = new JTextField();
	
	public searchDialog(){
		this.setBounds(300, 100, 400, 500);
		this.setModal(true);
		this.setLayout(null);
		search_name.setBounds(40, 50, 50, 30);
		file_name.setBounds(150, 50, 150, 30);
		search_time.setBounds(30, 130, 100, 30);
		file_time.setBounds(150, 130, 150, 30);
		search.setBounds(160, 300, 100, 30);
		this.add(search_name);
		this.add(file_name);
		this.add(search_time);
		this.add(file_time);
		this.add(search);
		
	}
}
class Filmhallpanel extends JPanel {
	Image filmhallIcon1 = new ImageIcon("icon/filmhall1.jpg").getImage();
	Image filmhallIcon2 = new ImageIcon("icon/filmhall2.jpg").getImage();
	Image bottomBackground = new ImageIcon("icon/banner.gif").getImage();
	ImageIcon preIcon = new ImageIcon("icon/pre.png");
	ImageIcon nextIcon = new ImageIcon("icon/next.png");
	ImageIcon filmIcon = new ImageIcon("icon/film.png");
	ImageIcon hallIcon = new ImageIcon("icon/hall.png");
	ImageIcon addIcon = new ImageIcon("icon/add.png");
	ImageIcon deleteIcon = new ImageIcon("icon/delete.png");
	JPanel cardPanel = new JPanel();
	CardLayout card = new CardLayout();
	JButton preButton = new JButton(preIcon);
	JButton nextButton = new JButton(nextIcon);
	JButton filmButton = new JButton(filmIcon);
	JButton hallButton = new JButton(hallIcon);
	JButton addButton = new JButton(addIcon);
	JButton deleteButton = new JButton(deleteIcon);
	JPanel filmhall1 = new Paintpanel(filmhallIcon1);
	JPanel filmhall2 = new Paintpanel(filmhallIcon2);
	JPanel bottomPanel = new Paintpanel(bottomBackground);
	
	public Filmhallpanel() {
		this.setLayout(null);
		this.setVisible(false);
		cardPanel.setLayout(card);
		bottomPanel.setLayout(null);
		cardPanel.add(filmhall1);
		cardPanel.add(filmhall2);
		bottomPanel.add(addButton);
		bottomPanel.add(deleteButton);
		this.add(cardPanel);
		this.add(bottomPanel);
		this.add(preButton);
		this.add(nextButton);
		this.add(filmButton);
		this.add(hallButton);
		cardPanel.setBounds(50, 0, 900, 600);
		bottomPanel.setBounds(0, 600, 1024, 168);;
		preButton.setBounds(10, 300, 20, 80);
		nextButton.setBounds(970, 300, 20, 80);
		filmButton.setBounds(0, 0, 50, 50);
		hallButton.setBounds(955, 0, 50, 50);
		addButton.setBounds(70, 20, 80, 80);
		deleteButton.setBounds(838, 20, 80, 80);
		preButton.setBorderPainted(false);
		nextButton.setBorderPainted(false);
		filmButton.setBorderPainted(false);
		hallButton.setBorderPainted(false);
		addButton.setBorderPainted(false);
		deleteButton.setBorderPainted(false);
		preButton.setContentAreaFilled(false);
		nextButton.setContentAreaFilled(false);
		filmButton.setContentAreaFilled(false);
		hallButton.setContentAreaFilled(false);
		addButton.setContentAreaFilled(false);
		deleteButton.setContentAreaFilled(false);
		
		nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.next(cardPanel);
             }
         });
		
		preButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.previous(cardPanel);
             }
         });
		
		filmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Menu.filmhall.setVisible(false);
               Menu.administrator.setVisible(true);
               Menu.frame.getContentPane().add(Menu.administrator);
             }
         });
	
	}
}

class Conductorpanel extends JPanel {
	JPanel title = new JPanel();
	JPanel panel = new JPanel();
	JScrollPane scroll = new JScrollPane();
	ImageIcon filmhall1 = new ImageIcon("icon/filmhall1.png");
	ImageIcon filmhall2 = new ImageIcon("icon/filmhall2.png");
	ImageIcon filmIcon1 = new ImageIcon("icon/movie11.jpg");
	ImageIcon filmIcon2 = new ImageIcon("icon/movie21.jpg");
	ImageIcon filmIcon3 = new ImageIcon("icon/movie31.jpg");
	ImageIcon filmIcon4 = new ImageIcon("icon/movie41.jpg");
	ImageIcon filmIcon5 = new ImageIcon("icon/movie51.jpg");
	ImageIcon filmIcon6 = new ImageIcon("icon/movie61.jpg");
	ImageIcon filmIcon7 = new ImageIcon("icon/movie71.jpg");
	ImageIcon fareIcon = new ImageIcon("icon/yuan.png");
	ImageIcon saleIcon = new ImageIcon("icon/sale.png");
	JLabel hall = new JLabel("影厅");
	JLabel film = new JLabel("影片");
	JLabel name = new JLabel("片名");
	JLabel date = new JLabel("场次");
	JLabel fare = new JLabel("票价");
	JButton[] buttonHall = new JButton[7];
	JButton[] buttonSale = new JButton[7];
	JLabel[] labelFilm = new JLabel[7];
	JLabel[] labelName = new JLabel[7];
	JLabel[] labelDate = new JLabel[7];
	JLabel[] labelFare = new JLabel[7];
	JLabel[] labelYuan = new JLabel[7];
		
	public Conductorpanel() {
		this.setLayout(null);
		this.setVisible(false);
		title.setLayout(null);
		panel.setLayout(null);
		title.setBounds(0, 0, 1024, 20);
		panel.setPreferredSize(new Dimension(1024,768));
		scroll.setBounds(0, 20, 1010, 720);
		title.setBackground(Color.RED);
		panel.setBackground(Color.PINK);
		title.add(hall);
		title.add(film);
		title.add(name);
		title.add(date);
		title.add(fare);
		hall.setBounds(40, 0, 40, 20);;
		film.setBounds(197, 0, 40, 20);
		name.setBounds(394, 0, 40, 20);
		date.setBounds(591, 0, 40, 20);
		fare.setBounds(788, 0, 40, 20);
		buttonHall[0] = new JButton(filmhall1);
		buttonHall[1] = new JButton(filmhall2);
		buttonHall[2] = new JButton(filmhall1);
		buttonHall[3] = new JButton(filmhall2);
		buttonHall[4] = new JButton(filmhall1);
		buttonHall[5] = new JButton(filmhall1);
		buttonHall[6] = new JButton(filmhall2);
		labelFilm[0] = new JLabel(filmIcon1);
		labelFilm[1] = new JLabel(filmIcon2);
		labelFilm[2] = new JLabel(filmIcon3);
		labelFilm[3] = new JLabel(filmIcon4);
		labelFilm[4] = new JLabel(filmIcon5);
		labelFilm[5] = new JLabel(filmIcon6);
		labelFilm[6] = new JLabel(filmIcon7);
		labelName[0] = new JLabel("The Return of the King");
		labelName[1] = new JLabel("To the Arctic");
		labelName[2] = new JLabel("The Revenant");
		labelName[3] = new JLabel("Wolf Totem");
		labelName[4] = new JLabel("Fast & Furious 7");
		labelName[5] = new JLabel("Mad Max");
		labelName[6] = new JLabel("Monkey King: Hero Is Back");
		labelDate[0] = new JLabel("4.1   14:00-16:00");
		labelDate[1] = new JLabel("4.1   14:00-16:00");
		labelDate[2] = new JLabel("4.1   18:00-20:00");
		labelDate[3] = new JLabel("4.1   18:00-20:00");
		labelDate[4] = new JLabel("4.2   14:00-16:00");
		labelDate[5] = new JLabel("4.2   18:00-20:00");
		labelDate[6] = new JLabel("4.2   18:00-20:00");
		labelFare[0] = new JLabel("39.9");
		labelFare[1] = new JLabel("29.9");
		labelFare[2] = new JLabel("29.9");
		labelFare[3] = new JLabel("39.9");
		labelFare[4] = new JLabel("39.9");
		labelFare[5] = new JLabel("19.9");
		labelFare[6] = new JLabel("29.9");
	
		for(int i = 0;i < 7;i++) {
			labelName[i].setFont(new Font("",1,15));
			labelName[i].setForeground(Color.BLACK);
			labelDate[i].setFont(new Font("",1,20));
			labelDate[i].setForeground(Color.WHITE);
			labelFare[i].setFont(new Font("",1,20));
			labelFare[i].setForeground(Color.RED);
			labelYuan[i] = new JLabel(fareIcon);
			buttonSale[i] = new JButton(saleIcon);
			buttonSale[i].setBorderPainted(false);
			buttonSale[i].setContentAreaFilled(false);
			panel.add(buttonHall[i]);
			panel.add(buttonSale[i]);
			panel.add(labelFilm[i]);
			panel.add(labelName[i]);
			panel.add(labelDate[i]);
			panel.add(labelFare[i]);
			panel.add(labelYuan[i]);
			buttonHall[i].setBounds(20, 20+i*107, 64, 64);
			buttonSale[i].setBounds(880, 36+i*107, 80, 30);
			labelFilm[i].setBounds(170, 6+i*107, 75, 100);
			labelName[i].setBounds(330, 40+i*107, 300, 20);
			labelDate[i].setBounds(530, 40+i*107, 300, 20);
			labelFare[i].setBounds(770, 40+i*107, 150, 20);
			labelYuan[i].setBounds(810, 38+i*107, 24, 24);
		}
		
		buttonSale[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.conductor.setVisible(false);
				Menu.seat1.setVisible(true);
				
				Menu.frame.getContentPane().add(Menu.seat1);					
			}
		});
		buttonSale[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.conductor.setVisible(false);
				Menu.seat2.setVisible(true);
				Menu.frame.getContentPane().add(Menu.seat2);					
			}
		});
		buttonSale[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.conductor.setVisible(false);
				Menu.seat3.setVisible(true);
				Menu.frame.getContentPane().add(Menu.seat3);					
			}
		});
		buttonSale[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.conductor.setVisible(false);
				Menu.seat4.setVisible(true);
				Menu.frame.getContentPane().add(Menu.seat4);					
			}
		});
		buttonSale[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.conductor.setVisible(false);
				Menu.seat5.setVisible(true);
				Menu.frame.getContentPane().add(Menu.seat5);					
			}
		});
		buttonSale[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.conductor.setVisible(false);
				Menu.seat6.setVisible(true);
				Menu.frame.getContentPane().add(Menu.seat6);					
			}
		});
		buttonSale[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.conductor.setVisible(false);
				Menu.seat7.setVisible(true);
				Menu.frame.getContentPane().add(Menu.seat7);					
			}
		});
		
		scroll.setViewportView(panel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(title);
		this.add(scroll);
	}
	
}

class Seatpanel extends JPanel{
	Icon icon1=new ImageIcon("icon/sit1.png");
	Icon icon2=new ImageIcon("icon/sit2.png");
	Icon icon3=new ImageIcon("icon/sit3.png");
	private JButton[] buttons;
	private int[] flag = new int[80];
	private  JPanel SeatGroup,jpanel1;
	private JLabel label;
	private JButton jb;	
	public int count=0;
	String[] NamesOfSeats=new String[80];
	int [] ticket=new int[30];
	
	public Seatpanel(String name){
		SeatGroup=new JPanel();
		jb=new JButton("提交");
		jb.setLayout(null);
		jb.setBounds(880, 650, 100, 25);
		SeatGroup.setOpaque(false);
		setLayout(null);
		setVisible(false);
		SeatGroup.setLayout(new GridLayout(8,10,5,5));
		SeatGroup.setBounds(250, 250, 524, 268);
		label=new JLabel(name);
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setToolTipText("银幕");
		jpanel1.setBorder(BorderFactory.createLineBorder(Color.GRAY,2, true));
		buttons =new JButton[NamesOfSeats.length];
		
		for(int  i=0;i<NamesOfSeats.length;i++){
			flag[i] = -1;
			Icon icon = new ImageIcon("icon/sit1.png");
			buttons[i]=new JButton(icon);
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setPreferredSize(new Dimension(100,100));
			buttons[i].setToolTipText((i/10+1)+" 排  "+(i%10+1)+"列");
			add(buttons[i],BorderLayout.CENTER);
			SeatGroup.add(buttons[i]);
			
			buttons[i].addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent event){
							 
							 for(int i=0;i<buttons.length;i++){
								 
								 if(event.getSource()==buttons[i]){
									 
									 flag[i]  = (-1)*flag[i];
									 if(flag[i] == 1) {
										 buttons[i].setIcon(icon3);
										 ticket[count++]=i;	
										 if(count>=6)
											 JOptionPane.showMessageDialog(Menu.frame, "每次选票不能超过6张");
									 }
									 else {
										 buttons[i].setIcon(icon1);
										 count--;
									 }
									
								 }
							 }
						}			
		});		
	}		
		
			jb.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent event) {
					String str1 = "";
					String str[] = new String[count];
				/*	if(count>5){
						JOptionPane.showMessageDialog(Menu.frame, "一次选票不能超过五张","警告", JOptionPane.WARNING_MESSAGE);
					}*/
					 if(count == 0){
						JOptionPane.showMessageDialog(Menu.frame, "请至少选择一张座位","警告", JOptionPane.WARNING_MESSAGE);
					}
					else{
						
						for(int i=0;i<count;i++){
							str[i]= "    "+(ticket[i]/10+1)+"排 "+(ticket[i]%10+1)+"列";
							
							}
						for(int i = 0;i<str.length;i++) {
							str1+=str[i];
						}
						for(int i=0;i<80;i++)
							if(flag[i]==1)
								buttons[i].setIcon(icon2);
						JOptionPane.showMessageDialog(Menu.frame, "提交成功"+str1);
				    }
				count=0;
				}
			});
		add(SeatGroup);
		add(jb);
		label.setBounds(450,50,120,20);
		jpanel1.setBounds(200, 100, 600, 30);
		label.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
		label.setForeground(Color.RED);
		add(label);
		add(jpanel1);
   }
}

class Login extends JDialog {	
	ImageIcon userIcon = new ImageIcon("icon/user.png");
	ImageIcon idIcon = new ImageIcon("icon/id.png");
	ImageIcon passwordIcon = new ImageIcon("icon/password.png");
	String idText = new String();
	JLabel ID = new JLabel(idIcon);
	JTextField id = new JTextField();
	String passwordText = new String();
	JLabel PASSWORD = new JLabel(passwordIcon);
	JPasswordField password = new JPasswordField();
	JButton loginButton = new JButton(userIcon);
	
	public Login(String user) {
		this.setTitle(user);
		this.setModal(true);
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(350, 300, 300, 200);
		ID.setBounds(20, 40, 40, 20);
		id.setBounds(60, 40, 160, 20);
		PASSWORD.setBounds(20, 80, 40, 20);
		password.setBounds(60, 80, 160, 20);
		loginButton.setBounds(110, 120, 50, 30);
		loginButton.setBackground(Color.PINK);
		this.getContentPane().add(ID);
		this.getContentPane().add(id);
		this.getContentPane().add(PASSWORD);
		this.getContentPane().add(password);
		this.getContentPane().add(loginButton);	
		
		id.addKeyListener(new KeyAdapter() { 
	        public void keyReleased(KeyEvent e) { 
	                super.keyReleased(e); 
	                idText = id.getText();
	        } 
	    });
		
		password.addKeyListener(new KeyAdapter() { 
	        public void keyReleased(KeyEvent e) { 
	                super.keyReleased(e); 
	                char[] chars = password.getPassword(); 
	                passwordText = String.valueOf(chars);
	        } 
	    });
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idText.equals("111") && passwordText.equals("222") && Menu.homepage.isVisible()) {
					Menu.login1.dispose();
					Menu.homepage.setVisible(false);
					Menu.administrator.setVisible(true);
					Menu.frame.getContentPane().add(Menu.administrator);
				}
				else if(idText.equals("111") && passwordText.equals("333") && Menu.homepage.isVisible()) {
					Menu.login2.dispose();
					Menu.homepage.setVisible(false);
					Menu.conductor.setVisible(true);
					Menu.frame.getContentPane().add(Menu.conductor);
				}
			}
		});
		
	}
}

class Help extends JDialog {
	ImageIcon helpIcon = new ImageIcon("icon/help.gif");
	JLabel help = new JLabel(helpIcon);	
	public Help() {
		this.setTitle("帮助");
		this.setModal(true);
		this.setBounds(400, 250, 200, 300);;
		this.getContentPane().add(help);
		this.setVisible(true);
	}
}

class Menu {
	static JFrame frame = new JFrame("剧院管理系统");
	static JDialog login1 = new Login("管理员登录");
	static JDialog login2 = new Login("售票员登录");
	static Image background = new ImageIcon("icon/background1.jpg").getImage();
	static JPanel homepage = new Paintpanel(background);
	static JPanel administrator = new Administratorpanel();
	static JPanel filmhall = new Filmhallpanel();
	static JPanel conductor = new Conductorpanel();
	static searchDialog search= new searchDialog();
	static JPanel seat1 = new Seatpanel("一号演出厅");
	static JPanel seat2 = new Seatpanel("二号演出厅");
	static JPanel seat3 = new Seatpanel("一号演出厅");
	static JPanel seat4 = new Seatpanel("二号演出厅");
	static JPanel seat5 = new Seatpanel("一号演出厅");
	static JPanel seat6 = new Seatpanel("一号演出厅");
	static JPanel seat7 = new Seatpanel("二号演出厅");
	JMenuBar menuBar = new JMenuBar();
	ImageIcon image1 = new ImageIcon("icon/return.png");
	ImageIcon image2 = new ImageIcon("icon/help.png");
	ImageIcon image3 = new ImageIcon("icon/login.png");
	ImageIcon image4 = new ImageIcon("icon/exit.png");
	ImageIcon image5 = new ImageIcon("Icon/set.png");
	JMenu back = new JMenu("返回(back)");
	JMenu help = new JMenu("帮助(help)");
	JMenu login = new JMenu("登录(login)");
	JMenu exit = new JMenu("退出(exit)");
	JMenu set = new JMenu("设置(set)");
	JMenu skin = new JMenu("皮肤(skin)"); 
	JMenuItem Administratorlogin = new JMenuItem("管理员(Administrator)");
	JMenuItem Conductorlogin = new JMenuItem("售票员(conductor)");
	JRadioButtonMenuItem skin1 = new JRadioButtonMenuItem("1");
	JRadioButtonMenuItem skin2 = new JRadioButtonMenuItem("2");
	JRadioButtonMenuItem skin3 = new JRadioButtonMenuItem("3");	
	JRadioButtonMenuItem skin4 = new JRadioButtonMenuItem("4");	
	JRadioButtonMenuItem skin5 = new JRadioButtonMenuItem("5");	
	ButtonGroup buttonSkin = new ButtonGroup();	
	
	public Menu() {
		back.setIcon(image1);
		help.setIcon(image2);
		login.setIcon(image3);
		exit.setIcon(image4);
		set.setIcon(image5);
		login.add(Administratorlogin);
		login.add(Conductorlogin);
		set.add(skin);
		menuBar.add(back);
		menuBar.add(help);
		menuBar.add(login);
		menuBar.add(exit);
		menuBar.add(set);
		buttonSkin.add(skin1);
		buttonSkin.add(skin2);
		buttonSkin.add(skin3);
		buttonSkin.add(skin4);
		buttonSkin.add(skin5);
		skin.add(skin1);
		skin.add(skin2);
		skin.add(skin3);
		skin.add(skin4);
		skin.add(skin5);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(homepage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		frame.setSize(1024, 768);
		frame.setVisible(true);
		
		skin1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background1.jpg").getImage();
            	   homepage = new Paintpanel(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background2.jpg").getImage();
            	   homepage = new Paintpanel(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background3.jpg").getImage();
            	   homepage = new Paintpanel(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background4.jpg").getImage();
            	   homepage = new Paintpanel(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background5.jpg").getImage();
            	   homepage = new Paintpanel(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		Administratorlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	login1.setVisible(true);
            }
        });
		
		Conductorlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	login2.setVisible(true);
            }
        });
		
		back.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				if(administrator.isVisible()) {
					administrator.setVisible(false);
					homepage.setVisible(true);
				}
				else if(filmhall.isVisible()) {
					filmhall.setVisible(false);
					homepage.setVisible(true);
				}
				else if(conductor.isVisible()) {
					conductor.setVisible(false);
					homepage.setVisible(true);
				}
				else if(seat1.isVisible()) {
					seat1.setVisible(false);
					conductor.setVisible(true);
				}
				else if(seat2.isVisible()) {
					seat2.setVisible(false);
					conductor.setVisible(true);
				}
				else if(seat3.isVisible()) {
					seat3.setVisible(false);
					conductor.setVisible(true);
				}
				else if(seat4.isVisible()) {
					seat4.setVisible(false);
					conductor.setVisible(true);
				}
				else if(seat5.isVisible()) {
					seat5.setVisible(false);
					conductor.setVisible(true);
				}
				else if(seat6.isVisible()) {
					seat6.setVisible(false);
					conductor.setVisible(true);
				}
				else if(seat7.isVisible()) {
					seat7.setVisible(false);
					conductor.setVisible(true);
				}
			}
            public void menuCanceled(MenuEvent e) {}
            public void menuDeselected(MenuEvent e) {}
        });
		
		help.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				new Help();
			}
            public void menuCanceled(MenuEvent e) {}
            public void menuDeselected(MenuEvent e) {}
        });
	
		exit.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				System.exit(0);
			}
            public void menuCanceled(MenuEvent e) {}
            public void menuDeselected(MenuEvent e) {}
        });
		
	}
}
