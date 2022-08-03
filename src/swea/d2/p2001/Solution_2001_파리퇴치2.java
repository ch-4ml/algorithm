package swea.d2.p2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t < T + 1; t++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] board = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 부분합
			int[][] accumulator = new int[N][N];
			accumulator[0][0] = board[0][0];
			for (int i = 1; i < N; i++) {
				accumulator[0][i] = accumulator[0][i - 1] + board[0][i];
			}
			for (int i = 1; i < N; i++) {
				accumulator[i][0] = accumulator[i - 1][0] + board[i][0];
			}
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					accumulator[i][j] = accumulator[i - 1][j] + accumulator[i][j - 1] + board[i][j]
							- accumulator[i - 1][j - 1];
				}
			}

			// 최대값 구하기
			int max = accumulator[M - 1][M - 1];
			for (int i = M; i < N; i++) {
				max = Math.max(accumulator[M - 1][i] - accumulator[M - 1][i - M], max);
			}
			for (int i = M; i < N; i++) {
				max = Math.max(accumulator[i][M - 1] - accumulator[i - M][M - 1], max);
			}
			for (int i = M; i < N; i++) {
				for (int j = M; j < N; j++) {
					max = Math.max(accumulator[i][j] - accumulator[i - M][j] - accumulator[i][j - M]
							+ accumulator[i - M][j - M], max);
				}
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
