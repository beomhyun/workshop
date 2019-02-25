import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1256 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			
			StringBuilder str = new StringBuilder(br.readLine());
			String[] arr = new String[str.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = str.substring(i);
			}
			Arrays.sort(arr);
			System.out.println("#"+test+" "+arr[n-1]);
		}
	}

}
