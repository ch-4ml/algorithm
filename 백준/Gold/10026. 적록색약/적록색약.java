import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(map, visited, i, j);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		
		// 색약
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
		count = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(map, visited, i, j);
					count++;
				}
			}
		}
		sb.append(count);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static void bfs(char[][] map, boolean[][] visited, int row, int col) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		int N = map.length;
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		visited[row][col] = true;
		int[] pos = { row, col };
		queue.offer(pos);
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = p[0] + dr[i];
				int nc = p[1] + dc[i];
				
				if(nr > -1 && nc > -1 && nr < N && nc < N && map[nr][nc] == map[p[0]][p[1]] && !visited[nr][nc]) {
					int[] np = { nr, nc };
					visited[nr][nc] = true;
					queue.offer(np);
				}
			}
		}
	}
}