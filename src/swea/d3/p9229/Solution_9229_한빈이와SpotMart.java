package swea.d3.p9229;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {

	static int max;
	static int N, M;
	static int[] weights;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			max = -1;
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			weights = new int[N];
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			combination(2, new int[2], 0);
			sb.append(max).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static void combination(int left, int[] comb, int startIndex) {
		if (left == 0) {
			int result = comb[0] + comb[1];
			if (result <= M)
				max = Math.max(max, result);
			return;
		}

		for (int i = startIndex; i < N; i++) {
			comb[2 - left] = weights[i];
			combination(left - 1, comb, i + 1);
		}
	}
}
