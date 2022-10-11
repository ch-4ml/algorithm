package swea.test.p4014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
	
	static int N, X;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				answer += checkRow(i);
				answer += checkCol(i);
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static int checkRow(int row) {
		int count = 1;
		boolean checkedLeft = false;
		for (int col = 1; col < N; col++) {
			if (map[row][col] == map[row][col - 1]) count++;
			else if (count >= X && map[row][col] == map[row][col - 1] + 1) return 1;
			else {
				count = 1;
				checkedLeft = false;
			}
			
			if (!checkedLeft && count >= X) {
				if (col - count >= 0 && map[row][col - count] == map[row][col - count + 1] + 1)
					return 1;
				else checkedLeft = true;
			}
		}
		return 0;
	}
	
	static int checkCol(int col) {
		int count = 1;
		boolean checkedUp = false;
		for (int row = 1; row < N; row++) {
			if (map[row][col] == map[row - 1][col]) count++;
			else if (count >= X && map[row][col] == map[row - 1][col] + 1) return 1;
			else {
				count = 1;
				checkedUp = false;
			}
			
			if (!checkedUp && count >= X) {
				if (row - count >= 0 && map[row - count][col] == map[row - count + 1][col] + 1)
					return 1;
				else checkedUp = true;
			}
		}
		return 0;
	}
}
