package boj.s4.p10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] nums = new int[20000001];
		for(int i = 0; i < N; i++) {
			int next = Integer.parseInt(st.nextToken()) + 10_000_000;
			nums[next]++;
		}
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < M; i++) {
			int next = Integer.parseInt(st.nextToken()) + 10_000_000;
			sb.append(nums[next]).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

