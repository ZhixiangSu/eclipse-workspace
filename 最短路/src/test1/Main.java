package test1;

import java.util.Scanner;
public class Main {
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		int a[][]=new int[21][16];
		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=15;j++)
			{
				a[i][j]=scanner.nextInt();
			}
		}
		int b[][]=new int[5][5];
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				b[i][j]=scanner.nextInt();
			}
		}
		int delta=scanner.nextInt()-1;
		int stop=0;int i=1;
		for(;i<=7&&stop==0;i++)
		{
			for(int j=1;j<=4&&stop==0;j++)
			{
				for(int k=1;k<=4&&stop==0;k++)
				{
					if(b[j][k]==1&&(j+k+1>=16||a[j+i+1][k+delta]==1))
					{
						stop=1;
					}
				}
			}
		}
		for(int j=1;j<=4;j++)
		{
			for(int k=1;k<=4;k++)
			{
				a[j+i+1][k+delta]=a[j+i+1][k+delta]&b[j][k];
			}
		}
		for(int k=1;k<=10;k++)
		{
			for(int j=1;j<=15;j++)
			{
				System.out.print(a[k][j]+" ");
			}
			System.out.println();
		}
	}
}
/*
6 9
1 2 1
1 3 12
2 3 9
2 4 3
3 5 5
4 3 4
4 5 13
4 6 15
5 6 4
*/