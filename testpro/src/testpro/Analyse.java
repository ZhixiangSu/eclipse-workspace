package testpro;

import java.awt.Robot;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.ImageIcon;

public class Analyse 
{
	Actions actions[];
	int check[][];
	int vis[][];
	int value[][][];
	ShowAnim anim2;
	static int valueh=247,valuespace=559,valuedelete=453,valuey=143,valueup=31;
	public Analyse(ShowAnim anim,Part part) 
	{
		// TODO Auto-generated constructor stub
		anim2=(ShowAnim) anim.clone();
		check=new int[anim2.picture.length][anim2.picture[0].length];
		vis=new int[anim2.picture.length][anim2.picture[0].length];
		value=new int[4][check.length][check[0].length];
		actions=new Actions[check.length];
		for(int k=0;k<4;k++)
		{
			for(int i=0;i<check.length;i++)
			{
				for(int j=0;j<check[0].length;j++)
				{
					if(checkpart(i,j,part))
					{
						check[i][j]=check[i][j]*5+k+1;
						value[k][i][j]=getvalue(i, j, part);
					}
				}
			}
			part.picture=part.rotate();
		}
		dfs(4, anim2.cols/2-2);
		int minx=0,miny=0,mink=0,minvalue=100000;
		for(int k=0;k<4;k++)
		{
			for(int i=0;i<check.length;i++)
			{
				Random random=new Random();
				int rand=random.nextInt(check[0].length);
				for(int j=rand;j!=(rand+check[0].length-1)%check[0].length;j=(j+1)%check[0].length)
				{
					if(vis[i][j]==0)
					{
						check[i][j]=0;
					}
					else 
					{
						if(value[k][i][j]<=minvalue)
						{
							boolean check1=false;
							int num1=check[i][j];
							while(!check1&&num1!=0)
							{
								if(num1%5==k+1)
								{
									check1=true;
								}
								num1/=5;
							}
							if(check1)
							{
								mink=k;
								miny=i;
								minx=j;
								minvalue=value[k][i][j];
							}	
						}
					}
				}
			}
		}
		actions[3]=new Actions();
		check[miny][minx]=mink+1;
		
		getway(4,anim2.cols/2-2,miny,minx);
		int r=check[4][anim2.cols/2-2]%5-1;
		for(int i=0;i<r;i++)
		{
			actions[4].action.add(0);
		}
//		System.out.println(minx+" "+miny+" "+mink);
//		System.out.println();
		if(minx==0&&miny==0&&mink==0)
		{
			test.sum+=MainUI.count;
			if(MainUI.count>test.max)
			{
				test.max=MainUI.count;
				
			}
			test.a[test.num++]=MainUI.count;
			MainUI.threadstop=true;
		}
		if(MainUI.count>10000)
		{
			MainUI.threadstop=true;
			test.sum+=10000;
		}
	}
	private boolean getway(int y,int x,int toy,int tox)
	{
		actions[y]=new Actions();
		if(toy==y&&tox==x)
		{
			return true;
		}
		if(y+1<check.length&&vis[y+1][x]==1&&getway(y+1,x,toy,tox))
		{
			
			int r=check[y+1][x]%5-check[y][x]%5;
			if(r<0)r+=4;
			for(int i=0;i<r;i++)
			{
				actions[y].action.add(0);
			}
			actions[y].action.add(4);
			
			return true;
		}
		for(int j=1;j<check.length;j++)
		{
			boolean stopl=false,stopr=false;
			if(stopl==false)
			{
				if(y+1<check.length&&x-j>=0&&vis[y+1][x-j]==1&&getway(y+1,x-j,toy,tox))
				{
					
					int r=check[y+1][x-j]%5-check[y][x]%5;
					if(r<0)r+=4;
					for(int i=0;i<r;i++)
					{
						actions[y].action.add(0);
					}
					for(int k=1;k<=j;k++)
					{
						actions[y].action.add(1);
					}
					return true;
				}
				else stopl=true;
			}
			if(stopr==false)
			{
				if(y+1<check.length&&x+j<check[0].length&&vis[y+1][x+j]==1&&getway(y+1,x+j,toy,tox))
				{
					
					int r=check[y+1][x+j]%5-check[y][x]%5;
					if(r<0)r+=4;
					for(int i=0;i<r;i++)
					{
						actions[y].action.add(0);
					}
					for(int k=1;k<=j;k++)
					{
						actions[y].action.add(2);
					}
					return true;
				}
				else stopr=true;
			}
			
		}
//		if(y+1<check.length&&x-1>=0&&vis[y+1][x-1]==1&&getway(y+1,x-1,toy,tox))
//		{
//			
//			int r=check[y+1][x-1]%5-check[y][x]%5;
//			if(r<0)r+=4;
//			for(int i=0;i<r;i++)
//			{
//				actions[y].action.add(0);
//			}
//			actions[y].action.add(1);
//			return true;
//		}
//		else if(y+1<check.length&&vis[y+1][x]==1&&getway(y+1,x,toy,tox))
//		{
//			
//			int r=check[y+1][x]%5-check[y][x]%5;
//			if(r<0)r+=4;
//			for(int i=0;i<r;i++)
//			{
//				actions[y].action.add(0);
//			}
//			actions[y].action.add(4);
//			
//			return true;
//		}
//		if(y+1<check.length&&x+1<check[0].length&&vis[y+1][x+1]==1&&getway(y+1,x+1,toy,tox))
//		{
//			
//			int r=check[y+1][x+1]%5-check[y][x]%5;
//			if(r<0)r+=4;
//			for(int i=0;i<r;i++)
//			{
//				actions[y].action.add(0);
//			}
//			actions[y].action.add(2);
//			return true;
//		}
		return false;
	}
	private int getvalue(int y, int x,Part part) {
		// TODO Auto-generated method stub
		int value1=0;
		int h[]=new int[check.length];
		boolean upspace[]=new boolean[check[0].length];
		int depth[]=new int[check[0].length];
		for (int i = 1; i <check.length; i++) {
			for (int j = 0; j <check[0].length; j++) {
				if(!anim2.picture[i][j]&&anim2.picture[i-1][j])
				{
					value1+=valuespace;
				}
				if(anim2.picture[i][j])
				{
					h[i]++;
					upspace[j]=true;
					
				}
				if(i-y>=0&&j-x>=0&&i-y<part.picture.length&&j-x<part.picture[0].length)
				{
					if(part.picture[i-y][j-x])
					{
						h[i]++;
						upspace[j]=true;
					}
				}
			}
			if(h[i]==0){
				upspace=new boolean[check[0].length];
			}
			for (int j = 0; j <check[0].length; j++) {
				if(!upspace[j]&&(j==0||upspace[j-1])&&(j==check[0].length-1||upspace[j+1])&&upspace[j]==false)
				{
					depth[j]++;
				}
			}
		}
		int depthsum=0;
		for (int j = 0; j <check[0].length; j++) {
			depthsum+=depth[j];
		}
		for (int i = 0; i < part.picture.length && i + y < check.length; i++) {
			for (int j = 0; j < part.picture[i].length &&j+x<check[0].length; j++) 
			{
				if(part.picture[i][j]&&i>0&&anim2.picture[i-1+y][j+x])
				{
					value1-=valuespace;
				}
				if(i+1+y<check.length&&part.picture[i][j]&&!anim2.picture[i+1+y][j+x]&&(i+1>=part.picture.length||!part.picture[i+1][j]))
				{
					value1+=valuespace;
				}
			}
		}
		int h1=0;
		while(h1<check.length&&h[h1]==0)
		{
			h1++;
		}
		for(int i=0;i<check.length;i++)
		{
			if(h[i]==anim2.cols)
			{
				value1-=valuedelete;
			}
		}
		h1=check.length-h1+1;
		value1+=h1*valueh;
		value1+=(check.length-y)*valuey;
		value1+=depthsum*valueup;
		return value1;
	}
	private void dfs(int i, int j) {
		if(vis[i][j]==0&&check[i][j]!=0)
		{
			vis[i][j]=1;
			if(i+1<anim2.rows+5)
			{
				boolean stopr=false,stopl=false;
				dfs(i+1,j);
				for(int k=1;k<=check.length;k++)
				{
					if(j+k<anim2.cols&&check[i+1][j+k]!=0&&stopr==false)
					{
						dfs(i+1,j+k);
					}
					else stopr=true;
					if(j-k>=0&&check[i+1][j-k]!=0&&stopl==false) 
					{
						dfs(i+1,j-k);
					}
					else stopl=true;
				}
//				if(j>0)dfs(i+1, j-1);
//				dfs(i+1, j);
//				if(j+1<anim2.cols)dfs(i+1, j+1);
			}
		}
		// TODO Auto-generated method stub
	}
	private boolean checkpart(int y, int x, Part part) 
	{
		// TODO Auto-generated method stub
		for(int i=0;i<part.picture.length;i++)
		{
			for(int j=0;j<part.picture[0].length;j++)
			{
				if(i+y>=anim2.picture.length||j+x>=anim2.picture[0].length||(part.picture[i][j]&&anim2.picture[i+y][j+x]))
				{
					return false;
				}
			}
		}
		return true;
	}
}
