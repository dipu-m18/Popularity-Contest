import java.util.*;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Scanner;
public class abc {
   public static void maxx(int r[],String s[])// function to find top 10 items and printing them.
  {
    int i;
    int highest[] = new int[10];
    int max = 0, index;
    for (int j = 0; j < 10; j++)
     {
       max = r[0];
       index = 0;
       for (i = 1; i < r.length; i++)
       {
        if (max < r[i]) 
         {
           max = r[i];
           index = i;
          }
        }
        highest[j] = max;
        r[index] = Integer.MIN_VALUE;
        System.out.print(highest[j]+" ");
      }           
    } //end of maxx function               	
		  
   public static void rating(int r[],ArrayList<HashSet<Integer>> list)
   { 
    Scanner sc=new Scanner(System.in);
    int i=0,j=0;
    int a=r[i];
     c1: for(;j<r.length;j++)
           {int l1=(int)(a-(0.5*a));
            int l2=(int)(a+(0.5*a));
	    boolean status=list.get(i).isEmpty();
            if(status)
              { 
                if((j!=i)&&(r[j]>=l1 && r[j]<=l2))
                {System.out.println("Enter one to vote the "+i+" or two to vote the "+j);
                  int ch=sc.nextInt();
                  if(ch==1)
                   {r[i]++;a=r[i];
                    list.get(i).add(j);
		    list.get(j).add(i);
                   }
                 else if(ch==2)
                   {r[j]++;
                     list.get(j).add(i);
		     list.get(i).add(j);
                     a=r[j];
                     i=j;
		     j=-1;
		   }
                }//end of if
	     else 
		continue c1;
		}//end of outter if
            else
             { Set<Integer> s=list.get(i);
               if((j!=i)&&(!s.contains(j))&&(r[j]>=l1 && r[j]<=l2))
                {System.out.println("Enter one to vote the "+i+" or two to vote the "+j);
                  int ch=sc.nextInt();
                  if(ch==1)
                    {r[i]++;
                     list.get(i).add(j);
		     list.get(j).add(i);
                    }
                  else if(ch==2)
                    {r[j]++;
                     list.get(j).add(i);
		     list.get(i).add(j);
                     a=r[j];
                     i=j;
                     j=-1;
                    }//end of inner else
                }//end of if
		else 
		   continue c1;
              }//end of outter else
     
            }// end of for loop
	}
	
	public static void enterRank(int r[],ArrayList<HashSet<Integer>> arrlist)
	{   Scanner sc=new Scanner(System.in);
		for(int i=0;i<r.length;i++)
	      {  arrlist.add(i, new HashSet<Integer>());
	         r[i]=0;               
	      }                       
	}
	
	public static void enterItems(String s[])
	{   Scanner sc=new Scanner(System.in);
	    HashSet<String> p=new HashSet<String>();
	    System.out.println("Enter the names of the items");
	    c2:for(int i=0;i<s.length;i++)
	      {
	         String ss=sc.next(); 
                 while(p.contains(ss))
                 {
                   ss=sc.next();
		   if(!p.contains(ss))
		   {p.add(ss);
                    s[i]=ss;
		    continue c2;
                   }				  
		}
		   p.add(ss);
		   s[i]=ss;	   
	      }                        
	  }
                       	
	public static void main(String[] args)
	{ Scanner sc=new Scanner(System.in);
	  char ch;
	   String s[];
	   int r[];
	   int c=0;
	  c1: while(true)
	      {
		System.out.println("Enter the size of array within 100 to 200");
		int n=sc.nextInt();      //array to store the rank of the data items
		 if(n>=100 && n<=200)
		 {
    		   s=new String[n];  //array to store the data items
		    enterItems(s);
		    r=new int[n];
		    ArrayList<HashSet<Integer>> arrlist= new ArrayList<HashSet<Integer>>(n);
		    enterRank(r,arrlist);  //function to enter rank. 
		    rating(r,arrlist);          //function to rate the items.
		     maxx(r,s);
		     c++;
		     System.out.println("Enter 'Y' or 'y'to continue for next user");
		     ch=sc.next().charAt(0);//check if whether other user also want to rate	
                       while(ch=='Y' || ch=='y')
                       {
     			 ArrayList<HashSet<Integer>> arlist= new ArrayList<HashSet<Integer>>(r.length);
			 enterRank(r,arrlist);  //function to enter rank. 
			 rating(r,arrlist);          //function to rate the items.
		         maxx(r,s);				
			 System.out.println("Enter 'Y' or 'y'to continue for next user");
		         ch=sc.next().charAt(0);//check if whether other user also want to rate	
			}
			 break c1;
		     }//end of if statement
		   else
                   {
		    System.out.println("Enter 'Y' or 'y'to continue for next user");
		     ch=sc.next().charAt(0);//check if whether other user also want to rate	
		     if(ch=='Y' || ch=='y')
			{continue c1;}
		     else 
			{break c1;}
		    }//end of else
		
	     }//end of while statement
    }//end of main
}//end of class
