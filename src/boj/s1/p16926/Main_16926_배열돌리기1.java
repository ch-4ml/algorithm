package boj.s1.p16926;

import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;

public class Main_16926_배열돌리기1 {
	
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// x, y, depth, 회전 수를 이용해서 재귀
		rotate(board, M, N, 0, R);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	private static void rotate(int[][] board, int x, int y, int depth, int r) {
	
		if(x < 2 || y < 2) return;
	
		int px = depth;
		int py = depth;
		int d = 0;
		
		// 큐에 회전시키려는 숫자 담기
		Queue<Integer> queue = new ArrayDeque<>();
		while(d < 4) {
			queue.add(board[py][px]);
			px = px + dx[d];
			py = py + dy[d];
			if(px + dx[d] > depth + x - 1) d++;
			else if(py + dy[d] > depth + y - 1) d++;
			else if(px + dx[d] < depth) d++;
			else if(py + dy[d] < depth) d++;
		}
		
		// 큐를 Rotate만큼 회전
		for(int i = 0; i < r; i++) {
			queue.offer(queue.poll());
		}
		
		// 회전한 큐의 원소를 board에 순서대로 담기
		d = 0;
		while(d < 4) {
			board[py][px] = queue.poll();
			px = px + dx[d];
			py = py + dy[d];
			if(px + dx[d] > depth + x - 1) d++;
			else if(py + dy[d] > depth + y - 1) d++;
			else if(px + dx[d] < depth) d++;
			else if(py + dy[d] < depth) d++;
		}
		
		rotate(board, x - 2, y - 2, depth + 1, r);
	}
}
