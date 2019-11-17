import java.util.*;

class DFS {
	public static LinkedList<Integer> li = new LinkedList<Integer>();

	public static void main(String args[]) {

		int n, v;
		Scanner ob = new Scanner(System.in);
		System.out.println("enter graph size:");
		n = ob.nextInt();
		int[] a[] = new int[n][n];
		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("enter ele of " + (i + 1) + " row:");
			for (int j = 0; j < n; j++) {
				a[i][j] = ob.nextInt();
			}
		}
		// print(a,n);
		System.out.println("enter source vertex:");
		v = ob.nextInt();
		System.out.println("----------");
		dfsalgo(v, n, a, visited);

	}

	public static void dfsalgo(int v, int n, int a[][], int visited[]) {

		int i;
		li.add(v);
		while (!li.isEmpty()) {
			v = li.removeLast();
			if (visited[v] == 0) {
				System.out.println(v);
				visited[v] = 1;
			}
			for (i = n - 1; i >= 0; i--) {
				if (a[v][i] == 1 && visited[i] == 0)
					li.add(i);
			}
		}
	}

}
