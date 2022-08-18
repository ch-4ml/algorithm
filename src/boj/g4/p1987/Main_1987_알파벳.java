package boj.g4.p1987;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main_1987_알파벳 {
	
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			board[i] = in.readLine().toCharArray();
		}
		
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		dfs(0, 0, 0, R, C, new boolean[26], new boolean[R][C], board, dr, dc);
		out.write(String.valueOf(max));
		out.flush();
		out.close();
	}
	
	static void dfs(int r, int c, int count, int R, int C, boolean[] used, boolean[][] visited, char[][] board, int[] dr, int[] dc) {
		
		if(visited[r][c] || used[board[r][c] - 65]) {
			max = max > count ? max : count;
			return;
		}
		
		visited[r][c] = true;
		used[board[r][c] - 65] = true;
		
		for(int i = 0; i < 4; i++) {
			if(r + dr[i] < 0 || r + dr[i] > R - 1 || c + dc[i] < 0 || c + dc[i] > C - 1) continue;
			dfs(r + dr[i], c + dc[i], count + 1, R, C, used, visited, board, dr, dc);
		}

		visited[r][c] = false;
		used[board[r][c] - 65] = false;
	}
}
