import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1865 {
	static int N;
	static int[][] arr;
	static boolean[] use;
	static double max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			use = new boolean[N];
			max = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0,1);
			System.out.printf("#%d %.6f\n",test,max*100);
		}
	}
	static void dfs(int d, double res) {
		if(d==N) {
			if(res > max ) {
				max = res;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			double tmp = res;
			if(use[i]) continue;
			tmp*=(double)arr[d][i]/100;
			if(tmp <= max) continue;
			else {
				use[i] = true;
				dfs(d+1,tmp);
				use[i]=false;
			}
		}
	}
}
