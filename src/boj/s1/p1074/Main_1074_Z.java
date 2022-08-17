package boj.s1.p1074;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1074_Z {
	static int count;
	static int[] dc = { 0, 1, 0, 1 };
	static int[] dr = { 0, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int targetRow = Integer.parseInt(st.nextToken());
		int targetCol = Integer.parseInt(st.nextToken());
		find((int) Math.pow(2, N), 0, 0, targetRow, targetCol);
		out.write(String.valueOf(count));
		out.flush();
		out.close();
	}

	public static void find(int n, int r, int c, int targetRow, int targetCol) {
		// 재귀 탐색
		for (int i = 0; i < 4; i++) {
			// 나누어지는 사각형의 범주에 target의 position이 존재하지 않는 경우
			if (targetRow < r || targetRow >= r + n || targetCol < c || targetCol >= c + n || n == 1) {
				// 사각형의 크기만큼 더하기
				count += n * n;
				return;
			} else find(n / 2, r + dr[i] * n / 2, c + dc[i] * n / 2, targetRow, targetCol);
		}
	}
}
