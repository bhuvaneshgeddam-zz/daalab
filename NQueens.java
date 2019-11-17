import java.util.*;
import java.lang.*;
class nqueens
{
	static int[] x=new int[10];
	public static void main(String args[])
	{
		int n;
		System.out.println("enter size of chess board?:");
		Scanner ob=new Scanner(System.in);
		n=ob.nextInt();
		nq(1,n);
	}
	static boolean place(int k,int i)
	{
		for(int j=1;j<=k-1;j++)
		{
			if((x[j]==i)||(Math.abs(x[j]-i)==Math.abs(j-k)))
			{
				return false;
			}
		}
		return true;
	}
	static void nq(int k,int n)
	{
		for(int i=1;i<=n;i++)
		{
			if(place(k,i))
			{
				x[k]=i;
				if(k==n)
				{
					System.out.println("-----------------");
					for(int j=1;j<=n;j++)
					{
						System.out.println(x[j]);
					}
					
				}
				else
				{
					nq(k+1,n);
				}
			}
		}
	}
}