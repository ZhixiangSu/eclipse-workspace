package timu1;

import java.util.Scanner;

public class timu1 
{
	static int a[]=new int [100000001],start=0;
	static void binary(int n)
	{
		if(n>1)
		{
			binary(n/2);
		}
		System.out.print(n%2);
	}
	static void prime(int n)
	{
		for(int i=2;i<=n;i++)
		{
			if(a[i]==0&&n%i==0)
			{
				if(start!=0)System.out.print(",");
				start=1;
				System.out.print(i);
				prime(n/i);
				for(int j=i;j<=n;j+=i)
				{
					a[j]=1;
				}
				break;
			}
		}
	}
	public static void main(String args[])
	{
		int n;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		binary(n);
		System.out.print("#");
		prime(n);
	}
}
