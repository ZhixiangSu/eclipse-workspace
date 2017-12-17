package test3;

import java.util.Scanner;
public class Main{
	static Hero up,down;
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		up=new Hero();down=new Hero();int now=0;
		int n=scan.nextInt();
		String string;
		for(int i=1;i<=n;i++)
		{
			string=scan.next();
			if(string.equals("summon"))
			{
				int pos=scan.nextInt();
				int attack=scan.nextInt();
				int health=scan.nextInt();
				if(now==0)
				{
					up.add(pos, attack, health);
				}
				else {
					down.add(pos, attack, health);
				}
			}
			else if(string.equals("attack"))
			{
				int pos1=scan.nextInt();
				int pos2=scan.nextInt();
				attack(now,pos1,pos2);
			}
			else if(string.equals("end"))
			{
				now=(now+1)%2;
			}
		}
		if(up.health[0]==0)
		{
			System.out.println(-1);
		}
		else if(down.health[0]==0)
		{
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		System.out.println(up.health[0]);
		int num1=0;
		for(int i=1;i<=7;i++)
		{
			if(up.health[i]!=0)
			{
				num1++;
			}
		}
		System.out.print(num1+" ");
		for(int i=1;i<=num1;i++)
		{
			System.out.print(up.health[i]+" ");
		}
		System.out.println();
		System.out.println(down.health[0]);
		num1=0;
		for(int i=1;i<=7;i++)
		{
			if(down.health[i]!=0)
			{
				num1++;
			}
		}
		System.out.print(num1+" ");
		for(int i=1;i<=num1;i++)
		{
			System.out.print(down.health[i]+" ");
		}
	}
	static void attack(int now,int pos1,int pos2)
	{
		if(now==0)
		{
			up.health[pos1]-=down.attack[pos2];
			down.health[pos2]-=up.attack[pos1];
		}
		else 
		{
			up.health[pos2]-=down.attack[pos1];
			down.health[pos1]-=up.attack[pos2];
		}
		check();
	}
	 static void check() {
		// TODO Auto-generated method stub
		if(up.health[0]<=0||down.health[0]<=0)
		{
			return ;
		}
		for(int i=1;i<7;i++)
		{
			if(up.health[i]<=0)
			{
				for(int j=i;j<7;j++)
				{
					up.health[j]=up.health[j+1];
					up.attack[j]=up.attack[j+1];
				}
				up.health[7]=0;
			}
			if(down.health[i]<=0)
			{
				for(int j=i;j<7;j++)
				{
					down.health[j]=down.health[j+1];
					down.attack[j]=down.attack[j+1];
				}
				down.health[7]=0;
			}
		}
	}
	static class Hero
	{
		int attack[]=new int[8];
		int health[]=new int[8];
		public Hero() {
			// TODO Auto-generated constructor stub
			health[0]=30;
		}
		void add(int pos,int attack,int health)
		{
			for(int i=6;i>=pos;i--)
			{
				this.attack[i+1]=this.attack[i];
				this.health[i+1]=this.health[i];
			}
			this.attack[pos]=attack;
			this.health[pos]=health;
		}
	}
}