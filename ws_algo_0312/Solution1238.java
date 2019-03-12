import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1238 {
	static ArrayList<Integer>[] cango;
	static boolean[] visit;
	static int testcase;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test = 1; test <= 10; test++) {
			testcase = test;
			StringTokenizer str=  new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(str.nextToken());
			int start = Integer.parseInt(str.nextToken());
			cango = new ArrayList[N];
			visit = new boolean[N];
			for (int i = 0; i < cango.length; i++) {
				cango[i] = new ArrayList<>();
			}
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				cango[a].add(b);
			}
			ArrayList<Integer> list = new ArrayList<>();
			list.add(start);
			visit[start] = true;
			bfs(list);
		}
	}	
	static void bfs(ArrayList<Integer> list) {
		ArrayList<Integer> newlist = new ArrayList<>();
		int max = 0;
		for (int i : list) {
			if(max < i) {
				max = i;
			}
			for (int j : cango[i]) {
				if(!visit[j]) {
					visit[j] =true;
					newlist.add(j);
				}
			}
		}
		if(newlist.isEmpty()) {
			System.out.println("#"+testcase+" "+max);
		}else {
			bfs(newlist);
		}
	}
}
