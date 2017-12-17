package ¶íÂÞË¹·½¿é;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Paint;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Square extends JLabel
{
	int x,y;
	public Square(int x,int y,ImageIcon icon) {
		// TODO Auto-generated constructor stub
		super(icon);
		this.x=x;this.y=y;
		setBounds(x, y, 50, 50);
		setBackground(Color.BLUE);
	}
}
