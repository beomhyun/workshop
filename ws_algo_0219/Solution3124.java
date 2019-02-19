import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution3124 {
	static int N,E;
	static int[] parent;	//disjoint set 에서 각 정점의 부모(대표자) 정보를 저장하는 배열
	static boolean[] visit;
	static ArrayList<Edge> mst;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			mst = new ArrayList<>();
			pq = new PriorityQueue<>(new EdgeComparator());
			for (int i = 0; i < E; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				pq.add(new Edge(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
			}
			kruskal();
			System.out.println(mst);
			long result = 0;
			for (Edge e : mst) {
				result += e.value;
			}
			System.out.println("#"+test+" "+ result);
		}
	}
	static void kruskal() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for(int i=0; i<E; i++) {
			Edge edge = pq.poll();
			if(find(edge.start) == find(edge.end)){
				continue;
			}
			union(edge.start,edge.end);
			mst.add(edge);
		}
	}
	static int find(int n) {
		if(n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1!=p2) {
			parent[p1] = p2;
		}
	}
	static class EdgeComparator implements Comparator<Edge>{
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value>o2.value?1:-1;
		}
	}
	static class Edge{
		int start;
		int end;
		int value;
		public Edge(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
	}
}
