package boj.g4.p17471;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {

	static int N;
	static Node[] adjList;
	
	static class Node {
		int id;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.id = vertex;
			this.next = next;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		int[] areas = new int[N + 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			areas[i] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int v = Integer.parseInt(st.nextToken());
			for (int j = 0; j < v; j++) {
				adjList[i] = new Node(Integer.parseInt(st.nextToken()), adjList[i]); 
			}
		}
		
		int min = Integer.MAX_VALUE;
		boolean isAvailable = false;

		// 부분집합
		for (int i = 0; i < (1 << N); i++) {
			// 같은 케이스는 검사하지 않음
			if (i == ((1 << N) / 2)) break;
			
			// 지역구 1, 2 나누기
			List<Integer> areas1 = new ArrayList<>();
			List<Integer> areas2 = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) > 0) {
					areas1.add(j + 1);
				} else {
					areas2.add(j + 1);
				}
			}
			
			// 지역구 1, 2의 연결성 검사
			if(areas1.isEmpty() || areas2.isEmpty()) continue;
			if(!checkConnection(areas1) || !checkConnection(areas2)) continue;
			isAvailable = true;

			// 차이 구하기
			int sum1 = 0;
			for(int j = 0, size = areas1.size(); j < size; j++) {
				sum1 += areas[areas1.get(j)];
			}
			
			int sum2 = 0;
			for(int j = 0, size = areas2.size(); j < size; j++) {
				sum2 += areas[areas2.get(j)];
			}
			
			min = Integer.min(min, Math.abs(sum1 - sum2));
		}
		
		out.write(isAvailable ? min + "" : "-1");
		out.flush();
		out.close();
	}
	
	static boolean checkConnection(List<Integer> areas) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		
		// deep copy
		List<Integer> tempAreas = new ArrayList<>();
		for(int i = 0, s = areas.size(); i < s; i++) {
			tempAreas.add(areas.get(i));
		}
		
		queue.offer(areas.get(0)); // Node id
		tempAreas.remove(0); // index
		
		// 인접 리스트를 탐색하면서 연결된 모든 노드 검사
		while(!queue.isEmpty()) {
			int id = queue.poll();
			
			for (int i = tempAreas.size() - 1; i >= 0; i--) {
				if (tempAreas.get(i) == id) {
					tempAreas.remove(i);
				}
			}
			
			if(tempAreas.size() == 0) return true;
			
			for (Node node = adjList[id]; node != null; node = node.next) {
				if(visited[node.id] || !areas.contains(node.id)) continue;  // 여기 때문에 틀렸었음
				visited[node.id] = true;
				queue.offer(node.id);
			}
		}
		
		return false;
	}
}
