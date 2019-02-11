package ws_algo_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1240 {
	static String[] secret={
			"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", 
					"0101111", "0111011", "0110111", "0001011", };
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String  str = "";
			for (int i = 0; i < N; i++) {
				str+=br.readLine();
			}
			int []aaaa = new int[8];
			int index=0;
			String tempStr ="";
			for (int i = str.length()-1; i >= 0; i--) {
				if(str.charAt(i)=='1' ) {
					tempStr = str.substring(i-55, i+1);
					break;
				}
			}
			//System.out.println(tempStr);
			String []abcd = new String[8];
			int indexx = 0;
			int iii =0;
			while(indexx < 8) {
				abcd[indexx++] = tempStr.substring(iii, iii+7);
				iii += 7;
			}
			//System.out.println(Arrays.toString(abcd));
			
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 10; i++) {
					if(abcd[j].equals(secret[i])) {
						aaaa[index++] = i;
					}
				}
			}
			System.out.println(Arrays.toString(aaaa));
			int sum = aaaa[aaaa.length-1];
			int result = aaaa[aaaa.length-1];
			for (int i = 0; i < aaaa.length-1; i++) {
				if((i+1)%2==0) {
					sum+=aaaa[i];
					result += aaaa[i];
				}else {
					sum+=aaaa[i]*3;
					result += aaaa[i];
				}
			}
			System.out.println(sum);
			if(sum%10==0) {
				System.out.println("#"+test+" "+result);
			}else {
				System.out.println("#"+test+" "+0);
			}
			
		}
	}
}
