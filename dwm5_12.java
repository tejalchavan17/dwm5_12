import java.text.DecimalFormat;
import java.util.*;
class dwm6_12
{
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	public static void main(String args[])
    {
        int i,j,t,a=0,p=0,c=0,n,ni,na,no,ci=0,flag=0,flagt=0,x=0,h=0,f;
		Scanner sc=new Scanner(System.in);
        int count[]=new int[50];int unino[]=new int[50];
        float prob[]=new float[50];float rp[]=new float[50];float rl[]=new float[50];
		float pi,pq,rli,li,di,large;
        int pn[]=new int[50];int track[]=new int[50];
		String inc,own,ri,ra;
        String income[]=new String[50];String age[]=new String[50];String ownhouse[]=new String[50];
		String unique[]=new String[50];String uniquey[]=new String[50];
		System.out.println("Enter no. of records:");
		n=sc.nextInt();
		System.out.println("Enter Income records:");
		for(i=0;i<n;i++)
			income[i]=sc.next();
		System.out.println("Enter Age records:");
		for(i=0;i<n;i++)
			age[i]=sc.next();
		System.out.println("Enter Ownhouse records:");
		for(i=0;i<n;i++)
			ownhouse[i]=sc.next();
		System.out.println("Enter unique no. of income records:");
		ni=sc.nextInt();
		System.out.println("Enter unique no. of age records:");
		na=sc.nextInt();
		System.out.println("Enter unique no. of ownhouse records:");
		no=sc.nextInt();
		System.out.println("Enter unique income&age records:");
		for(i=0;i<(ni+na);i++)
			unique[i]=sc.next();
		System.out.println("Enter unique ownhouse records:");
		for(i=0;i<no;i++)
			uniquey[i]=sc.next();
		System.out.println("Enter query to find:");
		System.out.println("Enter income:");
		ri=sc.next();
		System.out.println("Enter age:");
		ra=sc.next();
        for(i=0;i<n;i++)
            track[i]=0;
		for(i=0;i<(ni+na);i++)
        {
            inc=unique[i];
            for(j=0;j<no;j++)
            {
				own=uniquey[j];
				if(ci!=ni)
				{
					for(t=0;t<n;t++)
					{
               			if(income[t].equals(inc)&&ownhouse[t].equals(own))
               			{
                   			c++;
                   			flag=1;
               			}
					}
					count[a]=c;
					c=0;a++;
            	}
				else
				{
					for(t=0;t<n;t++)
					{
               			if(age[t].equals(inc)&&ownhouse[t].equals(own))
               			{
                   			c++;
                   			flag=0;
               			}
					}
					count[a]=c;
					c=0;a++;
				}
       		}
	    	if(flag==1)
	    		ci++;
        }
		a=0;
		System.out.println("---------Count----------");
		for(i=0;i<(ni+na);i++)
		{
			System.out.print(unique[i]+"\t");
			for(j=0;j<no;j++)
			{
				System.out.print(count[a]+"  ");
				a++;
			}
			System.out.println("");
		}	
		c=0;
		for(i=0;i<no;i++)
		{
			for(t=0;t<n;t++)	
			{
				if(ownhouse[t].equals(uniquey[i]))
					c++;	
			}
			unino[i]=c;
			c=0;	
		}
		a=0;
		System.out.println("---------Probability----------");
		for(i=0;i<(ni+na);i++)
		{
			for(j=0;j<no;j++)
			{
				prob[a]=(float)count[a]/unino[j];
				a++;
			}
		}
		a=0;
		for(i=0;i<(ni+na);i++)
		{
			System.out.print(unique[i]+"\t");
			for(j=0;j<no;j++)
			{
				System.out.print(df2.format(prob[a])+"  ");
				a++;
			}
			System.out.println("");
		}
		for(i=0;i<no;i++)
		{
			for(j=0;j<ni;j++)
			{
				if(unique[j].equals(ri))
				{
					flagt=1;
					break;
				}
				if(flagt!=1)
				{
					x=x+2;
				}
			}
			pi=prob[x];
			x=0;
			if(i==1)
				x=1;
			flagt=0;
			for(j=0;j<(ni+na);j++)
			{
				if(unique[j].equals(ra))
				{
					flagt=1;
					break;
				}
				if(flagt!=1)
				{
					x=x+2;
				}
			}
			pq=pi*prob[x];
			rp[h]=pq;
			h++;
			pi=0;
			pq=0;
			x=1;
			flagt=0;
		}
		System.out.println();
		for(i=0;i<no;i++)
		{
			System.out.print("Probability of being "+uniquey[i]+":");
			System.out.println(df2.format(rp[i]));
		}
		for(i=0;i<no;i++)
    	{
    		di=(float)(unino[i])/n;
    		li=(rp[i])*(di);
    		rl[i]=li;
    		li=0;
    	}
		System.out.println();
    	for(i=0;i<no;i++)
		{
			System.out.print("Likelihood of being "+uniquey[i]+":");
			System.out.println(df2.format(rl[i]));
		}
		large=rl[0];
		f=0;
		for(i=1;i<no;i++)
		{
			if(large<rl[i])
			{
				large=rl[i];
				f=i;
			}
		}
		System.out.println("Result");
		System.out.println("Person has "+uniquey[f]+" house.");	
    }
}
        

/* OUTPUT
tejal@ubuntu:~/Desktop$ javac dwm6_12.java
tejal@ubuntu:~/Desktop$ java dwm6_12
Enter no. of records:
11
Enter Income records:
veryhigh high low high veryhigh medium high medium low low high  
Enter Age records:
young medium young medium medium young old medium medium old young
Enter Ownhouse records:
yes yes rented yes yes yes yes rented rented rented yes
Enter unique no. of income records:
4
Enter unique no. of age records:
3
Enter unique no. of ownhouse records:
2
Enter unique income&age records:
low medium high veryhigh old medium young
Enter unique ownhouse records:
yes rented
Enter query to find:
Enter income:
high
Enter age:
old
---------Count----------
low	0  3  
medium	1  1  
high	4  0  
veryhigh	2  0  
old	1  1  
medium	3  2  
young	3  1  
---------Probability----------
low	0  0.75  
medium	0.14  0.25  
high	0.57  0  
veryhigh	0.29  0  
old	0.14  0.25  
medium	0.43  0.5  
young	0.43  0.25  

Probability of being yes:0.08
Probability of being rented:0

Likelihood of being yes:0.05
Likelihood of being rented:0
Result
Person has yes house.
tejal@ubuntu:~/Desktop$ 
     
*/
