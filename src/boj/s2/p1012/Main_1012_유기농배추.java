package boj.s2.p1012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] dr = { -1, 0, 1 ,0 };
		int[] dc = { 0, 1, 0 ,-1 };
		
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken()); // col
			int N = Integer.parseInt(st.nextToken()); // row
			int K = Integer.parseInt(st.nextToken()); // count of cabbage
			int[][] map = new int[N][M]; // 0: 배추 x, 1: 배추, 2: 배추흰지렁이 검사 완료
			Queue<int[]> queue = new ArrayDeque<>();
			int[] pos = new int[2];
			int[] curPos = new int[2];
			int[] nextPos = new int[2];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {						
						pos[0] = i;
						pos[1] = j;
						queue.offer(pos);
						while(!queue.isEmpty()) {;
							curPos = queue.poll();
							map[curPos[0]][curPos[1]] = 2;
							for(int d = 0; d < 4; d++) {
								int nr = curPos[0] + dr[d];
								int nc = curPos[1] + dc[d];
								if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
									nextPos[0] = nr;
									nextPos[1] = nc;
									queue.offer(nextPos);
								}
							}
							
						}
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
