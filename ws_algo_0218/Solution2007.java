import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuilder input= new StringBuilder();
			input.append(br.readLine());
			
			StringBuilder str = new StringBuilder();
			str.append(input.charAt(0));
			str.append(input.charAt(1));
			
			for (int j = 4; j < input.length(); j++) {
				StringBuilder tmp = new StringBuilder();
				tmp.append(input.substring(j-2, j));
								
				if(str.charAt(0)==tmp.charAt(0)  && str.charAt(1)==tmp.charAt(1)) {
					System.out.println("#"+i+" "+(j-2));
					break;
				}
			}
		}
	}

}
