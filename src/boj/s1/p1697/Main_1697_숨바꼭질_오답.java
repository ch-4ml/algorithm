package boj.s1.p1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질_오답 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int pos = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int result = pos >= target ? pos - target : bfs(pos, target);
		
		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
	
	static int bfs(int pos, int target) { 
		int breadth = 0;  // 너비
		int size = 0;  // 현재 너비
		int p = 0;
		boolean[] visited = new boolean[100001];
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(pos);
		visited[pos] = true;
		
		while(!queue.isEmpty()) {
			size = queue.size();
			while(size-- > 0) {
				p = queue.poll();
				
				if(p == target) return breadth;
				
				if(p < 100000 && !visited[p + 1]) {
					visited[p + 1] = true;
					queue.offer(p + 1);
				}
				
				if(p > 0 && !visited[p - 1]) {
					visited[p - 1] = true;
					queue.offer(p - 1);
				}
				
				if(p <= 50000 && !visited[p * 2]) {  // Trouble Shooting < 를 <= 로...
					visited[p * 2] = true;
					queue.offer(p * 2);
				}
			}
			breadth++;
		}
		
		return breadth;
	}
}