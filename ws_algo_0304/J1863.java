import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class J1863 {
	static int[] zz;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		zz=new int[n+1];
		for (int i = 1; i <= n; i++) {
			zz[i] = i;
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			union(a,b);
		}
//		Arrays.sort(zz);
//		int count =0;
//		int tmp =0;
//		for (int i = 1; i < n+1; i++) {
//			if(tmp!=zz[i]) {
//				count++;
//				tmp=zz[i];
//			}
//		}
//		System.out.println(count);
		
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			set.add(zz[i]);
		}
		System.out.println(set.size());
	}
	static int find(int a){

		if(a==zz[a]) {
			return a;
		}else {
			return zz[a] = find(zz[a]);
		}
	}
	static void union(int a, int b){
		int aa = find(a);
		int bb = find(b);
		if(aa==bb) {
			return;
		}else {
			if(aa<bb) {
				zz[b]=aa;
			}else {
				zz[a]=bb;
			}
		}
	}
}
