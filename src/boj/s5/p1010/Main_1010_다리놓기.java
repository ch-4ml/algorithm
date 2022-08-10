package boj.s5.p1010;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main_1010_다리놓기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int N = 0, M = 0;
		for(int t = 0; t < T; t++) {
			int count = 0;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[][] memo = new int[M + 1][N + 1]; 
			for(int n = 0; n <= M; n++) {
				for(int r = 0; r <= N; r++) {					
					if(n == r) {
						memo[n][r] = 1;
						break;
					}
					
					if(r == 0) {
						memo[n][r] = 1;
						continue;
					}
					
					memo[n][r] = memo[n - 1][r - 1] + memo[n - 1][r];
				}
			}
			
			count = memo[M][N];
			
			sb.append(count).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
