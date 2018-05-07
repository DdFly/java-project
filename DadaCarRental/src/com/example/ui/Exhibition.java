package com.example.ui;

/**
 * �ó�һ��
 *
 */

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.example.model.Car;
import com.example.service.Exhibition_Srv;

	

	public class Exhibition extends JPanel{
		int j = 0;
		private static final long serialVersionUID = 1L;
		ImageIcon carIcon1 = new ImageIcon("icon/car1.jpg");
		Image background1= new ImageIcon("icon/background1.jpg").getImage();
		Image background2= new ImageIcon("icon/background2.jpg").getImage();
		JPanel panel = new Paintpanel(background1);
		JPanel exhibition = new Paintpanel(background2);//��ʾ���г���
		JPanel exhibition1 = new Paintpanel(background2);//��ʾ������ѡ�õ��ĳ���
		JTextField search = new JTextField(60);
		JButton search_button = new JButton("Search");
		JButton[] car_button = new JButton[12];
		JLabel[] car_label = new JLabel[12];
		
		ButtonGroup type = new ButtonGroup();
		JRadioButton type1 = new JRadioButton("����");
		JRadioButton type2 = new JRadioButton("������");
		JRadioButton type3 = new JRadioButton("������");
		JRadioButton type4 = new JRadioButton("������");
		JRadioButton type5 = new JRadioButton("SUV");
		JRadioButton type6 = new JRadioButton("�ܳ���");
		Exhibition_Srv exSrv = new Exhibition_Srv();
		List<Car> carList = exSrv.FetchAll();//���г������б�
		List<Car> searchList = new ArrayList<>();//������ѡ�õ��ĳ����б�
		
		public Exhibition() {
			this.setLayout(null);
			this.setVisible(false);
			panel.setLayout(null);
			exhibition.setLayout(null);
			exhibition1.setLayout(null);
			exhibition1.setVisible(false);
			
			for(int i = 0;i < carList.size();i++) { //��ʾ���г���
				j++;
				final Car car = carList.get(i);
				car_button[i] = new JButton(carIcon1);
				car_label[i] = new JLabel(car.getCar_Name());
				car_button[i].setBorderPainted(false);
				car_button[i].setContentAreaFilled(false);
				car_button[i].setBounds(40+(i%6)*150, (i/6)*100, 120, 70);
				car_label[i].setBounds(70+(i%6)*150, (i/6)*100+70, 120, 20);
				exhibition.add(car_button[i]);
				exhibition.add(car_label[i]);
				car_button[i].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent Arg0) {
						new CarInfo(car);
						
						
					}
				});
				
			}

			type1.setBorderPainted(false);
			type1.setContentAreaFilled(false);
			type1.setSelected(true);
			type2.setBorderPainted(false);
			type2.setContentAreaFilled(false);
			type3.setBorderPainted(false);
			type3.setContentAreaFilled(false);
			type4.setBorderPainted(false);
			type4.setContentAreaFilled(false);
			type5.setBorderPainted(false);
			type5.setContentAreaFilled(false);
			type6.setBorderPainted(false);
			type6.setContentAreaFilled(false);
			
			this.setBounds(0, 80, 1280, 640);
			panel.setBounds(0, 0, 1280, 640);
			exhibition.setBounds(180, 100, 960, 480);
			exhibition1.setBounds(180, 100, 960, 480);
			
			search.setBounds(250, 30 , 600 , 30);
			search_button.setBounds(880, 30, 80 , 30);
			type1.setBounds(0, 240, 120, 20);
			type2.setBounds(0, 280, 120, 20);
			type3.setBounds(0, 320, 120, 20);
			type4.setBounds(0, 360, 120, 20);
			type5.setBounds(0, 400, 120, 20);
			type6.setBounds(0, 440, 120, 20);
			
			type.add(type1);
			type.add(type2);
			type.add(type3);
			type.add(type4);
			type.add(type5);
			type.add(type6);
			panel.add(exhibition);
			panel.add(exhibition1);
			panel.add(search);
			panel.add(search_button);
			panel.add(type1);
			panel.add(type2);
			panel.add(type3);
			panel.add(type4);
			panel.add(type5);
			panel.add(type6);
			this.add(panel);
		
			search_button.addActionListener(new ActionListener() { //���������������searchList
				public void actionPerformed(ActionEvent arg0) {
					String s = search.getText();
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			//���ݵ�ѡ�������searchList
			type1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					searchList.clear();
					searchList = exSrv.FetchAll();
					Refresh();
				}
			});
			
			type2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "΢��";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "С��";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "����";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "suv";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "�ܳ�";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
		}
		
		public void Refresh() {//����������ѡ����ʾ���г�����exhibition����Ϊ��ʾ��Ӧ������exhibition1
			exhibition.setVisible(false);
			exhibition1.setVisible(true);
			exhibition1.removeAll();
			exhibition1.updateUI();
			for( int i = 0;i < searchList.size();i++) {
				j++;
				final Car car = searchList.get(i);
				car_button[i] = new JButton(carIcon1);
				car_label[i] = new JLabel(car.getCar_Name());
				car_button[i].setBorderPainted(false);
				car_button[i].setContentAreaFilled(false);
				car_button[i].setBounds(40+(i%6)*150, (i/6)*100, 120, 70);
				car_label[i].setBounds(70+(i%6)*150, (i/6)*100+70, 120, 20);
				exhibition1.add(car_button[i]);
				exhibition1.add(car_label[i]);
				car_button[i].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent Arg0) {
						new CarInfo(car);
						
						
					}
				});
				
//				car_button[i] = new JButton(carIcon1);
//				car_label[i] = new JLabel(searchList.get(i).getCar_Name());
//				car_button[i].setBorderPainted(false);
//				car_button[i].setContentAreaFilled(false);
//				car_button[i].setBounds(40+(i%6)*150, (i/6)*100, 120, 70);
//				car_label[i].setBounds(70+(i%6)*150, (i/6)*100+70, 120, 20);
//				exhibition1.add(car_button[i]);
//				exhibition1.add(car_label[i]);
			}
		}
		
		public void changePanel() {
			exhibition.setVisible(true);
			exhibition1.setVisible(false);
		}
		
	}
	
	class CarInfo extends JDialog{//��ʾ������ϸ��Ϣ
		private static final long serialVersionUID = 1L;
		JDialog jd = new JDialog(MainMenu.m.frame, "������Ϣ", true);
		JLabel name = new JLabel();
		JLabel type = new JLabel();
		public CarInfo(Car car) {
			jd.setLayout(null);
			name.setText("�������ƣ�"+car.getCar_Name());
			type.setText("�������ͣ�"+car.getCar_Type());
			name.setBounds(20, 30, 150, 30);
			type.setBounds(180, 30, 150, 30);
			jd.add(name);
			jd.add(type);
			jd.setBounds(300, 100, 400, 560);
			jd.setVisible(true);
			
		}	
	}

