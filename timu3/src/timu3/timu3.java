package timu3;

import java.util.Scanner;

public class timu3 
{
	static int start=1;
	static int month[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static int day[][]=new int[13][100];
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入当前年份:");
		int y=scanner.nextInt();
		System.out.println("输入月份:");
		int m=scanner.nextInt();
		start+=(365%7)*((y-1)%7);
		start+=((y-1)/4)%7;
		start-=((y-1)/100)%7;
		start+=((y-1)/400)%7;
		start%=7;
		if(start==0)
		{
			start+=7;
		}
		if(y%4==0&&y%100!=0)
		{
			month[2]++;
		}
		for(int i=1;i<=12;i++)
		{
			for(int j=1;j<=month[i];j++)
			{
				day[i][start+j-1]=j;
			}
			start=(start+month[i])%7;
		}
		System.out.println("sun\tmon\ttue\twed\tthu\tfri\tsat\t");
		for(int i=0;i<=5;i++)
		{
			for(int j=1;j<=7;j++)
			{
				if(day[m][i*7+j]!=0)System.out.print(day[m][i*7+j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("输入年份:");
		y=scanner.nextInt();
		month[2]=28;
		day=new int[13][100];
		start=1;
		start+=(365%7)*((y-1)%7);
		start+=((y-1)/4)%7;
		start-=((y-1)/100)%7;
		start+=((y-1)/400)%7;
		start%=7;
		if(start==0)
		{
			start+=7;
		}
		if(y%4==0&&y%100!=0)
		{
			month[2]++;
		}
		for(int i=1;i<=12;i++)
		{
			for(int j=1;j<=month[i];j++)
			{
				day[i][start+j-1]=j;
			}
			start=(start+month[i])%7;
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<=5;j++)
			{
				for(int k=1;k<=3;k++)
				{
					if(j==0&&k==1)System.out.println("sun\tmon\ttue\twed\tthu\tfri\tsat\t\tsun\tmon\ttue\twed\tthu\tfri\tsat\t\tsun\tmon\ttue\twed\tthu\tfri\tsat\t\t");
					for(int l=1;l<=7;l++)
					{
						if(day[i*3+k][j*7+l]>0)System.out.print(day[i*3+k][j*7+l]);
						System.out.print("\t");
					}
					System.out.print("\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
