import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3143 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder A = new StringBuilder(st.nextToken());
			StringBuilder B = new StringBuilder(st.nextToken());
			
			int index = 0;
			int count =0;
			while(index+B.length() <= A.length()) {
				if(A.substring(index, index+B.length()).equals(B.toString())) {
					count++;
					index += B.length();
				}else {
					index++;
				}
			}
			int res= count+ (A.length()-(count*B.length()));
			System.out.println("#"+test+" "+res);
		}
	}

}
