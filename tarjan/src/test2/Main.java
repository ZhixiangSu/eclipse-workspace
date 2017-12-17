package test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int sum=0;
	static int a[],b[],first[],next[];
	static int dfn[],low[],index=0,vis[];
	static int stack[],size=0;
	static void tarjan(int x)
	{
		index++;
		dfn[x]=index;
		low[x]=index;
		size++;
		stack[size]=x;
		vis[x]=1;
		for(int j=first[x];j!=0;j=next[j])
		{
			if(dfn[b[j]]==0)
			{
				tarjan(b[j]);
				if(low[x]>low[b[j]])low[x]=low[b[j]];
			}
			else if(vis[b[j]]==1) {
				if(low[x]>dfn[b[j]])low[x]=dfn[b[j]];
			}
		}
		if(dfn[x]==low[x])
		{
			int num=0;
			while(stack[size]!=x)
			{
				System.out.print(stack[size]);
				vis[stack[size]]=0;
				size--;
			}
			System.out.print(stack[size]);
			vis[stack[size]]=0;
			size--;
			System.out.println();
		}
		
	}
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		a=new int[m+1];b=new int[m+1];first=new int[n+1];next=new int[m+1];
		for(int i=1;i<=m;i++)
		{
			a[i]=scanner.nextInt();
			b[i]=scanner.nextInt();
			if(first[a[i]]==0)
			{
				first[a[i]]=i;
			}
			else {
				int i0=first[a[i]];
				while(next[i0]!=0)
				{
					i0=next[i0];
				}
				next[i0]=i;
			}
		}
		vis=new int[n+1];
		dfn=new int[n+1];
		low=new int[n+1];
		stack=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			if(dfn[i]==0)
			{
				
				tarjan(i);
			}
		}
		System.out.println();
	}
	

}
/*
6 8
1 2
2 3
3 6
2 5
5 1
5 6
1 4
4 5

*/