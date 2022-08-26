import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Vertex {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}
	
	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = 0;
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			
			t++;
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			
			Node[] adjList = new Node[N * N];
			int[] distance = new int[N * N];
			boolean[] visited = new boolean[N * N];
			PriorityQueue<Vertex> pQueue = new PriorityQueue<>(new Comparator<Vertex>() {
				@Override
				public int compare(Vertex o1, Vertex o2) {
					return o1.weight - o2.weight;
				}
			});

			// 인접 리스트 만들기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					distance[i * N + j] = Integer.MAX_VALUE;
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) continue; 
						adjList[i * N + j] = new Node(nr * N + nc, map[nr][nc], adjList[i * N + j]);
					}
				}
			}
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[0] = map[0][0];
			pQueue.offer(new Vertex(0, distance[0]));
			
			int vCount = 0;
			while(!pQueue.isEmpty()) {
				Vertex vertex = pQueue.poll();
				
				if(++vCount == N * N - 1) break;
				visited[vertex.no] = true;
				
				for(Node node = adjList[vertex.no]; node != null; node = node.next) {
					if(!visited[node.vertex] && distance[node.vertex] > distance[vertex.no] + node.weight) {
						distance[node.vertex] = distance[vertex.no] + node.weight;
						pQueue.offer(new Vertex(node.vertex, distance[node.vertex]));
					}
				}
			}
			
			sb.append("Problem ").append(t).append(": ").append(distance[N * N - 1]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}