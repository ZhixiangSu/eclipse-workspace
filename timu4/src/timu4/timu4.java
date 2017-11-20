package timu4;
import java.io.File;
import java.util.Scanner;
public class timu4 {
	public static void main(String args[]) 
	{
		Scanner scan=new Scanner(System.in); 
		String s=scan.next(); 
		dfs(s,0);
	}
	static void dfs(String s,int space) 
	{ 
		File f=new File(s); 
		File[] l=f.listFiles();
		if(l!=null) {
			for(int i=0;i<l.length;i++) 
			{ 
				for(int j=1;j<=space;j++) 
				{ 
					System.out.print(" "); 
				}
				if (l[i].isDirectory()) {
					System.out.print("<d>");
					System.out.println(l[i].getName());
					dfs(l[i].toString(), space + 1);
				} else {
					System.out.print("<f>");
					System.out.println(l[i].getName());
				}
			}
		}
		
	}
}
