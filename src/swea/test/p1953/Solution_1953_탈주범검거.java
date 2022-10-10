package swea.test.p1953;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 시계 방향. 0: 상, 1: 우, 2: 하, 3: 좌
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 터널 구조물 종류별 갈 수 있는 방향
		int[][] tunnels = {
							{},
							{ 0, 1, 2, 3 },
							{ 0, 2 },
							{ 1, 3 },
							{ 0, 1 },
							{ 1, 2 },
							{ 2, 3 },
							{ 0, 3 }
						  };

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken()); // N ROWS
			int M = Integer.parseInt(st.nextToken()); // COLS
			int R = Integer.parseInt(st.nextToken()); // Row of Manhole
			int C = Integer.parseInt(st.nextToken()); // Col of Manhole
			int L = Integer.parseInt(st.nextToken()); // Time
			
			// draw map
			int[][] map = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// logic
			int count = 0; // 탈주범이 위치할 수 있는 장소 수
			boolean[][] visited = new boolean[N][M]; // 방문 검사
			Queue<int[]> queue = new ArrayDeque<>(); // 좌표 값이 들어갈 큐
			int[] manhole = { R, C }; // 맨홀 위치를 큐에 담기
			queue.add(manhole);
			while(queue.isEmpty()) {
				int size = queue.size();
				while(size-- > 0) {
					
				}
				
			}
		}
	
		
	}
}
