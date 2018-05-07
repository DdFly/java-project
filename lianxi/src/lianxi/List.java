package lianxi;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

public class List {

	public static  void main(String[] args){
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		Set set = new HashSet();
		set.add(button1);
		set.add(button1);
		set.add(button1);set.add(button1);set.add(button1);set.add(button1);
		
	}
}
