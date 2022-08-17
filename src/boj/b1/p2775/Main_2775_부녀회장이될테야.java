package boj.b1.p2775;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2775_부녀회장이될테야 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		int k, n;
		int[][] map;
		for(int t = 1; t < T + 1; t++) {
			k = Integer.parseInt(in.readLine()) + 1;
			n = Integer.parseInt(in.readLine());
			
			map = new int[k][n + 1];
			for(int i = 0; i < k; i++) {
				map[i][1] = 1;
			}
			
			for(int i = 1; i < n + 1; i++) {
				map[0][i] = i;
			}
			
			for(int i = 1; i < k; i++) {
				for(int j = 1; j < n + 1; j++) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
			
			sb.append(map[k - 1][n]).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

/*
 1  5 15 35 70
 1  4 10 20 35
 1  3  6 10 15
 1  2  3  4  5
*/