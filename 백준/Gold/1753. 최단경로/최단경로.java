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
		int no, weight;
		Node next;

		public Node(int no, int weight, Node next) {
			super();
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(in.readLine());

		int[] D = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Node[] adjList = new Node[V + 1];
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>(new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.weight - o2.weight;
			}
		}); 
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;
		pQueue.offer(new Vertex(start, 0));
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		while(!pQueue.isEmpty()) {			
			Vertex vertex = pQueue.poll();
			visited[vertex.no] = true;
			
			// 현재 탐색하고 있는 노드를 경유지로 했을 때 거리와 기존 최적 거리를 비교, 갱신
			for(Node node = adjList[vertex.no]; node != null; node = node.next) {
				if(!visited[node.no] && D[node.no] > D[vertex.no] + node.weight) {
					D[node.no] = D[vertex.no] + node.weight; 
					pQueue.offer(new Vertex(node.no, D[node.no]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			sb.append(D[i] < Integer.MAX_VALUE ? D[i] : "INF").append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}