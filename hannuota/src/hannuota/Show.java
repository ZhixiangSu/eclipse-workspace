package hannuota;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;


public class Show extends JPanel implements Runnable
{
	@Override
	public void run() 
	{
		
		Hannuota.frame.remove(Hannuota.p0);
		Hannuota.frame.add(Hannuota.show);
		Hannuota.frame.repaint();
		Hannuota.frame.setSize(this.getWidth()+20, this.getHeight()+50);
		// TODO Auto-generated method stub
		
	}
	static int height,width,plateheight=50;
	static Plate plates[];
	static Plateform plateform[]=new Plateform[3];
	static ArrayList<Movement> movements=new ArrayList<Movement>();
	Thread th1;
	public Show(int number) {
		// TODO Auto-generated constructor stub
		this.setSize(new Dimension(240+number*160,50*number*5/4));
		this.setLayout(null);
		height=this.getHeight();
		width=this.getWidth();
		plates=new Plate[number+1];
		plateform[0]=new Plateform(0,width,height);
		plateform[1]=new Plateform(1,width,height);
		plateform[2]=new Plateform(2,width,height);
		for(int i=1;i<=number;i++)
		{
			plates[i]=new Plate(50, 50+20*i);
			Movement move=new Movement();
			move.s=-1;
			move.e=0;
			move.num=i;
			movements.add(move);
		}
		startmove(number,0,1);
		return;
	}
	public void startmove(int num,int s,int e)
	{
		if(num<=0)return;
		startmove(num-1, s, 3-e-s);
		Movement move=new Movement();
		move.s=s;
		move.e=e;
		move.num=num;
		movements.add(move);
		startmove(num-1, 3-e-s,e);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRoundRect(0, height*4/5, width, height/5, 20, 20);
		g.fillRect(width/4-5,plateheight, 10, height-plateheight);
		g.fillRect(width/4*2-5,plateheight, 10, height-plateheight);
		g.fillRect(width/4*3-5,plateheight, 10, height-plateheight);
	}
}
