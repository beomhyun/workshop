import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7234 {
	static int[] dx = {-2,-1,1,2,0,0,0,0};
	static int[] dy = {0,0,0,0,-2,-1,1,2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N+1][N+1];
			int max =0;
			for (int i = 0; i < B; i++) {
				StringTokenizer st2= new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				arr[x][y] = -1;
				for (int j = 0; j < 8; j++) {
					if(x+dx[j]>=0&&y+dy[j]>=0 && x+dx[j]<=N && y+dy[j]<=N&&arr[x+dx[j]][y+dy[j]]!=-1) {
						arr[x+dx[j]][y+dy[j]]++;
						if(max < arr[x+dx[j]][y+dy[j]]) {
							max = arr[x+dx[j]][y+dy[j]];
						}
					}
				}
			}
			System.out.println("#"+test+" "+max);
		}
	}
	
}
