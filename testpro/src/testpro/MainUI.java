package testpro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class MainUI {
	static Integer count = 0;
	static boolean threadstop;
	static Part parts[] = new Part[8];
	static boolean part0[][] = { { true, true, true, true }, };
	static boolean part1[][] = { { false, true, false }, { true, true, true } };
	static boolean part2[][] = { { true, true, false }, { false, true, true }	};
	static boolean part3[][] = { { true, true }, { true, true } };
	static boolean part4[][] = { { false, true, true }, { true, true, false } };
	static boolean part5[][] = { { true, false, false }, { true, true, true } };
	static boolean part6[][] = { { false, false, true }, { true, true, true } };
	static boolean part7[][] = { { true} };
	static JFrame frame = new JFrame("俄罗斯方块");
	static ShowAnim anim = new ShowAnim(20, 10);
//	static Background p0 = new Background();
//	static JPanel p1 = new JPanel();
//	static JPanel p2 = new JPanel();
//	static JPanel p3 = new JPanel();
//	static JLabel l1 = new JLabel("速度", JLabel.CENTER);
//	static ImageIcon icon[] = new ImageIcon[8];

//	static JButton bt[] = new JButton[8];
//	static JSlider slider = new JSlider(JSlider.HORIZONTAL, 1,5, 3);
//	static ImageIcon imageIcon = new ImageIcon("beijing.jpg");
//	static int num = 0;

	public MainUI(int valueup) {
		Analyse.valueup=valueup;
		Analyse.valueh=247;
		Analyse.valuespace=559;
		Analyse.valuedelete=453;
		Analyse.valuey=143;
//		frame.setSize(850, 1050);
//		frame.setResizable(false);
//		frame.setLayout(null);
		//frame.setVisible(true);
//		frame.add(p0);
//		frame.setIconImage(imageIcon.getImage());

//		p0.setLayout(null);
//		p0.setBounds(0, 0, 850, 1050);
//		p0.add(anim);
//		p0.add(p2);
//		p0.add(p3);

//		anim.setBounds(0, 0, 500, 1000);
//		anim.setBackground(Color.gray);
//		anim.setLayout(null);

//		p2.setBounds(510, 0, 320, 190);
//		p2.setLayout(new BorderLayout());
//
//		p2.add(l1, BorderLayout.NORTH);
//		p2.add(slider, BorderLayout.CENTER);
//		p2.setBackground(null);
//		p2.setOpaque(false);

//		p3.setBounds(510, 200, 320, 600);
//		p3.setBackground(Color.blue);
//		p3.setLayout(new GridLayout(4, 2));
//		for (int i = 0; i < 8; i++) {
//			bt[i] = new JButton();
//			icon[i] = new ImageIcon(i + ".jpg");
//			bt[i].setIcon(icon[i]);
//			p3.add(bt[i]);
//		}

//		l1.setFont(new Font("宋体", Font.BOLD, 50));
//		l1.setBackground(null);
//		l1.setOpaque(false);

//		slider.setBackground(null);
//		slider.setOpaque(false);

		parts[0] = new Part(part0);
		parts[1] = new Part(part1);
		parts[2] = new Part(part2);
		parts[3] = new Part(part3);
		parts[4] = new Part(part4);
		parts[5] = new Part(part5);
		parts[6] = new Part(part6);
		parts[7] = new Part(part7);
		
//		bt[0].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Show s1 = new Show(parts[0], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
//		bt[1].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Show s1 = new Show(parts[1], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
//		bt[2].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Show s1 = new Show(parts[2], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
//		bt[3].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Show s1 = new Show(parts[3], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
//		bt[4].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Show s1 = new Show(parts[4], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
//		bt[5].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Show s1 = new Show(parts[5], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
//		bt[6].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Show s1 = new Show(parts[6], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
//		bt[7].addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Random random=new Random();
//				count++;
//				Show s1 = new Show(parts[random.nextInt(7)], anim);
//				Thread t1 = new Thread(s1);
//				anim.requestFocus();
//				t1.start();
//			}
//		});
		while(true)
		{
			if(threadstop==true)break;
			if(Thread.activeCount()==1)
			{
				Random random=new Random();
				count++;
				Show s1 = new Show(parts[random.nextInt(7)], anim);
				Thread t1 = new Thread(s1);
				anim.requestFocus();
				t1.start();
			}
		}
	}
	
//	static boolean setallenable(boolean t) {
//		for (int i = 0; i < 8; i++) {
//			bt[i].setEnabled(t);
//		}
//		return t;
//	}
}
