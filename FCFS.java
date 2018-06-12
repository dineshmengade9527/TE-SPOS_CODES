import java.util.*;
public class FCFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Vector <String> pname = new Vector() ;
		 Vector <Integer> patime = new Vector() ;
		 Vector <Integer> pbtime = new Vector() ;
		
		 Scanner s = new Scanner(System.in);
		 
		 String c;
		 int count=1;
		do{
			pname.add("p"+count);
			
			 System.out.println("Enter process arrival time for p"+count+": ");			 
			 patime.add(s.nextInt());
			 
			 System.out.println("Enter process burst time for p"+count+": ");			 
			 pbtime.add(s.nextInt());
			 
			 System.out.println("Add new process(y/n):");
			 c=s.next();
			  
			 count++;
		 }while(c.equals("y"));
		
		for(int i=0;i<patime.size()-1;i++)
		{
			for(int j=i+1;j<patime.size();j++)
			{
				if(patime.get(i)>patime.get(j))
				{
					int temp=patime.get(i);
					patime.set(i, patime.get(j));
					patime.set(j,temp);
					
					int temp2=pbtime.get(i);
					pbtime.set(i, pbtime.get(j));
					pbtime.set(j,temp2);
					
					String temp3=pname.get(i);
					pname.set(i, pname.get(j));
					pname.set(j,temp3);
				}
			}
		}
		
		
		int wait[] =  new int[patime.size()];
		int turnaround [] = new int[patime.size()];
		wait[0]=0;
		int wait_tot = 0;
		int turn_tot=0;
		for (int i = 1; i<patime.size();i++)
		{
			wait[i] = wait[i-1] + pbtime.get(i-1) - patime.get(i);
			wait_tot = wait_tot + wait[i];
			turnaround[i] =  wait[i] + pbtime.get(i);
			turn_tot = turn_tot + turnaround[i];
		}
			
		float avg_wait = (float)wait_tot/patime.size();
		float avg_turn = (float)turn_tot/patime.size();
		
		System.out.println("Pname Arrival Burst Waiting Turnaround");
		for(int i=0;i<patime.size();i++)
		{
			System.out.println(pname.get(i)+"\t"+patime.get(i)+"\t"+pbtime.get(i)+ "\t" + wait[i] + "\t" + turnaround[i]);
		}
		
		System.out.println("Avg waiting time is : "+avg_wait);
		System.out.println("Avg Turnaround time is : "+avg_turn);
	}

}

/*
OUTPUT

Enter process arrival time for p1: 
12
Enter process burst time for p1: 
3
Add new process(y/n):
y
Enter process arrival time for p2: 
9
Enter process burst time for p2: 
5
Add new process(y/n):
y
Enter process arrival time for p3: 
5
Enter process burst time for p3: 
5
Add new process(y/n):
y
Enter process arrival time for p4: 
1
Enter process burst time for p4: 
5
Add new process(y/n):
y
Enter process arrival time for p5: 
15
Enter process burst time for p5: 
5
Add new process(y/n):
n

p4 1 5
p3 5 5
p2 9 5
p1 12 3
p5 15 5

*/
