import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1861 {
	static int[][] arr;
	static ArrayList<Integer> tmp;
	static int[] dicx = {-1,1,0,0};
	static int[] dicy = {0,0,-1,1};
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int maxbystart = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					tmp = new ArrayList<>();
					visit = new boolean[n][n];
					visit[i][j] = true;
					ArrayList<xy> l = new ArrayList<>();
					l.add(new xy(i, j));
					bfs(l,1);
					int aaa = 0;
					for(int abc : tmp) {
						if(aaa<abc) aaa=abc;
					}
					if(max == aaa) {
						maxbystart = Math.min(arr[i][j], maxbystart);
					}
					if(max < aaa) {
						max = aaa;
						maxbystart=arr[i][j];
					}
				}
			}
			System.out.println("#"+test+" "+maxbystart+" "+max);
		}
	}
	static void bfs(ArrayList<xy> nowlist,int d) {
		ArrayList<xy> newlist = new ArrayList<>();
		for (int i = 0; i < nowlist.size(); i++) {
			xy a = nowlist.get(i);
			for (int j = 0; j < 4; j++) {
				if(a.x+dicx[j]>=0 && a.y+dicy[j]>=0 && a.x+dicx[j]<arr.length && a.y+dicy[j]<arr.length && arr[a.x+dicx[j]][a.y+dicy[j]]== arr[a.x][a.y]+1 && !visit[a.x+dicx[j]][a.y+dicy[j]]) {
					visit[a.x+dicx[j]][a.y+dicy[j]]=true;
					newlist.add(new xy(a.x+dicx[j],a.y+dicy[j]));
				}
			}
		}
		if(newlist.isEmpty()) {
//			System.out.println(d);
			tmp.add(d);
			return;
		}
		bfs(newlist,d+1);
	}
	static class xy{
		int x;
		int y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
