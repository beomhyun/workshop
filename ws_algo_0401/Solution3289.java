import java.util.Scanner;

public class Solution3289 {
	static int n;
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 1; test <= T; test++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			par = new int[n+1];
			for (int i = 0; i <= n; i++) {
				par[i] = i;
			}
			
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < m; i++) {
				int s = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(s==0) {
					union(a,b);
				}else {
					if(find(a)==find(b)) res.append("1");
					else res.append("0");
				}
			}
			System.out.println("#"+test+" "+res.toString());
		}
	}
	static int find(int a) {
		if(a==par[a]) return a;
		else {
			par[a] = find(par[a]);
			return par[a];
		}
	}
	static void union(int a, int b) {
		if(find(a) == find(b)) return;
		else {
			if(find(a) <= find(b)) par[find(b)] = find(a);
			else par[find(a)] = find(b);
		}
	}
}
