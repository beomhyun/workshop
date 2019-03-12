import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1259 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st=  new StringTokenizer(br.readLine());
			ArrayList<Integer> start = new ArrayList<>();
			ArrayList<Integer> end = new ArrayList<>();
			
			while(st.hasMoreTokens()) {
				start.add(Integer.parseInt(st.nextToken()));
				end.add(Integer.parseInt(st.nextToken()));
			}
			int s = 0;
			for (int i = 0; i < N; i++) {
				if(!end.contains(start.get(i))) {
					s=i;
				}
			}
			StringBuilder res = new StringBuilder();
			while(true) {
				res.append(" "+start.get(s));
				res.append(" "+end.get(s));
				if(!start.contains(end.get(s))) {
					break;
				}
				for (int i = 0; i < N; i++) {
					if(end.get(s) == start.get(i)) {
						s= i;
						break;
					}
				}
			}
			System.out.println("#"+test+res.toString());
		}
	}
}
