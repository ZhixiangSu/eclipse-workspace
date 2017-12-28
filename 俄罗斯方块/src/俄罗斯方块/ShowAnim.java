package ¶íÂÞË¹·½¿é;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ShowAnim extends JPanel implements Cloneable
{
	public static boolean picture[][];
	public static Part part;
	public static Square square[][];
	public static int rows = 0, cols = 0;
	public static int x, y;
	public static int speed = 300;
	public static boolean control=true;
	static ImageIcon icon=new ImageIcon("fangkuai.jpg");
//	public void paintComponent(Graphics g)
//	{
//		ImageIcon frameback=new ImageIcon("beijing2.jpg");
//		g.drawImage(frameback.getImage(), 0, 0,this);
//	}
	public ShowAnim(int rows,int cols) {
		// TODO Auto-generated constructor stub
		super.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
		picture=new boolean[rows+5][cols];
		square=new Square[rows+5][cols];
		this.rows=rows;
		this.cols=cols;
		for(int i=0;i<rows+5;i++)
		{
			for(int j=0;j<cols;j++)
			{
				square[i][j]=new Square(j*50, (i-5)*50,icon);
				this.add(square[i][j]);
			}
		}
		shownow1();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(part!=null&&control)
				{
					int code = e.getKeyCode();
					if (code == KeyEvent.VK_LEFT&&x>0) {
						int rigid=0;
						for(int i=0;i<part.picture.length;i++)
						{
							if(picture[i+y][x-1]&&part.picture[i][0])rigid=1;
						}
						if(rigid==0)x--;
					} else if (code == KeyEvent.VK_RIGHT&&x+part.picture[0].length<cols) {
						int rigid=0;
						for(int i=0;i<part.picture.length;i++)
						{
							if(picture[i+y][x+part.picture[0].length]&&part.picture[i][part.picture[0].length-1])rigid=1;
						}
						if(rigid==0)
						x++;
					} 
					else if (code == KeyEvent.VK_UP) {
						int rigid=0;
						boolean part2[][]=part.rotate();
						for(int i=0;i<part2.length;i++)
						{
							for(int j=0;j<part2[i].length;j++)
							{
								if(i+y>=rows+4||j+x>=cols||(part2[i][j]==true&&picture[i+y][j+x]==true))
								{
									rigid=1;
								}
							}
						}
						if(rigid==0)
						part.picture=part2;
					} 
					shownow2();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override	
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void addpart(Part p,Analyse analyse) {
		this.part = (Part) p.clone();
		x = cols / 2 - 2;
		y = 4;
		partdown(analyse);
		getstart();
		x = 0;
		y = 0;
	}
	public void addpart(Part p,Analyse analyse,int x1,int y1) {
		this.part = (Part) p.clone();
		x = x1;
		y = y1;
		partdown(analyse);
		getstart();
		x = 0;
		y = 0;
	}
	public void doanalyse(Analyse analyse)
	{
		while(analyse!=null&&analyse.actions[y]!=null&&!analyse.actions[y].action.isEmpty())
		{
			int q=analyse.actions[y].action.poll();
			int code = -1;
			if(q==1)code=KeyEvent.VK_LEFT;
			else if(q==2)code=KeyEvent.VK_RIGHT;
			else if(q==0)code=KeyEvent.VK_UP;
			if(part!=null)
			{
				if (code == KeyEvent.VK_LEFT&&x>0) {
//					int rigid=0;
//					for(int i=0;i<part.picture.length;i++)
//					{
//						if(picture[i+y][x-1]&&part.picture[i][0])rigid=1;
//					}
//					if(rigid==0)
						x--;
				} else if (code == KeyEvent.VK_RIGHT&&x+part.picture[0].length<cols) {
//					int rigid=0;¡¤
//					for(int i=0;i<part.picture.length;i++)
//					{
//						if(picture[i+y][x+part.picture[0].length]&&part.picture[i][part.picture[0].length-1])rigid=1;
//					}
//					if(rigid==0)
					x++;
				} 
				else if (code == KeyEvent.VK_UP) {
					int rigid=0;
					boolean part2[][]=part.rotate();
//					for(int i=0;i<part2.length;i++)
//					{
//						for(int j=0;j<part2[i].length;j++)
//						{
//							if(i+y>=rows+4||j+x>=cols||(part2[i][j]==true&&picture[i+y][j+x]==true))
//							{
//								rigid=1;
//							}
//						}
//					}
//					if(rigid==0)
					part.picture=part2;
				} 
				shownow2();
			}
		}
//		if(!analyse.rota.isEmpty())
//		{
//			int r1=analyse.rota.poll();
//			while(r1>0)
//			{
//				int rigid=0;
//				boolean part2[][]=part.rotate();
//				for(int i=0;i<part2.length;i++)
//				{
//					for(int j=0;j<part2[i].length;j++)
//					{
//						if(i+y>=rows+4||j+x>=cols||(part2[i][j]==true&&picture[i+y][j+x]==true))
//						{
//							rigid=1;
//						}
//					}
//				}
//				if(rigid==0)
//				part.picture=part2;
//				shownow2();
//				r1--;
//			}
//		}
		
	}
	public void partdown(Analyse analyse) {

		control=true;
		while (control) {
			doanalyse(analyse);
			shownow2();
			y++;
			for (int i = 0; i < part.picture.length; i++) {
				for (int j = 0; j < part.picture[i].length; j++) {
					if (part.picture[i][j] == true && (i + y == rows + 5 || picture[i + y][j + x] == true)) {
						control=false;
					}
				}
			}
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		y--;
		for (int i = 0; i < part.picture.length && i + y < rows + 5; i++) {
			for (int j = 0; j < part.picture[i].length && j + x < cols; j++) {
				picture[i + y][j + x] = part.picture[i][j] || picture[i + y][j + x];
			}
		}
		shownow1();
		part = null;
	}

	public void getstart() {
		int move = 1;
		while (move == 1) {
			move = 0;
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
				// TODO: handle exception
			}
			for (int i = rows + 4; i >= 1; i--) {
				int alltrue = 1;
				for (int j = 0; j < cols; j++) {
					if (!picture[i][j])
						alltrue = 0;
				}
				if (alltrue == 1) {
					move = 1;
					for (int j = 0; j < cols; j++) {
						picture[i][j] = picture[i - 1][j];
						if(i!=1)picture[i - 1][j] = true;
					}
				}
			}
			shownow1();
		}
	}

	public void shownow1() {
		for (int i = 0; i < rows + 5; i++) {
			for (int j = 0; j < cols; j++) {
				square[i][j].setVisible(picture[i][j]);
			}
		}
		this.repaint();
	}

	public void shownow2() {
		for (int i = 0; i < rows + 5; i++) {
			for (int j = 0; j < cols; j++) {
				square[i][j].setVisible(picture[i][j]);
			}
		}
		for (int i = 0; i < part.picture.length && i + y < rows + 5; i++) {
			for (int j = 0; j < part.picture[i].length && j + x < cols ; j++) {
				square[i + y][j + x].setVisible(picture[i + y][j + x] || part.picture[i][j]);
			}
		}
		this.repaint();
	}
	public Object clone() {
		// TODO Auto-generated constructor stub
//		Part p1=new Part(picture);
//		return p1;
		ShowAnim p1 = null;
		try {
			p1=(ShowAnim) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p1;
	}
}
