import java.util.*;
class prims
{
	static int[] near=new int[10];
	static int[][] t=new int[10][10];
	public static void main(String args[])
	{
		int n;
		Scanner ob=new Scanner(System.in);
		System.out.println("enter n:");
		n=ob.nextInt();
		int[][] cost=new int[n+1][n+1];
		System.out.println("enter cost matrix details:");
		for(int i=1;i<=n;i++)
		{
			System.out.println("enter row "+i+" :");
			for(int j=1;j<=n;j++)
			{
				cost[i][j]=ob.nextInt();
			}
		}
		System.out.println(algprims(cost,n));
			
	}
	static int algprims(int cost[][],int n)
	{
		int min=999,mincost=0,k=0,l=0;
		int j=0;;
		for(int r=1;r<=n;r++)
		{
			for(int s=1;s<=n;s++)
			{
				if(cost[r][s]<min)
				{
					min=cost[r][s];
					k=r;
					l=s;
				}
			}
		}
		mincost=cost[k][l];
		t[1][1]=k;
		t[1][2]=l;
		for(int i=1;i<=n;i++)
		{
			if(cost[i][l]<cost[i][k])	
				near[i]=l;
			else
				near[i]=k;
		}
		near[k]=0;
		near[l]=0;
		for(int i=2;i<=n-1;i++)
		{
			System.out.println("near matrix:");
			j=find(cost,n);
			t[i][1]=j;
			t[i][2]=near[j];
			mincost+=cost[j][near[j]];
			near[j]=0;
			for(int u=1;u<=n;u++)
			{
				if(near[u]!=0 && cost[u][near[u]]>cost[u][j])
					near[u]=j;
			}
		}
		print(n);
		return mincost;
	} 
	static int find(int cost[][],int n)
	{
		int j=0,min=999;
		for(int i=1;i<=n;i++)
		{
			if(near[i]!=0 && cost[i][near[i]]<min)
			{
				min=cost[i][near[i]];
				j=i;
			}
		}
		return j;
	}
	static void print(int n)
	{
		for(int i=1;i<=n;i++)
		{
			System.out.println();
			System.out.print(t[i][1]+" "+t[i][2]);
		}
		System.out.println("-------------");
	}
	
}