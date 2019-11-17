import java.util.*;

class allpairs {
	public static void main(String args[]) {
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("enter n:");
		n = s.nextInt();
		int[][] a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			System.out.println("enter row " + (i) + "ele:");
			for (int j = 1; j <= n; j++) {
				a[i][j] = s.nextInt();
			}
		}
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++) {
					if (a[i][j] > a[i][k] + a[k][j])
						a[i][j] = a[i][k] + a[k][j];
				}
		for (int i = 1; i <= n; i++) {
			System.out.println();
			for (int j = 1; j <= n; j++)
				System.out.print(a[i][j] + " ");
		}
	}
}