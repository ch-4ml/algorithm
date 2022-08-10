package boj.s5.p1010;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main_1010_다리놓기 {
	
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int N = 0, M = 0;
		for(int t = 0; t < T; t++) {
			count = 0;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			combination(N, M, 0);
			sb.append(count).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	private static void combination(int r, int n, int startIndex) {
		if(r == 0) {
			count++;
			return;
		}
		
		for(int i = startIndex; i < n; i++) {
			combination(r - 1, n, i + 1);
		}
	}
}
