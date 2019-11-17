import java.util.*;
class dijkstras
{
	static int[] d=new int[10];
	static boolean[] s=new boolean[10];
	public static void main(String args[])
	{
		int n,v;
		Scanner ob=new Scanner(System.in);
		System.out.println("enter n:");
		n=ob.nextInt();
		int[] cost[]=new int[n+1][n+1];
		System.out.println("enter cost matrix details:");
		for(int i=1;i<=n;i++)
		{
			System.out.println("enter "+i+"row");
			for(int j=1;j<=n;j++)
				cost[i][j]=ob.nextInt();
		}
		System.out.println("enter source vertex:");
		v=ob.nextInt();
		shrtpath(v,cost,n);
	}
	static void shrtpath(int v,int cost[][],int n)
	{
		int u=v,min=9999;
		for(int i=1;i<=n;i++)
		{
			s[i]=false;
			d[i]=cost[v][i];
		}
		s[v]=true;
		System.out.println("selected :"+v);
		d[v]=0;
		for(int j=2;j<=n;j++)
		{
			
			for(int k=1;k<=n;k++)
			{
				if(s[k]==false)
				{
					min=d[k];
					u=k;
					break;
				}
			}
			for(int l=1;l<=n;l++)
			{
				if(s[l]==false && d[l]<=min)
				{
					min=d[l];
					u=l;
				}
			}
			System.out.println("selected:"+u);
			s[u]=true;			
			for(int w=1;w<=n;w++)
			{
				if((cost[w][u]!=99 || cost[w][u]!=0) && s[w]==false)
				{
					if(d[w]>d[u]+cost[w][u])
						d[w]=d[u]+cost[w][u];
				}
			}
		}
	}
}
/*enter n:
4
enter cost matrix details:
enter 1row
0 1 5 99
enter 2row
99 0 2 9
enter 3row
99 99 0 4
enter 4row
99 99 99 0
enter source vertex:
1
selected :1
0
1
5
99
selected:2
selected:3
selected:4*/