import java.util.*;
class sumofsubsets
{
	static int[] x=new int[10];
	public static void main(String args[])
	{
		Scanner ob=new Scanner(System.in);
		int m,n,sum=0;
		System.out.println("enter how many weights?:");
		n=ob.nextInt();
		int[] w=new int[n];
		System.out.println("enter weights:");
		for(int i=0;i<n;i++)
		{
			w[i]=ob.nextInt();
			sum+=w[i];
		}
		System.out.println(sum);
		System.out.println("enter req sum:");
		m=ob.nextInt();
		sos(0,0,sum,w,m);
	}
	static void sos(int s,int k,int r,int w[],int m)
	{
		x[k]=1;
		if(s+w[k]==m)
		{
			System.out.println("---------------------");
			for(int i=0;i<=k;i++)
			{
				System.out.println(x[i]);
			}
		}
		else if(s+w[k]+w[k+1]<=m)
		{
			sos(s+w[k],k+1,r-w[k],w,m);
		}
		if((s+r-w[k]>=m)&&(s+w[k+1]<=m))
		{
			x[k]=0;
			sos(s,k+1,r-w[k],w,m);
		}
	}
}