package boj.s2.p1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS_인접리스트 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		// 인접 리스트 만들기
		Node[] adjList = new Node[N + 1]; // 1-based
		
		// 모든 간선 정보를 배열에 담기 vertice[i][0]: 출발 노드, vertice[i][1]: 도착 노드
		int[][] vertice = new int[M * 2][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			vertice[i][0] = Integer.parseInt(st.nextToken());
			vertice[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 양방향 처리
		for (int i = M; i < M * 2; i++) {
			vertice[i][0] = vertice[i-M][1];
			vertice[i][1] = vertice[i-M][0];
		}
		
		Arrays.sort(vertice, new Comparator<int[]>() {
			@Override
			// to를 기준으로 내림차순 정렬
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		// 인접 리스트 연결해주기
		for (int i = 0; i < M * 2; i++) {
			adjList[vertice[i][0]] = new Node(vertice[i][1], adjList[vertice[i][0]]);
		}
		
		dfs(adjList, new boolean[N + 1], V, sb);
		sb.append("\n");
		bfs(adjList, N, M, V, sb);

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static void dfs(Node[] adjList, boolean[] visited, int V, StringBuilder sb) {
		
		visited[V] = true;
		sb.append(String.valueOf(V)).append(" ");
		
		for (Node node = adjList[V]; node != null; node = node.next) {
			if(!visited[node.to]) dfs(adjList, visited, node.to, sb);
		}
		
	}

	static void bfs(Node[] adjList, int N, int M, int V, StringBuilder sb) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];

		visited[V] = true;
		queue.offer(V);

		while (!queue.isEmpty()) {
			int to = queue.poll();
			sb.append(String.valueOf(to)).append(" ");

			for (Node node = adjList[to]; node != null; node = node.next) {
				if (!visited[node.to]) {
					visited[node.to] = true;
					queue.offer(node.to);
				}
			}
		}

		sb.append("\n");
	}
}

class Node {
	int to;
	Node next;

	public Node(int to, Node next) {
		super();
		this.to = to;
		this.next = next;
	}
}
