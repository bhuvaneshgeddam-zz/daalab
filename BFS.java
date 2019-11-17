import java.util.*;
class bfs
{
	public static LinkedList<Integer> li=new LinkedList<Integer>();
	public static void main(String args[])
	{
		
		int n,v;
		Scanner ob=new Scanner(System.in);
		System.out.println("enter graph size:");
		n=ob.nextInt();
		int[] a[]=new int[n][n];
		int[] visited=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("enter ele of "+(i+1)+" row:");
			for(int j=0;j<n;j++)
			{
				a[i][j]=ob.nextInt();
			}
		}
		//print(a,n);
		System.out.println("enter source vertex:");
		v=ob.nextInt();
		System.out.println("----------");
		bfsalgo(v,n,a,visited);
		
		
	}
	public static void bfsalgo(int v ,int n,int a[][],int visited[])
	{
		
		int u=v,i,w;
		visited[u]=1;
		li.add(u);
		do
		{
			w=li.getFirst();
			i=0;
			while(i<n)
			{
				if(a[w][i]==1)
				{
					if(visited[i]==0)
					{
						li.add(i);
						visited[i]=1;		
					}
				}
				i++;	
			}
			System.out.println(li.removeFirst());
		
		}while(!li.isEmpty());	
	
	
	
	
	
	
	
	}
	public static void print(int a[][],int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.println();
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]+" ");
			}
		}
		System.out.println();
	}
}
