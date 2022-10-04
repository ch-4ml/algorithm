package swea.d4.p7194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_7194_화섭이의미생물배양 {

	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			int s, t, a, b;
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;

			if (b == 1) {
				if ((t - s) % a == 0) {
					min = (t - s) / a;
				}
			} else {
				dfs(0, s, t, a, b);
			}

			sb.append("#").append(tc).append(" ").append(min == Integer.MAX_VALUE ? -1 : min).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void dfs(int cnt, int s, int t, int a, int b) {
		if (t == s) {
			min = Math.min(cnt, min);
			return;
		}
		
		if (t < s)
			return;

		if (cnt > min)
			return;

		if (t % b == 0 && t / b >= s) {
			dfs(cnt + 1, s, t / b, a, b);
		} else {			
			dfs(cnt + 1, s, t - a, a, b);
		}
	}
}
