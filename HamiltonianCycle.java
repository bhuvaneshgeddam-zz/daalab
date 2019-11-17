import java.util.*;
class HC
{
	static int[] x=new int[10];
	public static void main(String args[])
	{
		int n;
		Scanner ob=new Scanner(System.in);
		System.out.println("enter size of graph:");
		n=ob.nextInt();
		int[] g[]=new int[10][10];
		System.out.println("enter the entries of  graph(adjacency matrix):");
		for(int i=1;i<=n;i++)
		{
			System.out.println("enter"+(i)+" row ele:");
			for(int j=1;j<=n;j++)
			{
				g[i][j]=ob.nextInt();
			}
		}
		x[1]=1;
		hc(2,n,g);	
	}
	static void nv(int k,int n,int g[][])
	{
		int j;
		while(k<=n)
		{
			x[k]=(x[k]+1)%(n+1);
			if(x[k]==0)
				return;
			if(g[x[k-1]][x[k]]!=0)
			{
				for(j=1;j<=k-1;j++)
					if(x[j]==x[k])
						break;
				if(j==k)
				{
					if((k<n)||((k==n)&&(g[x[k]][x[1]]==1)))
						return;
				}
			}
		}
		
	}
	static void hc(int k,int n,int g[][])
	{
		while(k<=n)
		{
			nv(k,n,g);
			if(x[k]==0)
				return;
			if(k==n)
			{
				System.out.println("------------");
				for(int i=1;i<=n;i++)
				{
					System.out.println(x[i]);
				}
			}
			else
				hc(k+1,n,g);
		}
	}
	
}