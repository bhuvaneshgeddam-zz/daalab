import java.util.*;
class knapsack
{
	public static void main(String arsg[])
	{
		Scanner ob=new Scanner(System.in);
		int n,m,x,y,a,k;
		System.out.println("enter no of objects:");
		n=ob.nextInt();
		System.out.println("enter capacity of knapsack:");
		m=ob.nextInt();
		int[] w=new int[n+1];
		int[] p=new int[n+1];
		int[][] v=new int[n+1][m+1];
		System.out.println("enter weights:");
		for(int i=1;i<=n;i++)
			w[i]=ob.nextInt();
		System.out.println("enter profits:");
		for(int i=1;i<=n;i++)
			p[i]=ob.nextInt();
		for(int j=1;j<=m;j++)
			v[0][j]=0;
		for(int i=0;i<=n;i++)
			v[i][0]=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				v[i][w[i]]=p[i];
				x=v[i-1][j];
				if(j-w[i]<0)
					v[i][j]=v[i-1][j];
				else
				{
					y=v[i-1][j-w[i]]+p[i];
					v[i][j]=(x>y?x:y);
				}	
			}	
		}
		print(v,n,m);
		System.out.println();
		a=v[n][m];
		for(int i=n-1;i>=1;i--)
		{
			for(k=0;k<=m;k++)
			{
				if(v[i][k]==a)
					break;
			}
			if(k==m+1)
			{
				System.out.println("object "+ (i+1)+" is included!!");
				a-=p[i+1];
			}

		}
	}
	static void print(int v[][],int n,int m)
	{
		for(int i=0;i<=n;i++)
		{
			System.out.println();
			for(int j=0;j<=m;j++)
				System.out.print(v[i][j]+" ");
		}
	}
}