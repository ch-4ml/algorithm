package swea.d4.p1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1210_Ladder1 {
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] board = new int[100][100];
		int destX = 0, destY = 99;
		for (int t = 1; t <= 10; t++) {
			// Unused N
			in.readLine();
			
			// Draw board
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// Find destination
			for(int i = 0; i < 100; i++) {
				if(board[99][i] == 2) {
					destX = i;
					break;
				}
			}
			
			move(board, 1, destX, destY);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void move(int[][] board, int direction, int x, int y) {
		if (y == 0) {
			result = x;
			return;
		}

		switch (direction) {
		case 1: // 위로
			if (x > 0 && board[y][x - 1] == 1)
				move(board, 2, x - 1, y);
			else if (x < 99 && board[y][x + 1] == 1)
				move(board, 3, x + 1, y);
			else
				move(board, 1, x, y - 1);
			break;
		case 2: // 왼쪽으로
			if (x > 0 && board[y][x - 1] == 1)
				move(board, 2, x - 1, y);
			else
				move(board, 1, x, y - 1);
			break;
		case 3: // 오른쪽으로
			if (x < 99 && board[y][x + 1] == 1)
				move(board, 3, x + 1, y);
			else
				move(board, 1, x, y - 1);
			break;
		}
	}
}
