package boj.s2.p3216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3216_다운로드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[][] blocks = new int[N][2];
		int song = 0;
		int down = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			song += blocks[i][0] = Integer.parseInt(st.nextToken());	
			down += blocks[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dt = new int[N][2]; // 현재 시간에 재생할 수 있는 노래 길이를 저장하는 dynamic table
		for (int i = 0; i < N; i++) {
			
		}
		
	}
}
