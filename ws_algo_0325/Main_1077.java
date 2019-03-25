import java.util.Scanner;

public class Main_1077 {
	static int[] pre;
	static int[] now;
	static int[] a;
	static int[] b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		pre = new int[w+1];
		now = new int[w+1];
		a= new int[n];
		b= new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= w; j++) {
				if(j-a[i] >=0) {
					now[j] = Math.max(now[j-a[i]]+b[i], pre[j]);
					now[j] = Math.max(now[j],pre[j-a[i]]+b[i]);
				}
			}
//			System.out.println(Arrays.toString(now));
			pre = now;
			now = new int[w+1];
		}
		System.out.println(pre[w]);
	}
}
