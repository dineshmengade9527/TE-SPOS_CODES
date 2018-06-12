/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prioa;

import java.util.Scanner;

/**
 *
 * @author SHUBHAM
 */
public class PrioA {

    Scanner sc = new Scanner(System.in);
	int process[][] = new int[20][8];
	int n;
	int time=0;
        float awt=0,atat=0;
	
	public void initialise()
	{
		System.out.println("Enter no. of processes : ");
		n = sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			process[i][0] = i+1;
			System.out.println("Enter arrival time of process "+(i+1)+" : ");
			process[i][1] = sc.nextInt();
			
			System.out.println("Enter burst time of process "+(i+1)+" : ");
			process[i][2] = sc.nextInt();
                        process[i][4]=process[i][2];
			
			System.out.println("Enter priority of process "+(i+1)+" : ");
			process[i][3] = sc.nextInt();
		}
	}
	
	public void act(int fa)
	{
		int count=0;
               
		while(process[fa][2]!=0)
		{
			time++;
                        count++;
			process[fa][2]--;
		}
                System.out.println("From time : "+(time-count)+" to "+time+" : "+"process id : "+process[fa][0]);
                process[fa][7]=time;//completion time
                process[fa][6]=process[fa][7]-process[fa][1];//tat=ct-at
                process[fa][5]=process[fa][6]-process[fa][4];//wt=tat-bt
		int next = elapsed(time);
		act(next);
	}
	
	public void firstat()
	{
		int m = 0;
		for(int i=0;i<n;i++)
		{
			if(process[i][1] < process[m][1])
			{
				m=i;
			}
		}
		int minat = m;
		
		act(minat);
	}
	
	public int elapsed(int time)
	{
		int m=0;
		int f=0;
		
		//Code recognising completion
		for(int i=0;i<n;i++)
		{
			if(process[i][2]==0)
			{
				f=1;
				continue;
			}
			else
			{
				f=0;
				break;
			}
		}
		
		if(f==1)
			display();
		
		for(int i=0;i<n;i++)
		{
			if(process[i][2]!=0)
			{	
				m=i;
				break;
			}
		}
		//System.out.println("M "+m+" bt "+process[m][2]);
		//Error present below
		for(int i=0;i<n;i++)
		{
			if(time >= process[i][1])
			{
				if((process[i][3] >= process[m][3]) && process[i][2]!=0) 
				{
					m=i;
				}
			}
		}
		System.out.println("M "+m+" bt "+process[m][2]);
		return m;
	}
	
	
	
	public void display()
	{
		System.out.println("PID  AT  BT  P   wt    tat");
		for(int i=0;i<n;i++)
		{
                    awt=awt+process[i][5];
                    atat=atat+process[i][6];
			System.out.println(process[i][0]+"    "+process[i][1]+"    "+process[i][4]+"   "+process[i][3]+"   "+process[i][5]+"   "+process[i][6]);
		}
                System.out.println("avrage waiting time : "+(awt/n));
                System.out.println("avrage tat : "+(atat/n));
                System.exit(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ACTIVE HIGH");
		PrioA p = new PrioA();
		p.initialise();
		
		p.firstat();
                p.display();
        }

    
}
