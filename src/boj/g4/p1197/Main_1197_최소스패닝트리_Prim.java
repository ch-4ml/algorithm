package boj.g4.p1197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리_Prim {

	static class Vertex {
		int no, weight;
		Vertex next; 

		public Vertex(int no, int weight, Vertex next) {
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
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Vertex[] adjList = new Vertex[V];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Vertex(to, weight, adjList[from]);
			adjList[to] = new Vertex(from, weight, adjList[to]);
		}
		
		int[] minWeight = new int[V];
		boolean[] visited = new boolean[V];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		
		minWeight[0] = 0;
		
		int result = 0;
		for(int i = 0; i < V; i++) {
			// 1. 아직 MST에 포함되지 않은 애들 중 가중치 최소 연결 노드 찾기
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			
			for(int j = 0; j < V; j++) {
				if(!visited[j] && min > minWeight[j]) {
					min = minWeight[j];
					minIdx = j;
				}
			}
			
			// 2. MST에 포함
			visited[minIdx] = true;
			result += min;
			
			// 3. MST에 추가되는 노드로부터 연결되는 노드들 가중치 비교 및 갱신
			for(Vertex v = adjList[minIdx]; v != null; v = v.next) {
				if(!visited[v.no] && minWeight[v.no] > v.weight) minWeight[v.no] = v.weight;
			}
		}
		
		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
}
