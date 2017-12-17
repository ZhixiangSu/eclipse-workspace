package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main 
{
	static String settitle(String title)
	{
		StringTokenizer stringTokenizer=new StringTokenizer(title," ");
		int num=stringTokenizer.nextToken().length();
		title="<h"+num+">"+stringTokenizer.nextToken()+"</h"+num+">";
		return title;
	}
	static String setitem(String item)
	{
		StringTokenizer stringTokenizer=new StringTokenizer(item," ");
		stringTokenizer.nextToken();
		item="<li>"+stringTokenizer.nextToken()+"</li>";
		return item;
	}
	static String setemp(String line)
	{
		StringTokenizer stringTokenizer=new StringTokenizer(line,"_");
		int emp=0;
		String s=stringTokenizer.nextToken();
		if(!stringTokenizer.hasMoreTokens())return line;
		while(stringTokenizer.hasMoreTokens())
		{
			if(emp==0)
			{
				s=s+"<em>"+stringTokenizer.nextToken();
				emp=1;
			}
			else 
			{
				s=s+"</em>"+stringTokenizer.nextToken();
				emp=0;
			}
		}
		return s;
	}
	static String sethtml(String line)
	{
		String s3=new String(),s4=new String();
		String s=new String(),s2=new String();
		int vis=0;
		int x1=0,x2=0;
		for(int i=0;i<line.length();i++)
		{
			if(line.charAt(i)==']')
			{
				x1=0;
				vis=1;
			}
			else if(line.charAt(i)==')')
			{
				x2=0;
				vis=1;
				s4+=line.substring(i+1,line.length());
			}
			if(x1==1)s+=line.charAt(i);
			if(x2==1)s2+=line.charAt(i);
			if(line.charAt(i)=='[')
			{
				s3+=line.substring(0, i);
				x1=1;
				vis=1;
			}
			else if(line.charAt(i)=='(')
			{
				x2=1;
				vis=1;
			}
		}
		if(vis==1)return s3+"<a href=\""+s2+"\">"+s+"</a>"+s4;
		else return line;
	}
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		String line;
		int startp=0,startul=0;
		int first=0;
		while(scan.hasNextLine())
		{
			line=scan.nextLine();
			if(line.equals(""))
			{
				if (startp == 1)
				{
					System.out.print("</p>");
					startp=0;
				}
				else if(startul==1)
				{
					System.out.println();
					System.out.print("</ul>");
					startul=0;
				}
			}
			if(line.equals(""))
			{
				continue;
			}
			System.out.println();
			if(line.charAt(0)=='#')
			{
				line=settitle(line);
			}
			else if(line.charAt(0)=='*')
			{
				if(startul==0)System.out.println("<ul>");
				line=setitem(line);
				startul=1;
			}
			else if(startp==0)
			{
				System.out.print("<p>");
				startp=1;
			}
			line=setemp(line);
			line=sethtml(line);
			System.out.print(line);
		}
		if (startp == 1) {
			System.out.print("</p>");
			startp = 0;
		}
	}
}
