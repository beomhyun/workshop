package ct01_대전_3반_김범현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution6719 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> M = new ArrayList<>();
			
			String str2 = br.readLine();
			
			StringTokenizer st2 = new StringTokenizer(str2);
			
			for (int i = 0; i < N; i++) {
				M.add(Integer.parseInt(st2.nextToken()));
			}
			Collections.sort(M);
			double level = 0;
			for (int i = N-K; i < N; i++) {
				level = (level + M.get(i))/2;
			}
			System.out.printf("#%d %.6f\n",test,level);
		}

	}

}
