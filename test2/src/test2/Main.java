package test2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class Main 
{
	static int ts[][],te[][],x[],y[],map[][];
	static int n,m,t;
	static PriorityQueue<Integer> qs=new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return ts[x[o1]][y[o1]]-ts[x[o2]][y[o2]];
		}
		
	});
	static PriorityQueue<Integer> qe=new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return te[x[o1]][y[o1]]-te[x[o2]][y[o2]];
		}
		
	});
	static boolean dfs(int x,int y)
	{
		if(x>n||y>m)return false;
		if(x==n&&y==m)return true;
		else dfs(x, y)
	}
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		m=scanner.nextInt();
		t=scanner.nextInt();
		ts=new int[n+1][m+1];
		te=new int[n+1][m+1];
		map=new int[n+1][m+1];
		x=new int[t+1];
		y=new int[t+1];
		for(int i=1;i<=t;i++)
		{
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			ts[a][b]=scanner.nextInt()-a-b;
			te[a][b]=scanner.nextInt()-a-b;
			x[i]=a;
			y[i]=b;
		}
		for(int i=1;;i++)
		{
			map=new int[n+1][m+1];
			for(int j=1;j<=t;j+=2)
			{
				if(ts[x[j]][y[j]]<=i&&te[x[j]][y[j]]>=i)
				{
					map[x[j]][y[j]]=1;
				}
				dfs(1,1);
			}
		}
	}
}
