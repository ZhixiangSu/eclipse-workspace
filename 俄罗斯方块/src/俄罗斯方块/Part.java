package ¶íÂÞË¹·½¿é;

public class Part implements Cloneable
{
	boolean picture[][];
	public Part(boolean a[][]) {
		// TODO Auto-generated constructor stub
		picture=a;
	}
	boolean[][] rotate()
	{
		boolean[][] b1=new boolean[picture[0].length][picture.length];
//		MainUI.anim.x+=picture[0].length/2;
//		MainUI.anim.x-=picture.length/2;
		for(int i=0;i<b1.length;i++)
		{
			for(int j=0;j<b1[i].length;j++)
			{
				b1[i][j]=picture[b1[i].length-1-j][i];
			}
		}
		
		return b1;
	}
	public Object clone() {
		// TODO Auto-generated constructor stub
//		Part p1=new Part(picture);
//		return p1;
		Part p1 = null;
		try {
			p1=(Part) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p1;
	}
}
