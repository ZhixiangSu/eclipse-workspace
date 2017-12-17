package spfa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main 
{
	static int first[],next[],s[],e[],v[],dis[],vis[];
	static Queue<Integer> queue=new LinkedList<Integer>();
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		first=new int[n+1];
		next=new int[m+1];
		s=new int[m+1];
		e=new int[m+1];
		v=new int[m+1];
		for(int i=1;i<=m;i++)
		{
			s[i]=scan.nextInt();
			e[i]=scan.nextInt();
			v[i]=scan.nextInt();
			if(first[s[i]]==0)
			{
				first[s[i]]=i;
			}
			else 
			{
				int j=first[s[i]];
				while(next[j]!=0)
				{
					j=next[j];
				}
				next[j]=i;
			}
		}
		dis=new int[n+1];
		vis=new int[n+1];
		for(int i=2;i<=n;i++)
		{
			dis[i]=1000000;
		}
		queue.add(1);
		vis[1]=1;
		while(!queue.isEmpty())
		{
			int now=queue.poll();
			for(int i=first[now];i!=0;i=next[i])
			{
				if(dis[now]+v[i]<dis[e[i]])
				{
					dis[e[i]]=dis[now]+v[i];
					queue.add(e[i]);
				}
			}
		}
		System.out.println();
	}
}
/*
7 12
1 2 24
1 3 8
1 4 15
2 5 6
3 5 7
3 6 3
4 7 4
5 7 9
6 4 5
6 5 2
6 7 3
7 2 3
 */
