package swea.d3.p2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int result;
		for(int t = 1; t < T+1; t++) {
			result = 0;
			int N = Integer.parseInt(in.readLine());
			char[][] board = new char[N][N];
			for(int i = 0; i < N; i++) {
				board[i] = in.readLine().toCharArray();
			}
			
			int s, f;
			int weight = 0;
			for(int i = 0; i < N; i++) {
				s = N / 2 - weight;
				f = N / 2 + weight;
				for(int j = s; j <= f; j++) {
					result += board[i][j] - 48;
				}
				
				if(i < N / 2) weight++;
				else weight--;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
