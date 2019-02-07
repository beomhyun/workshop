package ct01_대전_3반_김범현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5607 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int p = 1234567891;
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			String NR = br.readLine();
			StringTokenizer st = new StringTokenizer(NR);
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
						
			long result = nCr(N,R,p);
			
			System.out.println("#"+test+" "+ result);
		}
	}
	public static long nCr(int n, int r ,int p) {
		      if(r ==0) {
		         return 1;
		      }
		      long[] fac = new long[n+1];
		      fac[0] =1;
		      
		      for(int i=1 ; i<= n; i++)
		         fac[i] = fac[i-1]*i% p;
		      
		      return (fac[n]* modInverse(fac[r],p)%p*modInverse(fac[n-r],p)%p)%p;
		      
		   }
	public static long modInverse(long n, long p) {
		      return power(n,p-2,p);
		   }
	public static long power(long x, long y, long p) {
		long res = 1L;
		x = x%p;
		// 3^7  >  7 3 1  3^7 --> 3^1*3^2*3^4
		while(y>0) {
			if(y%2 == 1) {
				res = (res*x)%p;
			}
			y = y >> 1;
			x = (x*x)%p;
		}
		return res;
	}
	public static long pac(long a) {
		if(a==1) {
			return 1;
		}else {
			return a*pac(a-1);
		}
	}

}
