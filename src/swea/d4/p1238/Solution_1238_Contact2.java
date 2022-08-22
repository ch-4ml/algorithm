package swea.d4.p1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1238_Contact2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(in.readLine());
			int E = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			boolean[] visited = new boolean[101];
			Map<Integer, Set<Integer>> adjList = new HashMap<>();
			
			// Draw
			for(int i = 0; i < E / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(!adjList.containsKey(from)) {
					Set<Integer> s = new HashSet<>();
					s.add(to);
					adjList.put(from, s);
				} else {
					adjList.get(from).add(to);
				}
			}
			
			// Find
			Queue<Integer> queue = new ArrayDeque<>();
			visited[V] = true;
			queue.offer(V);
			int max = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				max = Integer.MIN_VALUE;
				while(size-- > 0) {
					int next = queue.poll();
					max = next > max ? next : max;
					if(adjList.containsKey(next)) {
						for(int n: adjList.get(next)) {
							if(!visited[n]) {
								visited[n] = true;
								queue.offer(n);
							}
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
