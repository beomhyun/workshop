package WS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1247 {
	static boolean[] used = null;
	static Stack<int[]> result;
	static int min = 9999999;
	static int[] company = new int[2];
	static int[] home = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			min = 9999999;
			result = new Stack<>();
			int N =Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[][] arr = new int[N][2];
			used = new boolean[N];
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			result.push(company);
			permutation(arr,0,arr.length);
			System.out.println("#"+test+" "+min);
		}
		
	}
	static void permutation(int[][]arr,int d, int r) {
		if(d==r) {
			int tmp = calc();
			if(min > tmp) {
				min = tmp;
			}
			return;
		}
		for (int i=0; i<arr.length; i++) {
			if(!used[i]) {
				used[i] = true;
				result.push(arr[i]);
				permutation(arr, d+1, r);
				result.pop();
				used[i] = false;
			}
		}
	}
	private static int calc() {
		int tmp = 0;
		int[] xy = home;
		int x = xy[0];
		int y = xy[1];
		
		for (int i = result.size()-1 ; i >=0 ; i--) {
			int[] xy2 = result.get(i);
			int x2 = xy2[0];
			int y2 = xy2[1];
			
			tmp += Math.abs(x-x2)+Math.abs(y-y2);
			x=x2;
			y=y2;
		}

		return tmp;
	}
}
