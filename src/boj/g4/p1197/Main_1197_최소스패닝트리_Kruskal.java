package boj.g4.p1197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리_Kruskal {

	static int[] parents;

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
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[E];

		makeSet(V);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edges);

		int result = 0;
		int count = 0;
		for (int i = 0; i < E; i++) {
			if (union(edges[i].from, edges[i].to)) {
				result += edges[i].weight;
				if (++count == V - 1)
					break;
			}
		}

		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}

	static void makeSet(int N) {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int x) {
		if (parents[x] == x)
			return x;
		else
			return parents[x] = findSet(parents[x]);
	}

	static boolean union(int x, int y) {
		if (findSet(x) == findSet(y))
			return false;
		parents[findSet(y)] = parents[findSet(x)];
		return true;
	}
}
