import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] dr = { -1, 0, 1, 0 }; // 사방 처리, 반시계방향 들어가는 처리, 시계방향 들어가는 처리(-1 곱해서)
		int[] dc = { 0, 1, 0, -1 };

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		int[][] spreadMap = null;
		int[] ap = new int[2]; // 공기청정기 아래 부분 좌표

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == -1) {
					ap[0] = i;
					ap[1] = j;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			spreadMap = new int[R][C];
			// 확산량 계산 및 확산 맵에 기록
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0)
						continue;
					int nr, nc, count = 0;
					int spreadAmount = map[i][j] / 5;
					// 확산 계산
					for (int k = 0; k < 4; k++) {
						nr = i + dr[k];
						nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr > R - 1 || nc > C - 1 || ((nr == ap[0] || nr == ap[0] - 1) && nc == ap[1]))
							continue;
						count++;
						spreadMap[nr][nc] += spreadAmount;
					}

					// 현재 위치에 남는 양 계산
					spreadMap[i][j] += map[i][j] - spreadAmount * count;
				}
			}
			
//			System.out.println();
//			
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) { 
//					System.out.print(spreadMap[i][j] + " ");
//				}
//				System.out.println();
//			}

			// 확산 맵에 있는 데이터를 적용
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = spreadMap[i][j];
				}
			}

			// 순환
			// 위쪽 반시계 순환
			int r = ap[0] - 2;
			int c = ap[1];
			int d = 0;
			map[r][c] = 0;
			while(d < 4) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				map[r][c] = map[nr][nc];
				r = nr;
				c = nc;
				if(r == 0 && c == 0) d++;
				else if(r == 0 && c == C - 1) d++;
				else if(r == ap[0] - 1 && c == C - 1) d++;
				else if(r == ap[0] - 1 && c == 1) d++;
			}
			map[ap[0] - 1][ap[1] + 2] = map[ap[0] - 1][ap[1] + 1];
			map[ap[0] - 1][ap[1] + 1] = 0;
			
			// 아래쪽 시계 순환
			r = ap[0] + 1;
			c = ap[1];
			d = 0;
			map[r][c] = 0;
			while(d < 4) {
				int nr = r + dr[d] * -1;
				int nc = c + dc[d];
				map[r][c] = map[nr][nc];
				r = nr;
				c = nc;
				if(r == R - 1 && c == 0) d++;
				else if(r == R - 1 && c == C - 1) d++;
				else if(r == ap[0] && c == C - 1) d++;
				else if(r == ap[0] && c == 1) d++;
			}
			map[ap[0]][ap[1] + 2] = map[ap[0]][ap[1] + 1];
			map[ap[0]][ap[1] + 1] = 0;
		}		
		
		int result = 0;
		map[ap[0]][ap[1]] = 0;
		map[ap[0] - 1][ap[1]] = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) { 
				result += map[i][j];
			}
		}
		
//		System.out.println();
//		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) { 
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
}