import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4408 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[201];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(a%2==0) {
					a = a/2;
				}else {
					a = a/2+1;
				}
				if(b%2==0) {
					b= b/2;
				}else {
					b= b/2+1;
				}
				if(a >b) {
					int tmp = b;
					b= a;
					a= tmp;
				}
				for (int j = a; j <= b; j++) {
					arr[j]++;
				}
			}
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				if(max < arr[i]) {
					max = arr[i];
				}
			}
			System.out.println("#"+test+" "+max);
		}
	}

}
