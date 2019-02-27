import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1873_sol {
	static int[] dic = {1,2,3,4};
	static tank t;
	static char[][] arr;
	static int H;
	static int W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			for (int i = 0; i < H; i++) {
				StringBuilder sb = new StringBuilder(br.readLine().trim());
				for (int j = 0; j < W; j++) {
					arr[i][j] = sb.charAt(j);
					//탱크의 위치와 방향 찾아서 탱크 클래스 만들기
					if(arr[i][j] =='^') {
						t = new tank(i, j, 1);
					}else if(arr[i][j] =='>') {
						t = new tank(i, j, 2);
					}else if(arr[i][j] =='v') {
						t = new tank(i, j, 3);
					}else if(arr[i][j] =='<') {
						t = new tank(i, j, 4);
					}
				}
			}//입력
			int N = Integer.parseInt(br.readLine().trim());
			StringBuilder str = new StringBuilder(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				char a = str.charAt(i);
//				System.out.println(a);
				if(a == 'U') {
					go(t,1);
				}else if(a=='R') {
					go(t,2);
				}else if(a=='D') {
					go(t,3);
				}else if(a=='L') {
					go(t,4);
				}else if(a=='S') {
					shoot(t);
				}
//				for (int j = 0; j < arr.length; j++) {
//					System.out.println(Arrays.toString(arr[j]));
//				}
//				System.out.println("\n");
			}
			System.out.print("#"+test+" ");
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]);
				}System.out.println();
			}
			
		}
	}
	static void shoot(tank t) {
		int x = t.x;
		int y = t.y;
		int dic = t.dic;
		
		if(dic==1) {
			for (int i = x-1; i >= 0; i--) {
				if(arr[i][y] == '#') {
					return;
				}else if(arr[i][y] == '*') {
					arr[i][y] = '.';
					break;
				}
			}
		}else if(dic==2) {
			for (int i = y+1; i < W; i++) {
				if(arr[x][i] == '#') {
					return;
				}else if(arr[x][i] == '*') {
					arr[x][i] = '.';
					break;
				}
			}
			
		}else if(dic==3) {
			for (int i = x+1; i < H; i++) {
				if(arr[i][y] == '#') {
					return;
				}else if(arr[i][y] == '*') {
					arr[i][y] = '.';
					break;
				}
			}
		}else if(dic==4) {
			for (int i = y-1; i >= 0; i--) {
				if(arr[x][i] == '#') {
					return;
				}else if(arr[x][i] == '*') {
					arr[x][i] = '.';
					break;
				}
			}
		}
	}
	static void go(tank t, int dic) {
		t.dic=dic;
		if(dic==1) {
			if(t.x-1 >= 0 && arr[t.x-1][t.y]=='.') {
				arr[t.x][t.y]='.';
				t.x--;
				arr[t.x][t.y] = '^';
			}else {
				arr[t.x][t.y] = '^';
			}
		}else if(dic==2) {
			if(t.y+1<W && arr[t.x][t.y+1]=='.') {
				arr[t.x][t.y]='.';
				t.y++;
				arr[t.x][t.y] = '>';
			}else {
				arr[t.x][t.y] = '>';
			}
		}else if(dic==3) {
			if(t.x+1<H && arr[t.x+1][t.y]=='.') {
				arr[t.x][t.y]='.';
				t.x++;
				arr[t.x][t.y] = 'v';
			}else {
				arr[t.x][t.y] = 'v';
			}
		}else if(dic==4) {
			if(t.y-1>=0 && arr[t.x][t.y-1]=='.') {
				arr[t.x][t.y]='.';
				t.y--;
				arr[t.x][t.y] = '<';
			}else {
				arr[t.x][t.y] = '<';
			}
		}
	}
	static class tank{
		int x;
		int y;
		int dic;
		public tank(int x, int y, int dic) {
			super();
			this.x = x;
			this.y = y;
			this.dic = dic;
		}
		
	}
}
