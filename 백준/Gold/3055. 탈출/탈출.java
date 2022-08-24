import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		
		int[] s = null;

		Queue<int[]> waterQueue = new ArrayDeque<>();
		Queue<int[]> hedgeQueue = new ArrayDeque<>();
		
		for(int i = 0; i < R; i++) {
			String str = in.readLine();
			for(int j = 0; j < C; j++) {
				char status = str.charAt(j);
				map[i][j] = status;
				if(status == 'S') {
					int[] sPos = { i, j };
					s = sPos;
				}
				if(status == '*') {
					int[] wPos = { i, j };
					waterQueue.offer(wPos);
				}
			}
		}
		
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		visited[s[0]][s[1]] = true;
		hedgeQueue.offer(s);

		int count = 0;
		boolean result = false;
		search:
		while(!hedgeQueue.isEmpty()) {
			int wSize = waterQueue.size();
			while(wSize-- > 0) {
				int[] h = waterQueue.poll(); 
				for(int i = 0; i < 4; i++) {
					int nr = h[0] + dr[i];
					int nc = h[1] + dc[i];
					if(nr > -1 && nc > -1 && nr < R && nc < C && map[nr][nc] == '.') {
						int[] wPos = { nr, nc };
						map[nr][nc] = '*';
						waterQueue.offer(wPos);
					}
				}
			}

			int hSize = hedgeQueue.size();
			while(hSize-- > 0) {
				int[] h = hedgeQueue.poll();
 
				if(map[h[0]][h[1]] == 'D') {
					result = true;
					break search;
				}
				
				for(int i = 0; i < 4; i++) {
					int nr = h[0] + dr[i];
					int nc = h[1] + dc[i];
					if(nr > -1 && nc > -1 && nr < R && nc < C && map[nr][nc] != '*' && map[nr][nc] != 'X' && !visited[nr][nc]) {
						int[] hPos = { nr, nc };
						visited[nr][nc] = true;
						hedgeQueue.offer(hPos);
					}
				}
			}
			count++;
		}
		
		out.write(result ? String.valueOf(count) : "KAKTUS");
		out.flush();
		out.close();
	}
}