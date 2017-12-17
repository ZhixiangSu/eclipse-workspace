package timu5;

public class Student {
	String stuNum,stuName;
	int creditScoreTotal,number,creditTotal;double GPA;
	Subject subject[]=new Subject[100];int subjectNum=0;
	void setName(String name)
	{
		stuName=name;
	}
	void setNum(String num)
	{
		stuNum=num;
		this.number=Integer.parseInt(num);
	}
	double getGPA()
	{
		GPA=(double)creditScoreTotal/(double)creditTotal;
		return GPA;
	}
	void addSubject(String name,int totalscore)
	{
		subjectNum++;
		subject[subjectNum]=new Subject(name,totalscore);
		creditTotal+=totalscore;
	}
	void addScore(String name,int score)
	{
		for(int i=1;i<=subjectNum;i++)
		{
			if(subject[subjectNum].equals(name))
			{
				subject[subjectNum].addscore(score);
			}
		}
		creditScoreTotal+=score;
	}
}
