package hannuota;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class hannuota 
{
	static JLabel l1=new JLabel("ººÅµËþ");
	static JFrame f1=new JFrame("ººÅµËþ");
	public static void main(String args[])
	{
		//f1
		f1.setLayout(null);
		f1.setSize(500, 500);
		f1.add(l1);
		f1.setVisible(true);
		//l1
		l1.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		l1.setBounds(100, 0,100,50);
		
	}
}
