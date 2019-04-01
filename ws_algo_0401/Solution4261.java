import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4261 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		char[][] list = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		for (int test = 1; test <= T; test++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
			String S = st1.nextToken();
			int n = Integer.parseInt(st1.nextToken());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int count=0;
			for (int i = 0; i < n; i++) {
				String str=  st.nextToken();
				if(str.length() !=  S.length()) continue;
				boolean check = true;
				for (int j = 0; j < str.length(); j++) {
					int num = S.charAt(j)-'0';
					char tmp = str.charAt(j);
					boolean c = false;
					for (int k = 0; k < list.length; k++) {
						for (int k2 = 0; k2 < list[k].length; k2++) {
							if(tmp == list[k][k2] && num == k) {
//								System.out.println(tmp+" "+list[k][k2]+ " "+k);
								c= true;
								break;
							}
						}
						if(c) break;
					}
					if(!c) {
						check =false;
						break;
					}
				}
				if(check) count++;
			}
			System.out.println("#"+test+" "+count);
		}
			
	}
}
