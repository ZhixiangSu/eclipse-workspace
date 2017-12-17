package hannuota;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.sun.glass.ui.TouchInputSupport;

public class Show extends JPanel implements Runnable
{
	@Override
	public void run() 
	{
		
		hannuota.frame.remove(hannuota.p0);
		hannuota.frame.add(hannuota.show);
		this.repaint();
		// TODO Auto-generated method stub
		
	}
	static int height,width;
	public Show() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(1000, 500));
		height=this.getHeight();
		width=this.getWidth();
	}
	public void draw(Graphics g)
	{
		g.drawRoundRect(height*4/5, 0, width, height/5, 20, 20);
		g.drawRect(width/4,20, 10, height);
		g.drawRect(width/4*2,20, 10, height);
		g.drawRect(width/4*3,20, 10, height);
	}
}
