package swea.d4.p7465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {
	
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			makeSet(N);
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int A = Integer.parseInt(st.nextToken()); 
				int B = Integer.parseInt(st.nextToken());
				union(A, B);
			}
			
			for(int i = 1; i <= N; i++) {
				findSet(i);
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				set.add(parent[i]);
			}
			
			sb.append("#").append(t).append(" ").append(set.size()).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static void makeSet(int N) {
		parent = new int[N + 1];
		for(int i = 1, size = parent.length; i < size; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		if(findSet(x) == findSet(y)) return;
		parent[findSet(y)] = parent[findSet(x)];
	}
}
