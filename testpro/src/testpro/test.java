package testpro;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JFrame;

public class test 
{
	
	static int a[]=new int[1001],max=0,num=1,sum=0;
	public static void main(String args[])
	{
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("result2.txt");
			OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
				sum=0;
				for( int m=1;m<=1000;m++)
				{
					MainUI u1=new MainUI(31);
					MainUI.count = 0;
					MainUI.threadstop=false;
					MainUI.parts= new Part[8];
					MainUI.anim = new ShowAnim(20, 10);
					System.out.println(a[m]);
				}
				sum/=1000;
				outputStreamWriter.write(sum+"\t"+max+"\n");
				System.out.println(sum);

			outputStreamWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
