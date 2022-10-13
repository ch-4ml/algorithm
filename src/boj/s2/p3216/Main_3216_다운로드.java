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
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int d = 0; // 다운로드하는 노래 길이 
		int v = 0; // 다운로드까지 필요한 시간
		int length = 0; // 현재 시점에 재생할 수 있는 노래 길이
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			d = Integer.parseInt(st.nextToken());	
			v = Integer.parseInt(st.nextToken());
			length -= v;
			min = Math.min(min, length);
			length += d;
		}
		
		out.write(1 + (min + 1) * -1 + "");
		out.flush();
		out.close();
	}
}
