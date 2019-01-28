package wsalgo07_대전_3반_김범현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class wsalgo07 {
	static int winA =0;
	static int winB =0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			winA=0;
			winB=0;
			int []arr =new int[9];
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			Arrays.sort(arr);
			int []check = new int[19];
			for (int i = 0; i < arr.length; i++) {
				check[arr[i]] = 1;
			}
			int []brr = new int[9];
			int bindex = 0;
			for (int i = 1; i < check.length; i++) {
				if(check[i] == 0) {
					brr[bindex++] = i;
				}
			}
			permutation(arr,brr, 0,9);
			System.out.println("#"+test+" "+winA+" "+winB);
		}
	}
	public static void permutation(int []brr,int[]arr, int deapth, int k) {
		if(deapth == k) {
			int sumA=0;
			int sumB=0;
			for(int i=0; i<k; i++) {
				if(brr[i]>arr[i]) {
					sumA += brr[i];
					sumA += arr[i];
				}else {
					sumB += brr[i];
					sumB += arr[i];
				}
			}
			if(sumA>sumB) {
				winA++;
			}else {
				winB++;
			}
			return;
		}
		for(int i =deapth; i<arr.length; i++) {
			swap(arr, i, deapth);
			permutation(brr,arr, deapth+1,k);
			swap(arr, i, deapth);
		}
	}
	public static void swap(int []arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
