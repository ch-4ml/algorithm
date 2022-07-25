package boj.s2.p2615;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615_오목 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/boj/s2/p2615/input.txt"))));
		StringTokenizer st = null;
		int N = 19;
		int[][] board = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		boolean result = false;

		// 보드 그리기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		inspect: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0) {
					if (!visited[i][j]) {
						result = inspect(board, visited, j, i);
						if (result) {
							System.out.println(board[i][j]);
							System.out.println((int) (i + 1) + " " + (int) (j + 1));
						}
						break inspect;
					}
				}
			}
		}

		if (!result)
			System.out.println(0);
		in.close();
	}

	public static boolean inspect(int[][] board, boolean[][] visited, int x, int y) {
		// 오른쪽 위, 오른쪽, 오른쪽 아래, 아래
		int[] dx = { 1, 1, 1, 0 };
		int[] dy = { -1, 0, 1, 1 };
		int dSize = dx.length;
		int count, nx, ny;
		int color = board[y][x];
		boolean result = false;

		// 검사
		for (int i = 0; i < dSize; i++) {
			nx = x;
			ny = y;
			count = 1;
			result = false;

			while (count < 6) {
				// 새로운 돌 위치
				nx = nx + dx[i];
				ny = ny + dy[i];

				// 경계 조건 검사
				if (nx < 0 || ny < 0 || nx > board.length - 1 || ny > board.length - 1)
					break;

				count++;

				// 돌 연속 검사
				if (board[ny][nx] == color) {
					if (count == 5)
						result = true;
				} else
					break;

				// 6목 검사
				if (count == 6 && board[ny][nx] == color)
					result = false;
			}

			nx = x;
			ny = y;
			for (int j = 0; j < count; j++) {
				visited[ny][nx] = true;
				nx = nx + dx[i];
				ny = ny + dy[i];
			}

			if (result)
				break;
		}

		return result;
	}

}
