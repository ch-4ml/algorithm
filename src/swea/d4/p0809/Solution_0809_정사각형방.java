package swea.d4.p0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_0809_정사각형방 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// DFS로 각 방의 이동 가능성을 따져보며 탐색
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		// 오른쪽, 아래, 왼쪽, 위
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Stack<int[]> stack;
		int N, x = 0, y = 0, nx = 0, ny = 0, depth = 0;
		int[] pos;
		int[][] rooms, count;
		boolean[][] isVisited;
		for (int t = 1; t < T + 1; t++) {
			N = Integer.parseInt(in.readLine());
			rooms = new int[N][N];
			count = new int[N][N];
			isVisited = new boolean[N][N];
			stack = new Stack<>();
			// 방 배열 만들기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// DFS
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isVisited[i][j]) continue;
					pos = new int[2];
					pos[0] = j;
					pos[1] = i;
					stack.push(pos);
					isVisited[i][j] = true;
					
					dfs:
					while (stack.size() > 0) {						
						// 현재 좌표 설정
						pos = stack.peek();
						x = pos[0];
						y = pos[1];
						
						// 사방 탐색
						for (int d = 0; d < 4; d++) {
							// 범위 밖으로 나가는 경우 continue
							if (y + dy[d] < 0 || x + dx[d] < 0 || y + dy[d] > N - 1 || x + dx[d] > N - 1) continue;
							nx = x + dx[d];
							ny = y + dy[d];
							
							
							// 현재 방 숫자보다 다음 방 숫자가 큰 경우 그 방으로 이동 (스택에 push)
							if (rooms[ny][nx] - rooms[y][x] == 1) {
								
								// 이동하려는 방을 이미 방문한 경우
								if (isVisited[ny][nx]) {
									count[y][x] = count[ny][nx] + 1;
									while(stack.size() > 0) stack.pop();
									break dfs;
								}
								
								pos = new int[2];
								pos[0] = nx;
								pos[1] = ny;
								stack.push(pos);
								isVisited[ny][nx] = true;
								continue dfs;
							} 
							
							// 없는 경우 다음 방향 탐색
						}
						
						// 모든 방향을 탐색한 경우 제자리로 돌아올 때까지 방에서 빠져나오기 (스택에서 pop)
						depth = 0;
						while(stack.size() > 0) {
							pos = stack.pop();
							count[pos[1]][pos[0]] = ++depth;
						}
					}
				}
			}
			
			// Get result
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(count[i][j] > max) {
						max = count[i][j];
						x = j;
						y = i;
					} else if(count[i][j] == max) {
						if(rooms[i][j] < rooms[y][x]) {
							x = j;
							y = i;
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(rooms[y][x]).append(" ").append(count[y][x]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
