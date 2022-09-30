package boj.g5.p17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N + 1][N + 1];
		// 현재 칸에 파이프가 (가로 / 대각선 / 세로)로 위치할 수 있는 모든 경우의 수
		int[][][] dt = new int[N + 1][N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dt[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] > 0) // 검사하는 위치가 벽인 경우
					continue;
				dt[i][j][0] += dt[i][j - 1][0] + dt[i][j - 1][1];
				if (map[i - 1][j] == 0 && map[i][j - 1] == 0)
					dt[i][j][1] += dt[i - 1][j - 1][0] + dt[i - 1][j - 1][1] + dt[i - 1][j - 1][2];
				dt[i][j][2] += dt[i - 1][j][1] + dt[i - 1][j][2];
			}
		}

		int ans = dt[N][N][0] + dt[N][N][1] + dt[N][N][2];
		out.write(ans + "");
		out.flush();
		out.close();
	}
}
