package testpro;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel
{
	private static final long serialVersionUID = 1L;
	ImageIcon icon=new ImageIcon("beijing2.jpg");
	public void paintComponent(Graphics g)
	{
		g.drawImage(icon.getImage(),0,0, this);
	}
}
