import java.util.ArrayList;
import java.util.Scanner;

public class Main2458 {
	static int N;
	static nod[] list;
	static int[] numchi;
	static int[] numpar;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		list = new nod[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new nod(i);
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[b].chi.add(a);
			list[a].par.add(b);
		}
		numchi = new int[N+1];
		numpar = new int[N+1];
		
		for (int i = 1; i <=N ; i++) {
			visit = new boolean[N+1];
			visit[i]=true;
			findchi(i,i);
			findpar(i,i);

		}
		int res = 0;
		for (int i = 1; i <= N; i++) {
			if(numchi[i]+numpar[i] == N-1) {
				res++;
			}
		}
		System.out.println(res);
	}
	static void findchi(int a, int b) {
		if(list[b].chi.size()==0) {
			return;
		}
		for (int i = 0; i < list[b].chi.size(); i++) {
			if(visit[list[b].chi.get(i)]) {
				continue;
			}else {
				visit[list[b].chi.get(i)] = true;
				numchi[a]++;
				findchi(a, list[b].chi.get(i));
			}
		}
	}
	static void findpar(int a, int b) {
		if(list[b].par.size()==0) {
			return;
		}
		for (int i = 0; i < list[b].par.size(); i++) {
			if(visit[list[b].par.get(i)]) {
				continue;
			}else {
				visit[list[b].par.get(i)] = true;
				numpar[a]++;
				findpar(a, list[b].par.get(i));
			}
		}
	}
	static class nod{
		int v;
		ArrayList<Integer> chi = new ArrayList<>();
		ArrayList<Integer> par = new ArrayList<>();
		public nod(int v) {
			super();
			this.v = v;
		}
	}
}
		