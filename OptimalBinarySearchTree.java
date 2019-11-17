import java.util.*;
class OBST
{
	public static void main(String args[])
	{
		int n;
		System.out.println("enter no of identifiers:");
		Scanner ob=new Scanner(System.in);	
		n=ob.nextInt();
		int[] p=new int[n+1];
		int[] q=new int[n+1];
		int[][] w=new int[n+1][n+1];
		int[][] c=new int[n+1][n+1];
		int[][] r=new int[n+1][n+1];
		System.out.println("enter profits of "+(n)+" internal nodes:");
		for(int i=1;i<=n;i++)
			p[i]=ob.nextInt();
		System.out.println("enter profits of "+(n+1)+" external nodes:");
		for(int i=0;i<=n;i++)
			q[i]=ob.nextInt();
		obst(w,c,r,p,q,n);
	}
	static void obst(int w[][],int c[][],int r[][],int p[],int q[],int n)
	{
		int j,k;
		for(int i=0;i<=n-1;i++)
		{
			w[i][i]=q[i];
			c[i][i]=0;
			r[i][i]=0;
			w[i][i+1]=p[i+1]+q[i]+q[i+1];
			c[i][i+1]=p[i+1]+q[i]+q[i+1];
			r[i][i+1]=i+1;
		}
		w[n][n]=q[n];
		c[n][n]=0;
		r[n][n]=0;
		for(int m=2;m<=n;m++)
		{
			for(int i=0;i<=n-m;i++)
			{
				j=i+m;
				w[i][j]=w[i][j-1]+q[j]+p[j];
				k=find(c,r,n,i,j);
				c[i][j]=c[i][k-1]+c[k][j]+w[i][j];
				r[i][j]=k;
			}
		}
		System.out.println("w:"+w[0][n]);
		System.out.println("c:"+c[0][n]);
		System.out.println("r:"+r[0][n]);
	}
	static int find(int c[][],int r[][],int n,int i,int j)
	{
		int min=999,l=0;
		for(int m=r[i][j-1];m<=r[i+1][j];m++)
		{
			if(c[i][m-1]+c[m][j]<min)
			{
				min=c[i][m-1]+c[m][j];
				l=m;
			}
		}
		return l;
	}












}