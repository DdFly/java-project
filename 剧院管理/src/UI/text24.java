package UI;
import java.awt.event.*;

import java.util.Iterator;

import javax.swing.event.*;


import java.awt.*;
import javax.swing.*;
public class text24 {
	public static void main(String[] args) {
		new Menu();	
	}
}
class Paintpanel extends JPanel {
	private Image image = null;
	static JPanel p1=new JPanel();
	public Paintpanel(Icon image,String name,String time,JTextArea js,Image image1) {
		final JButton jb1=new JButton();
		jb1.setIcon(image);
		add(jb1);
		jb1.addActionListener(new ActionListener(){
			JLabel l1,l2,l3,l4,l5;
			public void actionPerformed(ActionEvent event){
				if(event.getSource()==jb1){
					//JPanel p1=new JPanel();
					JFrame jf=new JFrame();
					JPanel p2=new Paintpanel1(image1);
					
					p1.setLayout(null);
					p2.setLayout(null);
					p2.setBounds(0,0,400,500);
					p1.add(p2);
					p1.setBounds(0, 0, 1024, 768);
					l1=new JLabel (name);
					l2=new JLabel(time);
					l3=new JLabel("���:");
					l4=new JLabel("Ƭ��:");
					l5=new JLabel("��ӳʱ��:");
					
					l1.setBounds(150,550, 250, 20);
					l2.setBounds(600, 550, 200, 20);
					l3.setBounds(450, 120, 200, 20);
					l4.setBounds(50, 550, 50, 20);
					l5.setBounds(450, 550, 100, 20);
					js.setBounds(450, 150, 524, 500);
					js.setLineWrap(true);
					js.setOpaque(false);
					l1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
					l1.setForeground(Color.BLUE);
					l2.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
					l2.setForeground(Color.BLACK);
					l3.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
					l3.setForeground(Color.BLUE);
					l4.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
					l4.setForeground(Color.BLACK);
					l5.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
					l5.setForeground(Color.BLUE);
					js.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
					js.setForeground(Color.BLACK);
					
					p1.add(l1);
					p1.add(l2);
					p1.add(l3);
					p1.add(l4);
					p1.add(l5);
					p1.add(js);
					
					jf.add(p1);
					//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.setSize(1024, 768);
					jf.setVisible(true);
				}
			}
			
		});
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null, this);
	}
}

class Paintpanel1 extends JPanel {
	private Image image = null;
	public Paintpanel1(Image image) {
		this.image=image;
		
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null, this);
	}
}
class Administratorpanel extends JPanel {
	Icon moviePoster1 = new ImageIcon("icon/movie1.jpg");
	Icon moviePoster2 = new ImageIcon("icon/movie2.jpg");
	Icon moviePoster3 = new ImageIcon("icon/movie3.jpg");
	Icon moviePoster4 = new ImageIcon("icon/movie4.jpg");
	Icon moviePoster5 = new ImageIcon("icon/movie5.jpg");
	Icon moviePoster6 = new ImageIcon("icon/movie6.jpg");
	Icon moviePoster7 = new ImageIcon("icon/movie7.jpg");
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
	JTextArea js1=new JTextArea("        ��ָ�����������������ǡ�ָ������ϵ�е�Ӱ�ĵ��������ɱ˵á��ܿ�ѷִ����ά�ꡤĪ��ɭ�������ǡ���º����������׵����ǳ��ݡ�ӰƬ��2004��3��12�����й���ӳ����Ӱ����Ϊ����ɴݻ�ħ���ʹ�������޶���ɽķ���������ǰ��ĩ�ջ�ɽ�����������Լ����ҳϼ����������еļ�ǿ��������ͬʱ���ʵ��������ԡ�������˹������Ҳ�������Կ����׵Ĺ��������������������磻�����׶�����˹����˹Σ�ڵ�Ϧ��������ʰ������֮������������ŵƽԭչ��һ��ԡѪս�ۣ������ó��в�����������Σ������ս��Զ���ӻ��Ƿ���ӭ������� ... >>>");
	JTextArea js2=new JTextArea("        ��������ȥ����һ��ʻ�����羡ͷ���ọ́�һ������������ռ����¡� ��Ӱ��������ڣ�ͬһֻĸ�����ܺ�������ֻ�߸��´������һ�𣬴�Խ�ڼ��ص�ãã��ԭ�С���Ƭ��ԭ�������������еļҡ������������ڵı�ԭ�ϣ��ھ޴�ı�ɽ�£�..");
	JTextArea js3=new JTextArea("         ���½���19�����Է�����ƤΪ�������������ڱ�ӡ�ڰ���Ϯ�����Ӻ�ͬ����������ѷ���Ӫ�ص�;�У���ͷ�ĸ���˹�������ɶ��Σ��ֲ��ұ��������ˣ����ӵ����������ô���޷��������˵ĸ���˹���У�����˵������Ӷ����ͬ�������տ�������..");
	JTextArea js4=new JTextArea("         ����ͼ�ڡ���Wolf Totem�����з����ĵ�һ��ð�վ���Ƭ���ı��Խ���ͬ��С˵������3Dʵ�����㡣��Ƭ�����������㡶���ٳ��¡��������ֻ��ܡ��ķ��������á��ſˡ���ŵ����λ����Ϊ������㶯����ĵĵ��ݣ�����7��ﱸ�ⲿ����ͼ�ڡ���������һ�����ھͺ�ʱ3�ꡣ����������еľ�ͷ���ԣ������Ǵ���һ���޼ʵĴ��ԭ��������֮����α˴����أ���г���������ܷ塢��硢��ɭ�������������������ʤ���ݣ�����2015��2��19���й���½��ӳ��ӰƬ�����������ɹŴ��ԭ�ϣ���������Ϊ��������˴�չ����ɱ�Ĺ��� ... >>");
	JTextArea js5=new JTextArea("          ����7���Ĺ��½��ڶ�����˵��ŶӺʹ��ɵ�������Ф֮��չ����������˺�����ֿ���ǽ�����һ��ӰƬ�кʹ���ŷ�ġ�Ф���׶ص�ս��֮�󣬻ص������������������Ѿõ�ƽ��������������׶ؽ��µ����Ӻܿ����������ƽ����ŷ�ġ�Ф��..");
	JTextArea js6=new JTextArea("          �����ѱ����������Ѵ��������Ǹ�Ѫ�ͻ�����磬Ϊ�����������˶�����п�Ķ��������޾��Ļ���ɳĮ�У����������ķ��������п��ܸ������罨���������˹����ķ������ �Σ���һ����Ĭ���Ե����ˣ����ڻ�����ʧȥ�˼��ˣ������׷Ѱ��..");
	JTextArea js7=new JTextArea("          �����칬���İ�����꣬�����ʥ����һ����˵����ɽ�����еĳ����ǣ��¶����������н�ɮ��������Ϊ����СС���곣�����������칬������ա���һ�죬ɽ��������ͯ��ͯŮ������������һ��СŮ�����ǵ�ɽ��׷ɱ����һ·...չ��>>");
	
	Image movie1Poster = new ImageIcon("icon/movie1.jpg").getImage();
	Image movie2Poster = new ImageIcon("icon/movie2.jpg").getImage();
	Image movie3Poster = new ImageIcon("icon/movie3.jpg").getImage();
	Image movie4Poster = new ImageIcon("icon/movie4.jpg").getImage();
	Image movie5Poster = new ImageIcon("icon/movie5.jpg").getImage();
	Image movie6Poster = new ImageIcon("icon/movie6.jpg").getImage();
	Image movie7Poster = new ImageIcon("icon/movie7.jpg").getImage();
	
	JPanel movie1 = new Paintpanel(moviePoster1,"The Return of the King","4.1   14:00-16:00",js1,movie1Poster); 
	JPanel movie2 = new Paintpanel(moviePoster2,"To the Arctic","4.1   14:00-16:00",js2,movie2Poster); 
	JPanel movie3 = new Paintpanel(moviePoster3,"The Revenant","4.1   18:00-20:00",js3,movie3Poster);
	JPanel movie4 = new Paintpanel(moviePoster4,"Wolf Totem","4.1   18:00-20:00",js4,movie4Poster);
	JPanel movie5 = new Paintpanel(moviePoster5,"Fast & Furious 7","4.2   14:00-16:00",js5,movie5Poster);
	JPanel movie6 = new Paintpanel(moviePoster6,"Mad Max","4.2   18:00-20:00",js6,movie6Poster);
	JPanel movie7 = new Paintpanel(moviePoster7,"Monkey King: Hero Is Back","4.2   18:00-20:00",js7,movie7Poster);
	JPanel bottomPanel = new Paintpanel1(bottomBackground);
	
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
	JPanel filmhall1 = new Paintpanel1(filmhallIcon1);
	JPanel filmhall2 = new Paintpanel1(filmhallIcon2);
	JPanel bottomPanel = new Paintpanel1(bottomBackground);
	
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
//ӰƬ����Ϣ
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
	JLabel hall = new JLabel("Ӱ��");
	JLabel film = new JLabel("ӰƬ");
	JLabel name = new JLabel("Ƭ��");
	JLabel date = new JLabel("����");
	JLabel fare = new JLabel("Ʊ��");
	JButton[] buttonHall = new JButton[7];
	JButton[] buttonSale = new JButton[7];
	JLabel[] labelFilm = new JLabel[7];
	static JLabel[] labelName = new JLabel[7];
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
	private  JPanel SeatGroup,jpanel1,p3;
	private JLabel label,label1,label2;
	private JButton jb;	
	public int count=0;
	String[] NamesOfSeats=new String[80];
	int [] ticket=new int[30];
	
	public Seatpanel(String name){
		SeatGroup=new JPanel();
		jb=new JButton("�ύ");
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
		jpanel1.setToolTipText("��Ļ");
		jpanel1.setBorder(BorderFactory.createLineBorder(Color.GRAY,2, true));
		buttons =new JButton[NamesOfSeats.length];
		
		label1=new JLabel("һ�����ֻ��ѡ6��Ʊ");
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBounds(800,580, 200, 50);
		JLabel bt1 = new JLabel();bt1.setBounds(0,0,20,15);bt1.setIcon(icon1);
		JLabel bt2 = new JLabel();bt2.setBounds(80,0,20,15);bt2.setIcon(icon2);
		JLabel bt3 = new JLabel();bt3.setBounds(160,0,20,15);bt3.setIcon(icon3);
		JLabel lb1 = new JLabel("��ѡ");lb1.setBounds(0,20,50,20);
		JLabel lb2 = new JLabel("����ѡ");lb2.setBounds(78,20,50,20);
		JLabel lb3 = new JLabel("��ѡ");lb3.setBounds(155,20,50,20);
		p3.add(bt1);p3.add(lb1);
		p3.add(bt2);p3.add(lb2);
		p3.add(bt3);p3.add(lb3);
		add(p3);
		
		for(int  i=0;i<NamesOfSeats.length;i++){
			flag[i] = -1;
			Icon icon = new ImageIcon("icon/sit1.png");
			buttons[i]=new JButton(icon);
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setPreferredSize(new Dimension(100,100));
			buttons[i].setToolTipText((i/10+1)+" ��  "+(i%10+1)+"��");
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
											 JOptionPane.showMessageDialog(Menu.frame, "ÿ��ѡƱ���ܳ���6��");
										 
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
						JOptionPane.showMessageDialog(Menu.frame, "һ��ѡƱ���ܳ�������","����", JOptionPane.WARNING_MESSAGE);
					}*/
					 if(count == 0){
						JOptionPane.showMessageDialog(Menu.frame, "������ѡ��һ����λ","����", JOptionPane.WARNING_MESSAGE);
					}
					else{
						
						for(int i=0;i<count;i++){
							str[i]= "    "+(ticket[i]/10+1)+"�� "+(ticket[i]%10+1)+"��";
							
							}
						for(int i = 0;i<str.length;i++) {
							str1+=str[i];
						}
						for(int i=0;i<80;i++)
							if(flag[i]==1){
								buttons[i].setIcon(icon2);
								buttons[i].setEnabled(false);
								buttons[i].setToolTipText("�����λ�Ѿ���ѡ����");
							}
						JOptionPane.showMessageDialog(Menu.frame, "�ύ�ɹ�"+str1);
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
				if(idText.equals("Ad") && passwordText.equals("666") && Menu.homepage.isVisible()) {
					Menu.login1.dispose();
					Menu.homepage.setVisible(false);
					Menu.administrator.setVisible(true);
					Menu.frame.getContentPane().add(Menu.administrator);
				}
				else if(idText.equals("Co") && passwordText.equals("666") && Menu.homepage.isVisible()) {
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
		this.setTitle("����");
		this.setModal(true);
		this.setBounds(400, 250, 200, 300);
		this.getContentPane().add(help);
		this.setVisible(true);
	}
}

class Menu {
	static JFrame frame = new JFrame("��Ժ����ϵͳ");
	static JDialog login1 = new Login("����Ա��¼");
	static JDialog login2 = new Login("��ƱԱ��¼");
	static Image background = new ImageIcon("icon/background1.jpg").getImage();
	static JPanel homepage = new Paintpanel1(background);
	static JPanel administrator = new Administratorpanel();
	static JPanel filmhall = new Filmhallpanel();
	static JPanel conductor = new Conductorpanel();
	static JPanel seat1 = new Seatpanel("һ���ݳ���");
	static JPanel seat2 = new Seatpanel("�����ݳ���");
	static JPanel seat3 = new Seatpanel("һ���ݳ���");
	static JPanel seat4 = new Seatpanel("�����ݳ���");
	static JPanel seat5 = new Seatpanel("һ���ݳ���");
	static JPanel seat6 = new Seatpanel("һ���ݳ���");
	static JPanel seat7 = new Seatpanel("�����ݳ���");
	JMenuBar menuBar = new JMenuBar();
	ImageIcon image1 = new ImageIcon("icon/return.png");
	ImageIcon image2 = new ImageIcon("icon/help.png");
	ImageIcon image3 = new ImageIcon("icon/login.png");
	ImageIcon image4 = new ImageIcon("icon/exit.png");
	ImageIcon image5 = new ImageIcon("Icon/set.png");
	JMenu back = new JMenu("����(back)");
	JMenu help = new JMenu("����(help)");
	JMenu login = new JMenu("��¼(login)");
	JMenu exit = new JMenu("�˳�(exit)");
	JMenu set = new JMenu("����(set)");
	JMenu skin = new JMenu("Ƥ��(skin)"); 
	JMenuItem Administratorlogin = new JMenuItem("����Ա(Administrator)");
	JMenuItem Conductorlogin = new JMenuItem("��ƱԱ(conductor)");
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
            	   homepage = new Paintpanel1(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background2.jpg").getImage();
            	   homepage = new Paintpanel1(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background3.jpg").getImage();
            	   homepage = new Paintpanel1(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background4.jpg").getImage();
            	   homepage = new Paintpanel1(background);  
            	   homepage.repaint();
            	   homepage.setVisible(true);
            	   frame.getContentPane().add(homepage);
            }
        });
		
		skin5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   homepage.setVisible(false);
            	   Image background = new ImageIcon("icon/background5.jpg").getImage();
            	   homepage = new Paintpanel1(background);  
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
				/*else if(Paintpanel.p1.isVisible()) {
					Paintpanel.p1.setVisible(false);
					administrator.setVisible(true);
				}*/
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
