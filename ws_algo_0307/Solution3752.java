import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Solution3752 {
	static HashSet<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine().trim());
			set = new HashSet<>();
			set.add(0);
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				int a= Integer.parseInt(st.nextToken());
				ArrayList<Integer> tmp = new ArrayList<>();
				for(int abc : set) {
					tmp.add(a+abc);
				}
				for (int j = 0; j < tmp.size(); j++) {
					set.add(tmp.get(j));
				}
			}
			System.out.println("#"+test+" "+set.size());
		}
	}
}