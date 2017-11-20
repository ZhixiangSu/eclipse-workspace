package test;

import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		int n,m;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		int num[]=new int[n+1],sum[]=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			num[i]=scan.nextInt();
			sum[i]=num[i]+sum[i-1];
		}
		for(int i=1;i<=m;i++)
		{
			int x=scan.nextInt();
			int s=scan.nextInt();
			int e=scan.nextInt();
			if(x==1)
			{
				int d=0;
				int v=scan.nextInt();
				for(int j=s;j<=e;j++)
				{
					if(num[j]%v==0)
					{
						d+=num[j]-num[j]/v;
						num[j]/=v;
					}
					sum[j]-=d;
				}
				for(int j=e+1;j<=n;j++)
				{
					sum[j]-=d;
				}
			}
			else 
			{
				System.out.println(sum[e]-sum[s-1]);
			}
		}
	}
}