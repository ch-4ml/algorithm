package swea.d4.p3124;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	
	static int[] parent;
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t < T + 1; t++) {
			st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			parent = new int[V + 1];
			for(int i = 1; i <= V; i++) {
				makeSet(i); // Vertex가 1부터 V까지 일까? 
			}
			
			Edge[] edges = new Edge[E];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// weight 기준 오름차순 정렬
			Arrays.sort(edges);
			
			long result = 0, count = 0;
			for(Edge edge: edges) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++count == V - 1) break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static void makeSet(int x) {
		parent[x] = x;
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x, int y) {
		if(findSet(x) == findSet(y)) return false;
		parent[findSet(y)] = parent[findSet(x)];
		return true;
	}
}
