package boj.g5.p13023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {

	static boolean result;

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// 인접 리스트 만들기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] adjList = new Node[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

		// 0번부터 차례로 DFS 탐색
		for (int i = 0; i < N; i++) {
			dfs(adjList, i, new boolean[N], 0);
			if(result) break;
		}

		out.write(result ? "1" : "0");
		out.flush();
		out.close();
	}

	static void dfs(Node[] adjList, int cur, boolean[] visited, int depth) {
		if (depth == 4) {
			result = true;
			return;
		}
		
		visited[cur] = true;
		
		for (Node node = adjList[cur]; node != null; node = node.next) {
			if (!visited[node.to]) {
				dfs(adjList, node.to, visited, depth + 1);
				visited[node.to] = false;
			}
		}
	}
}
