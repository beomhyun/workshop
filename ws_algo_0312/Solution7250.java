import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution7250 {
	static int N;
	static int M;
	static int K;
	static char[][] map;
	static boolean[][] visitS;
	static boolean[][] visitV;
	static ArrayList<xy> S;
	static ArrayList<xy> V;
	static xy E;
	static ArrayList<xy> F;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count;
	static int testcase;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= T; test++) {
			testcase = test;
			count =0;
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visitS = new boolean[N][M];
			visitV = new boolean[N][M];
			
			F = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringBuilder str = new StringBuilder(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'S') {
						S.add(new xy(i, j, K));
					}
					if(map[i][j] == 'V') V.add(new xy(i, j));
					if(map[i][j] == 'F') F.add(new xy(i, j));					
					if(map[i][j] == 'E') E = new xy(i, j);
				}
			}//입력
		}
	}
	static void bfs() {
//		if(V.x==E.x && V.y==E.y) {
//			count = -1;
//			return;
//		}
//		if((S.x==E.x && S.y==E.y) && count!=-1) {
//			count++;
//			return;
//		}
		for(xy tmp : F) {
			for (int i = 0; i < 4; i++) {
				if(tmp.x+dx[i]>=0 && tmp.x+dx[i]<N && tmp.y+dy[i]>=0 &&tmp.y+dy[i]<M && map[tmp.x+dx[i]][tmp.y+dy[i]]!='X' && map[tmp.x+dx[i]][tmp.y+dy[i]]!='W' && map[tmp.x+dx[i]][tmp.y+dy[i]]=='E') {
					map[tmp.x+dx[i]][tmp.y+dy[i]]='F';
					F.add(new xy(tmp.x+dx[i], tmp.y+dy[i]));
				}
			}
		}
		ArrayList<xy> NS = new ArrayList<>();
		ArrayList<xy> NV = new ArrayList<>();
		for(xy tmp : V) {
			for (int i = 0; i < 4; i++) {
				if(tmp.x+dx[i]>=0 && tmp.x+dx[i]<N && tmp.y+dy[i]>=0 &&tmp.y+dy[i]<M && map[tmp.x+dx[i]][tmp.y+dy[i]]!='X' && map[tmp.x+dx[i]][tmp.y+dy[i]]!='W') {
					if(map[tmp.x+dx[i]][tmp.y+dy[i]]=='E') {
						count = -1;
						return;
					}
					NV.add(new xy(tmp.x+dx[i], tmp.y+dy[i]));
				}
			}
		}
		for(xy tmp : S) {
			for (int i = 0; i < 4; i++) {
				if(tmp.x+dx[i]>=0 && tmp.x+dx[i]<N && tmp.y+dy[i]>=0 &&tmp.y+dy[i]<M && map[tmp.x+dx[i]][tmp.y+dy[i]]!='F' && map[tmp.x+dx[i]][tmp.y+dy[i]]!='X') {
					if(map[tmp.x+dx[i]][tmp.y+dy[i]]=='E') {
						count++;
						return;
					}
					NS.add(new xy(tmp.x+dx[i], tmp.y+dy[i]));
				}
			}
		}
	}
	static class xy{
		int x;
		int y;
		int k;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public xy(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
}