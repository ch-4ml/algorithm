package boj.p4.p3025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3025_돌던지기 {
	
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		boolean checkSame(Pos p) {
			return p.r == this.r && p.c == this.c;
		}
	}
	
	static char[][] map;
	static Pos[] ps;
	static int[] nextRow;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		// 각 column으로 돌멩이가 떨어지면 굴러 떨어질 위치를 저장해놓는 변수
		ps = new Pos[C + 1];
		nextRow = new int[C + 1];

		// 모든 column에 대해 바닥으로 떨어지는 상태로 초기화
		for (int i = 1; i < C + 1; i++) {
			ps[i].r = R;
			ps[i].c = i;
			nextRow[i] = R;
		}

		// 지도 그리기 및 장애물을 돌멩이가 떨어질 위치 배열에 반영
		for (int i = 1; i < R + 1; i++) {
			String rows = in.readLine();
			for (int j = 1; j < C + 1; j++) {
				char status = rows.charAt(j - 1);
				if (status == 'X') {
					ps[j].r = i - 1;
					nextRow[j] = i - 1;
				}
				map[i][j] = status;
			}
		}

		// 돌 굴리기 N회
		int N = Integer.parseInt(in.readLine());

		// 돌 굴리기 반복
		for (int i = 0; i < N; i++) {
			
			// 돌 굴릴 column
			int col = Integer.parseInt(in.readLine());

			// 돌 굳음 처리
			if(ps[col].r > 0) map[ps[col].r][ps[col].c] = 'O';
			
			// nextRow 처리
			while(nextRow[col] > 0) {
				if(map[nextRow[col]--][col] == '.') {
					break;
				}
			}
			
			// 이 col로 돌을 굴렸을 때 떨어질 위치를 최신화 
			for(int j = 1; j <= C; j++) {
				if(ps[col].checkSame(ps[j])) {
					dfs(j);
				}
			}
		}

		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	
	static void dfs(int col) {
		
		if (col > 1 && nextRow[col] < nextRow[col - 1]) {
			dfs(col - 1);
		} else if (col < ps.length - 1 && nextRow[col + 1] > nextRow[col]) {
			dfs(col + 1);
		} else {
			ps = 
		}	
	}
}





//System.out.println(dp[col - 1][0] +
//		" " + dp[col][0] +
//		" " + dp[col + 1][0]);






//System.out.println("-------");
//for (int i = 1; i < R + 1; i++) {
//	for (int j = 1; j < dp.length; j++) {
//		System.out.print(map[i][j]);
//	}
//	System.out.println();
//}
//
//System.out.println("------");
//for (int i = 1; i < dp.length; i++) {
//	System.out.println(Arrays.toString(dp[i]));
//}
//System.out.println();
