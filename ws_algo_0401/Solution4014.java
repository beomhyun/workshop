import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014 {
	static int n;
	static int x;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <=T; test++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st1.nextToken());
			x = Integer.parseInt(st1.nextToken());
			arr= new int[n][n];
			
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			int count =0;
			for (int i = 0; i < n; i++) {
				int pre = 0;
				int now = 0;
				int pres = 0;
				boolean c = true;
				for (int j = 0; j < n; j++) {
					if(arr[i][j] == pres) now++;
					else {
						if(j==0) {
							pres = arr[i][j];
							now=1;
						}
						else {
							if(Math.abs(arr[i][j] - pres) > 1) {
								c=false;
								break;
							}else {
								if(arr[i][j] > pres) {
									pre = now;
									if(pre < x) {
										c=false;
										break;
									}
									else {
										now=1;
										pres= arr[i][j];
									}
								}else {
									boolean cc = false;
									
									for (int k = j; k < j+x; k++) {
										if(k<n && arr[i][j]==arr[i][k]) {
											cc = true;
										}else {
											cc= false;
										}
									}
									if(!cc) {
										c=false;
										break;
									}else {
										pre = now;
										now = 0;
										pres = arr[i][j];
										j+=x-1;
									}
								}
							}
						}
					}
				}
				if(c) {
//					System.out.println(i);
					count++;
				}
			}
//			System.out.println();
			for (int i = 0; i < n; i++) {
				int pre = 0;
				int now = 0;
				int pres = 0;
				boolean c = true;
				for (int j = 0; j < n; j++) {
					if(arr[j][i] == pres) now++;
					else {
						if(j==0) {
							pres = arr[j][i];
							now=1;
						}
						else {
							if(Math.abs(arr[j][i] - pres) > 1) {
								c=false;
								break;
							}else {
								if(arr[j][i] > pres) {
									pre = now;
									if(pre < x) {
										c=false;
										break;
									}
									else {
										now=1;
										pres= arr[j][i];
									}
								}else {
									boolean cc = false;
									
									for (int k = j; k < j+x; k++) {
										if(k<n && arr[j][i]==arr[k][i]) {
											cc = true;
										}else {
											cc= false;
										}
									}
									if(!cc) {
										c=false;
										break;
									}else {
										pre = now;
										now = 0;
										pres = arr[j][i];
										j+=x-1;
									}
								}
							}
						}
					}
				}
				if(c) {
//					System.out.println(i);
					count++;
				}
			}
			
			System.out.println("#"+test+" "+count);
		}
	}

}
