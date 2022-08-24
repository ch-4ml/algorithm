import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };
		
		int level = 2;
		int exp = 0;
		
		Queue<int[]> queue = new ArrayDeque<>();
		List<int[]> feeds = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				board[i][j] = n; 
				if(n == 9) {
					int[] sPos = { i, j };
					visited[i][j] = true;
					queue.offer(sPos);
					board[i][j] = 0;
				}
			}
		}

		int answer = 0;
		int seconds = 0;
		while(!queue.isEmpty()) {
			int reps = queue.size();

			// 같은 차수동안 반복
			while(reps-- > 0) {
				int[] pos = queue.poll();  // 0: row, 1: col
				
				for(int i = 0; i < 4; i++) {
					int nr = pos[0] + dr[i];
					int nc = pos[1] + dc[i];
					if(nr > -1 && nc > -1 && nr < N && nc < N && !visited[nr][nc] && board[nr][nc] <= level) {
						int[] nPos = { nr, nc };
						visited[nr][nc] = true;
						queue.offer(nPos);
						
						if(board[nr][nc] > 0 && board[nr][nc] < level) {
							feeds.add(nPos);
						}
					}
				}
			}

			seconds++;
			
			// 먹이가 있는 경우
			
			if(!feeds.isEmpty()) {
				feeds.sort(new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
					}
				});
				
				int[] nPos = feeds.get(0);
				queue.clear();
				feeds.clear();
				queue.offer(nPos);
				visited = new boolean[N][N];
				visited[nPos[0]][nPos[1]] = true;
				board[nPos[0]][nPos[1]] = 0;
				if(++exp == level) {
					exp = 0;
					level++;
				}
				answer += seconds;
				seconds = 0;
				
			// 먹이도 없고, 갈 곳도 없는 경우
			} else if(queue.size() == 0) break;
		}
		
		out.write(String.valueOf(answer));
		out.flush();
		out.close();
	}
	
}