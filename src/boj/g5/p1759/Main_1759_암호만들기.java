package boj.g5.p1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[] source = new char[C];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < C; i++) {
			source[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(source);
		combination(L, new int[L], 0, L, C, source, sb);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static void combination(int left, int[] comb, int startIdx, int L, int C, char[] source, StringBuilder sb) {
		if(left == 0) {
			int c = 0, v = 0;  // 자음, 모음
			String pw = "";
			for(int i = 0; i < L; i++) {
				char s = source[comb[i]];
				if(s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') v++;
				else c++;
				pw += s;
			}
			
			if(c > 1 && v > 0) sb.append(pw).append("\n");
			return;
		}
		
		for(int i = startIdx, size = source.length; i < size; i++) {
			comb[L - left] = i;
			combination(left - 1, comb, i + 1, L, C, source, sb);
		}
	}
}
