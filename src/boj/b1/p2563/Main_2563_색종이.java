package boj.b1.p2563;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		boolean[][] map = new boolean[100][100];
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int j = h; j < h + 10; j++) {
				for(int k = w; k < w + 10; k++) {
					map[j][k] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j]) count++;
			}
		}
		
		out.write(String.valueOf(count));
		out.flush();
		out.close();
	}
}
