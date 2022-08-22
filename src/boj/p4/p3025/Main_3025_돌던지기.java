package boj.p4.p3025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3025_돌던지기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R + 1][C + 1];
		
		// 각 column으로 돌멩이가 떨어지면 굴러 떨어질 좌표를 저장해놓는 변수
		int[][] dp = new int[C + 1][2];

		for (int i = 1; i < C + 1; i++) {
			dp[i][0] = R;
			dp[i][1] = C;
		}

		for (int i = 1; i < R + 1; i++) {
			String rows = in.readLine();
			for (int j = 1; j < C + 1; j++) {
				char c = rows.charAt(j - 1);
				if (c == 'X') {
					dp[j][0] = i - 1;
					dp[j][1] = j;
				}
				map[i][j] = c;
			}
		}

		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			int col = Integer.parseInt(in.readLine());

			// logic
			if(dp[col][0] > 0) map[dp[col][0]][dp[col][1]] = 'O';

			dp[col] = dfs(dp, col);
		}

		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	// 돌이 멈추는 위치를 찾아서 각 col에 해당하는 dp 값(dp[c][0], dp[c][1]) 변경
	static int[] dfs(int[][] dp, int col) {
		
		// 종료 조건 추가
		
		if (col > 1 && dp[col - 1][0] >= dp[col][0]) {
			// 현재 col에 대한 dp 최신화
			dp[col][0] = dp[col - 1][0];
			dp[col][1] = col - 1;

			// 영향을 받는 col에 대한 dp 최신화
			return dp[col] = dfs(dp, col - 1);
			
		} else if (col < dp.length && dp[col + 1][0] >= dp[col][0]) {
			// 현재 col에 대한 dp 최신화
			dp[col][0] = dp[col + 1][0];
			dp[col][1] = col + 1;
			
			// 영향을 받는 col에 대한 dp 최신화
			return dp[col] = dfs(dp, col + 1);
		} else {
			int[] result = new int[2];
			result[0] = --dp[col][0];
			result[1] = col;
			return result;
		}
	}
}
