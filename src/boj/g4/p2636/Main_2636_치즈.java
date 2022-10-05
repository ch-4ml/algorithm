package boj.g4.p2636;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] board = new int[R][C];
		Queue<int[]> queue = new ArrayDeque<>();
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				if(num == 1) {
					int[] pos = { i, j };
					queue.add(pos);
				}
			}
		}
		
		while(!queue.isEmpty()) {
			
		}
		
		
		
	}
}
