package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class UI 
{
	static JFrame frame=new JFrame("calculator");
	static JPanel text_p1=new JPanel();
	static JPanel input_p2=new JPanel();
	static TextField text=new TextField(" ");
	static NumberButton bt_number[]=new NumberButton[10];
	static CommandButton bt_add=new CommandButton("+",text);
	static CommandButton bt_minus=new CommandButton("-",text);
	static CommandButton bt_mutiply=new CommandButton("*",text);
	static CommandButton bt_divide=new CommandButton("/",text);
	static CommandButton bt_leftq=new CommandButton("(",text);
	static CommandButton bt_rightq=new CommandButton(")",text);
	
	public static void main(String args[])
	{
		for(Integer i=0;i<=9;i++)
		{
			bt_number[i]=new NumberButton(i.toString(),text);
		}
		frame.setLayout(new BorderLayout());
		frame.add(text_p1,BorderLayout.NORTH);
		frame.add(input_p2,BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		text_p1.setLayout(new BorderLayout());
		text_p1.add(text,BorderLayout.CENTER);
		text.setFont(new Font("ËÎÌו",Font.BOLD,30));
		text.setEditable(false);
		
		input_p2.setLayout(new GridLayout(4, 4));
		input_p2.add(bt_number[7]);
		input_p2.add(bt_number[8]);
		input_p2.add(bt_number[9]);
		input_p2.add(bt_divide);
		input_p2.add(bt_number[4]);
		input_p2.add(bt_number[5]);
		input_p2.add(bt_number[6]);
		input_p2.add(bt_mutiply);
		input_p2.add(bt_number[1]);
		input_p2.add(bt_number[2]);
		input_p2.add(bt_number[3]);
		input_p2.add(bt_minus);
		input_p2.add(bt_number[0]);
		input_p2.add(bt_leftq);
		input_p2.add(bt_rightq);
		input_p2.add(bt_add);
		input_p2.updateUI();
	}
}
