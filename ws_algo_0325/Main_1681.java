import java.util.Scanner;

public class Main_1681 {
	static int n;
	static int[][] arr;
	static int min;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		arr= new int[n][n];
		min  = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		boolean[] visit = new boolean[n];
		visit[0]=true;
		for (int i = 1; i < arr.length; i++) {
			if(arr[0][i]==0) continue;
			visit[i]=true;
			dfs(visit,i,1,arr[0][i]);
			visit[i] = false;
		}
		System.out.println(min);
	}
	static void dfs(boolean[]visit, int pre, int d,int val) {
		if(min < val) return;
		if(d==n-1) {
			if(arr[pre][0] ==0) return;
			val= val+arr[pre][0];
			if(min > val) {
				min = val;
			}
			return;
		}
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]|| arr[pre][i]==0) continue;
			visit[i] = true;
			dfs(visit,i,d+1,val+arr[pre][i]);
			visit[i] =false;
		}
	}
}
