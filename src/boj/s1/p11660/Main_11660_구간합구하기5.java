package boj.s1.p11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// Draw board
		int[][] board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Draw accumulated row board
		int[][] accRowBoard = new int[N][N];
		for(int i = 0; i < N; i++) {
			accRowBoard[i][0] = board[i][0];
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				accRowBoard[i][j] = accRowBoard[i][j-1] + board[i][j]; 
			}
		}
		
		// Draw accumulated board
		int[][] accBoard = new int[N][N];
		for(int i = 0; i < N; i++) {
			accBoard[0][i] = accRowBoard[0][i];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N; j++) {
				accBoard[i][j] = accBoard[i-1][j] + accRowBoard[i][j];
			}
		}

		// Calculate
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			int result;
			if(x1 == 0 && y1 == 0) {
				result = accBoard[x2][y2];
			} else if(y1 == 0) {
				result = accBoard[x2][y2] - accBoard[x1-1][y2];
			} else if(x1 == 0) {
				result = accBoard[x2][y2] - accBoard[x2][y1-1];
			} else {
				result = accBoard[x2][y2] - accBoard[x2][y1-1] - accBoard[x1-1][y2] + accBoard[x1-1][y1-1];
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
