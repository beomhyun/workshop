import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6730 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int up = 0;
			int down = 0;
			int pre=Integer.parseInt(st.nextToken());
			for (int i = 1; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(pre > tmp) {
					if(down < pre-tmp) {
						down = pre-tmp;
					}
				}else {
					if(up < tmp-pre) {
						up = tmp-pre;
					}
				}
				pre =tmp;
			}
			System.out.println("#"+test+" "+up+" "+down);
		}
	}
}
