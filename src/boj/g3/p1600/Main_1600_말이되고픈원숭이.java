package boj.g3.p1600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H + 1][W + 1];
		
		// Dynamic table
		// H, W 위치에서 말처럼 움직인 횟수가 K일 때 최소 동작 수
		int inf = 40000;
		int[][][] dt = new int[H][W][K];
		
		for(int i = 1; i <= H; i++) {
			st = new StringTokenizer(st.nextToken());
			for(int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 위쪽부터 시계방향으로 8방향 이동
		// 상 | 우상 | 우 | 우하 | 하 | 하좌 | 좌 | 좌상
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
		
		// 말의 움직임 체크(위 + 대각선 오른쪽 위 부터 시계방향으로 8방향)
		int[][] dh = { { 0, 1 }, { 2, 1 }, { 2, 3 }, { 4, 3 }, { 4, 5 }, { 6, 5 }, { 6, 7 }, { 0, 7 } };
		
		
		// logic
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 1) continue;
				dt[i][j][0] = Math.min(dt[i-1][j][0], dt[i][j-1][0]) + 1;
			}
		}
		
		int ans = Math.min(a, b);
		out.write(ans == inf ? "-1" : ans + "");
	}
	
	static boolean checkBoundary(int r, int c, int R, int C) {
		return r > 0 && c > 0 && r <= R && c <= C;
	}
}
