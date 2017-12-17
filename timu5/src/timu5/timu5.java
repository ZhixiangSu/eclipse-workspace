package timu5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class timu5 
{
	static Student students[]=new Student[10000];
	static int num=0;
	public static void addStudent(int x)
	{
		try {
			FileInputStream fileInputStream=new FileInputStream("S"+x+".txt");
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String s;
			//输入：
			//学号 姓名
			while((s=bufferedReader.readLine())!=null)
			{
				int repeat=0;
				String t[]=s.split(" ");
				for(int i=1;i<=num;i++)
				{
					if(students[i].stuNum.equals(t[0]))
					{
						repeat=1;
						break;
					}
				}
				if(repeat==1)continue;
				students[++num]=new Student();
				students[num].setNum(t[0]);
				students[num].setName(t[1]);
			}
			fileInputStream=new FileInputStream("C"+x+".txt");
			inputStreamReader=new InputStreamReader(fileInputStream);
			bufferedReader=new BufferedReader(inputStreamReader);
			// 学号
			//课程数
			//每个课程名称 总分
			while((s=bufferedReader.readLine())!=null)
			{
				for(int i=1;i<=num;i++)
				{
					if(students[i].stuNum.equals(s))
					{
						int num2=Integer.parseInt(bufferedReader.readLine());
						for(int j=1;j<=num2;j++)
						{
							s=bufferedReader.readLine();
							String t[]=s.split(" ");
							students[i].addSubject(t[0],Integer.parseInt(t[1]));
						}
					}
				}
			}
			fileInputStream=new FileInputStream("A"+x+".txt");
			inputStreamReader=new InputStreamReader(fileInputStream);
			bufferedReader=new BufferedReader(inputStreamReader);
			// 学号
			//课程数
			//每个课程名称 得分
			while((s=bufferedReader.readLine())!=null)
			{
				for(int i=1;i<=num;i++)
				{
					if(students[i].stuNum.equals(s))
					{
						int num2=Integer.parseInt(bufferedReader.readLine());
						for(int j=1;j<=num2;j++)
						{
							s=bufferedReader.readLine();
							String t[]=s.split(" ");
							students[i].addScore(t[0],Integer.parseInt(t[1]));
						}
					}
				}
			}
			fileInputStream.close();
			inputStreamReader.close();
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("File not Found");
		}
	}
	static void sortByGPA(int s,int e)
	{
		if(s>=e)return;
		int mid=s;
		for(int i=s;i<e;i++)
		{
			if(students[i].GPA>students[e].GPA)
			{
				Student temp=students[i];
				students[i]=students[mid];
				students[mid]=temp;
				mid++;
			}
		}
		Student temp=students[e];
		students[e]=students[mid];
		students[mid]=temp;
		sortByGPA(s, mid-1);
		sortByGPA(mid+1, e);
	}
	public static void main(String args[])
	{
		addStudent(1);
		for(int i=2;i<=3;i++)
		{
			addStudent(i);
		}
		for(int i=1;i<=num;i++)
		{
			students[i].getGPA();
		}
		sortByGPA(1,num);
		for(int i=1;i<=num;i++)
		{
			System.out.println(students[i].stuNum+" "+students[i].stuName+" "+students[i].getGPA());
		}
	}
		
}
