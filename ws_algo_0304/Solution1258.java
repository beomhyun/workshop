import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1258 {
	static ArrayList<rc> list;
	static int[][] arr;
	static boolean[][] visit;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			list = new ArrayList<>();
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ArrayList<rc> l = new ArrayList<>();
					bfs(i,j,l);
					if(l.size()>0) list.add(sol(l));
				}
			}
			
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).c + "  "+ list.get(i).r);
//			}
			list.sort(new Comparator<rc>() {
				@Override
				public int compare(rc o1, rc o2) {
					return o1.c*o1.r>o2.c*o2.r?1:-1;
				}
			});
			System.out.print("#"+test+" "+list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.print(" "+list.get(i).r+" "+list.get(i).c);
			}System.out.println();
		}
	}
	static int bfs(int x,int y,ArrayList<rc> l) {
		int tot =0;
		if(x>=0 && y>=0 && x<N && y<N && arr[x][y] !=0 && !visit[x][y]) {
			visit[x][y] = true;
			l.add(new rc(x,y));
			tot = 1+bfs(x-1,y,l)+bfs(x+1,y,l)+bfs(x,y-1,l)+bfs(x,y+1,l);
		}else {
			return 0;
		}
		return tot;
	}
	static rc sol(ArrayList<rc> l) {
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		int maxx = -1;
		int maxy = -1;
		
		for (int i = 0; i < l.size(); i++) {
			rc tmp =l.get(i);
			minx = Math.min(minx, tmp.r);
			maxx = Math.max(maxx, tmp.r);
			miny = Math.min(miny, tmp.c);
			maxy = Math.max(maxy, tmp.c);
		}
//		System.out.println(new rc(maxx-minx+1, maxy-miny+1));
		return (new rc(maxx-minx+1, maxy-miny+1));
	}
	static class rc{
		int r;
		int c;
		public rc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "rc [r=" + r + ", c=" + c + "]";
		}
		
	}
}