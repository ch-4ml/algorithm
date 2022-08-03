package swea.d2.p1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {
	static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int[][] board;
		int n;
		for (int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append("\n");
			n = Integer.parseInt(in.readLine());
			size = n;
			board = new int[n][n];
			write(board, 1, 0, 0, 1);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	// direction: 1. 오른쪽 2. 아래 3. 왼쪽 4. 위
	static void write(int[][] board, int direction, int x, int y, int value) {
		board[y][x] = value;
		switch (direction) {
		case 1:
			if (x + 1 < size && board[y][x + 1] == 0)
				write(board, 1, x + 1, y, ++value);
			else if (y + 1 < size && board[y + 1][x] == 0)
				write(board, 2, x, y + 1, ++value);
			else
				return;
			break;
		case 2:
			if (y + 1 < size && board[y + 1][x] == 0)
				write(board, 2, x, y + 1, ++value);
			else if (x - 1 > -1 && board[y][x - 1] == 0)
				write(board, 3, x - 1, y, ++value);
			else
				return;
			break;
		case 3:
			if (x - 1 > -1 && board[y][x - 1] == 0)
				write(board, 3, x - 1, y, ++value);
			else if (y - 1 > -1 && board[y - 1][x] == 0)
				write(board, 4, x, y - 1, ++value);
			else
				return;
			break;
		case 4:
			if (y - 1 > -1 && board[y - 1][x] == 0)
				write(board, 4, x, y - 1, ++value);
			else if (x + 1 < size && board[y][x + 1] == 0)
				write(board, 1, x + 1, y, ++value);
			else
				return;
			break;
		}
	}
}
