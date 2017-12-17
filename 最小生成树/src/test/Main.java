package test;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
	static int first[],next[],p[],q[],x[];
	static boolean line[];
	static int parent[];
	public static void addlist(int p,int i)
	{
		if(first[p]==0)
		{
			first[p]=i;
		}
		else 
		{
			int i0=first[p];
			while(next[i0]!=0)
			{
				i0=next[i0];
			}
			next[i0]=i;
		}
	}
	public static int find(int x)
	{
		if(parent[x]==x)return x;
		else
		{
			return parent[x]=find(parent[x]);
		}
	}
	public static void sort(int s,int e)
	{
		if(s>=e)return;
		int mid=s;
		for(int i=s;i<e;i++)
		{
			if(x[i]<x[e])
			{
				int x0=x[mid];
				x[mid]=x[i];
				x[i]=x0;
				int p0=p[mid];
				p[mid]=p[i];
				p[i]=p0;
				int q0=q[mid];
				q[mid]=q[i];
				q[i]=q0;
				mid++;
			}
		}
		int x0=x[mid];
		x[mid]=x[e];
		x[e]=x0;
		int p0=p[mid];
		p[mid]=p[e];
		p[e]=p0;
		int q0=q[mid];
		q[mid]=q[e];
		q[e]=q0;
		sort(s, mid-1);
		sort(mid+1, e);
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		first=new int[n+1];
		next=new int[m+1];
		p=new int[m+1];
		q=new int[m+1];
		x=new int[m+1];
		parent=new int[n+1];
		line=new boolean[2*m+1];
		for(int i=1;i<=m;i++)
		{
			p[i]=scanner.nextInt();
			q[i]=scanner.nextInt();
			x[i]=scanner.nextInt();
		}
		for(int i=1;i<=n;i++)
		{
			parent[i]=i;
		}
		sort(1,m);
		int value=0,linesum=0;
		for(int i=1;linesum<n-1;i++)
		{
			if(find(p[i])!=find(q[i]))
			{
				value+=x[i];
				linesum++;
				parent[find(p[i])]=find(q[i]);
			}
		}
		System.out.println(value);
	}
}
