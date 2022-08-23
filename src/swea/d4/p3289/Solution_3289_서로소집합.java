package swea.d4.p3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 서로소 집합 만들기
			int[] parent = new int[N + 1];
			for (int i = 0; i < N; i++) {
				makeSet(parent, i);
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int operator = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(operator == 0) {
					union(parent, a, b);
				} else {
					sb.append(checkSet(parent, a, b) ? "1" : "0");
				}
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static void makeSet(int[] parent, int x) {
		parent[x] = x;
	}

	static int findSet(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findSet(parent, parent[x]);
	}

	// x를 y에 합치기
	static boolean union(int[] parent, int x, int y) {
		if (findSet(parent, x) == findSet(parent, y))
			return false;
		parent[findSet(parent, y)] = parent[findSet(parent, x)];
		return true;
	}
	
	static boolean checkSet(int[] parent, int x, int y) {
		return findSet(parent, x) == findSet(parent, y);
	}
}
