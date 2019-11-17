import java.util.*;
class kruskal
{

	static int[] p=new int[10];
	static int[][] t=new int[10][10];
	static int l1=0,u,v;
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
		algkruskal(cost,n);
	}
	static void algkruskal(int cost[][],int n)
	{
		int i,mincost,min=999;
		int j=0,k=0;
		for(i=1;i<=n;i++)
			p[i]=-1;
		i=0;
		mincost=0;
		while(i<n-1)
		{
			delmincostedg(cost,n);
			j=find(u);
			k=find(v);
			if(j!=k)
			{
				i++;
				t[i][1]=u;
				t[i][2]=v;
				mincost+=cost[u][v];
				p[j]=k;
			}
		}
		if(i!=n-1)
			System.out.println("no spanning tree");
		else
			System.out.println(mincost);
	}
	static void delmincostedg(int cost[][],int n)
	{
		int l2=99;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i!=j)
				{
					if(l1<cost[i][j] && cost[i][j]<l2)
					{
						l2=cost[i][j];
						u=i;
						v=j;
					}
				}
			}
		}
		l1=l2;
	}
	static int find(int i)
	{
		while(p[i]>0)
		{
			i=p[i];	
		}
		return i;
	}
}
