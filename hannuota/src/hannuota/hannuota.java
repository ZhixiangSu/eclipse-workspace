package hannuota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class hannuota
{
	static JFrame frame=new JFrame("ººÅµËþ");
	int a[]=new int[3],b[];
    static JLabel l1=new JLabel("ººÅµËþ",JLabel.CENTER);
    static JLabel l2=new JLabel("²ãÊý",JLabel.CENTER);
    static JPanel p0=new JPanel();
    static JPanel p1=new JPanel();
    static JPanel p2=new JPanel();
    static JPanel p3=new JPanel();
    static JPanel p4[]=new JPanel[4];
    static JButton b1=new JButton("È·¶¨");
    static JTextField t1=new JTextField();
    static Show show=new Show();
    public static void main(String args[])
    {
    	//set frame
    	frame.setSize(500, 250);
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    	frame.add(p0);
    	//set p0
    	p0.setLayout(new BorderLayout());
    	p0.add(p1,BorderLayout.WEST);
    	p0.add(p2,BorderLayout.CENTER);
    	p0.add(b1,BorderLayout.EAST);
    	//set p1
    	p1.setLayout(new BorderLayout());
    	p1.add(l1, BorderLayout.CENTER);
    	p1.setBackground(Color.blue);
    	//set p2
    	p2.setLayout(new GridLayout(2,1));
    	p2.setBackground(Color.yellow);
    	p2.add(l2);
    	p2.add(t1);
    	//set l1
    	l1.setFont(new Font("¿¬Ìå",Font.BOLD, 20));
    	//set l2
    	l2.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
    	//set t1
    	t1.setFont(new Font("¿¬Ìå",Font.BOLD,30));
    	t1.setHorizontalAlignment(JTextField.HORIZONTAL);
    	
    	b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thread t1=new Thread(show);
				t1.start();
			}
		});
    }
}
