package boj.s1.p1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1992_쿼드트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		char[][] video = new char[N][N];
		for(int i = 0; i < N; i++) {
			video[i] = in.readLine().toCharArray();
		}
		
		int[] dr = { 0, 0, 1, 1 };
		int[] dc = { 0, 1, 0, 1 };
		
		compress(N, 0, 0, video, dr, dc, sb);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static void compress(int n, int r, int c, char[][] video, int[] dr, int[] dc, StringBuilder sb) {
		
		if(n == 1) {
			sb.append(video[r][c]);
			return;
		}
		
		// 사각형이 섞여있는지 검사
		boolean isMixed = false;
		char ch = video[r][c];
		check:
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(ch != video[i][j]) {
					isMixed = true;
					break check;
				}
				ch = video[i][j];
			}
		}
		
		// 섞여있는 경우
		if(isMixed) {
			// 여는 괄호 추가
			sb.append("(");
			for(int i = 0; i < 4; i++) {
				compress(n / 2, r + n / 2 * dr[i], c + n / 2 * dc[i], video, dr, dc, sb);
			}
		} else {
			sb.append(video[r][c]);
			return;
		}
		
		// 닫는 괄호 추가
		sb.append(")");
	}
}
