package boj.g5.p7576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] box = new int[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				box[i][j] = tomato;
				if(tomato == 1) {
					int[] tPos = { i, j };
					queue.offer(tPos);
				}
			}
		}
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				int[] tPos = queue.poll();
				for(int i = 0; i < 4; i++) {
					int nr = tPos[0] + dr[i];
					int nc = tPos[1] + dc[i];
					if(nr > -1 && nc > -1 && nr < N && nc < M && box[nr][nc] == 0) {
						int[] newPos = { nr, nc };
						box[nr][nc] = 1;
						queue.offer(newPos);
					}
				}
			}
			count++;
		}
		
		int zCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) zCount++;
			}
		}
		
		out.write(zCount == 0 ? String.valueOf(count - 1) : String.valueOf(-1));
		out.flush();
		out.close();
	}
}
