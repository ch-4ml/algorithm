import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
			Queue<int[]> queue = new ArrayDeque<>(); // 검사에 사용할 큐
			Queue<int[]> cabbageQueue = new ArrayDeque<>(); // 양배추 좌표가 들어있는 큐
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
				int[] cabbage = { row, col };
				cabbageQueue.offer(cabbage);
			}
			
			int count = 0;
			while(!cabbageQueue.isEmpty()) {
				int[] cabbage = cabbageQueue.poll();
				if(map[cabbage[0]][cabbage[1]] == 2) continue;
				queue.offer(cabbage);
				while(!queue.isEmpty()) {
					int[] c = queue.poll();
					for(int d = 0; d < 4; d++) {
						int nr = c[0] + dr[d];
						int nc = c[1] + dc[d];
						if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
							map[nr][nc] = 2;
							int[] nextCabbage = { nr, nc };
							queue.offer(nextCabbage);
						}
					}
				}
				count++;
			}
		
			sb.append(count).append("\n");
		}
		
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}