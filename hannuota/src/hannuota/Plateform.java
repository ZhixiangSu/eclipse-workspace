package hannuota;

import java.util.ArrayList;

public class Plateform
{
	ArrayList<Plate> plates=new ArrayList<Plate>();
	int x,width,height;
	public Plateform(int num,int w,int h) {
		// TODO Auto-generated constructor stub
		x=w/4*(num+1);
		width=w/4;
		height=h;
	}
}
