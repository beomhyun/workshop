import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1494 {
	static boolean[] used;
	static ArrayList<Long> res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			xy[] list = new xy[N];
			used = new boolean[N];
			res = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list[i]=new xy(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
//				list.add(new xy(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			sol(list,N,0,0);
			
//			System.out.println(res);
			Long min = Long.MAX_VALUE;
			for (int i = 0; i < res.size(); i++) {
				if(min > res.get(i)) {
					min = res.get(i);
				}
			}
			System.out.println("#"+test+" "+min);
		}
	}
	static void sol(xy[] list, int n, int r,int d) {
		if(d==n && r<n/2) {
			return;
		}
		long x=0;
		long y=0;
		if(r==n/2) {
			for (int i = 0; i < used.length; i++) {
				if(used[i]) {
					x+=list[i].x;
					y+=list[i].y;
				}else {
					x-=list[i].x;
					y-=list[i].y;
				}
			}
			long tmp = x*x+y*y;
			res.add(tmp);
			return;
		}
		used[d]=true;
		sol(list,n,r+1,d+1);
		used[d]=false;
		sol(list,n,r,d+1);
	}
	static class xy {
		long x;
		long y;
		public xy(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}