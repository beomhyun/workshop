import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1265 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T  = Integer.parseInt(br.readLine().trim());
		for (int test = 1; test <=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int tmp = N%p;
			long res=1L;
			res*=Math.pow((N/p), (p-tmp));
			res*=Math.pow((N/p)+1, tmp);
			System.out.println("#"+test+" "+res);
		}
	}

}
