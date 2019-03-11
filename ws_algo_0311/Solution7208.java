import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7208 {
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] con = new int[N];
			ArrayList<Integer>[] near = new ArrayList[N];
			count =0;
			for (int i = 0; i < N; i++) {
				near[i] = new ArrayList<>();
			}
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				con[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < N; j++) {
				StringTokenizer str = new StringTokenizer(br.readLine().trim());
				for (int k = 0; k < N; k++) {
					int tmp = Integer.parseInt(str.nextToken());
					if(tmp==1) {
						near[j].add(k);
					}
				}
			}
			System.out.println(Arrays.toString(con));
			for (int i = 0; i < N; i++) {
				System.out.println(near[i]);
			}
			System.out.println();
			
			for (int i = 0; i < near.length; i++) {
				for (int j = i+1; j < near.length; j++) {
					if(near[j].size()>near[i].size()) {
						 ArrayList tmp = near[j];
						 near[j] = near[i];
						 near[i] =tmp;
						 int tmpp = con[j];
						 con[j] = con[i];
						 con[i] =tmpp;
					}
				}
			}
			
			System.out.println(Arrays.toString(con));
			for (int i = 0; i < N; i++) {
				System.out.println(near[i]);
			}
			
			for (int i = 0; i < N; i++) {
				boolean[] col = new boolean[5];
				System.out.println(near[i]);
				for (int j :near[i]) {
					col[con[j]]=true;
				}
				if(!col[con[i]]) {
					continue;
				}else {
					System.out.println(Arrays.toString(col));
					for (int j = 1; j < col.length; j++) {
						if(!col[j]) {
							count++;
							con[i] = j;
							break;
						}
					}
				}
//				System.out.println(Arrays.toString(con));
			}
			System.out.println("#"+test+" "+count);
		}
	}
}
