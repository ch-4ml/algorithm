package boj.s4.p10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		Map<Integer, Integer> map = new HashMap<>(); 
		for(int i = 0; i < N; i++) {
			int next = Integer.parseInt(st.nextToken()); 
			if(map.get(next) == null) {
				map.put(next, 1);
			} else {
				map.put(next, map.get(next) + 1);
			}
		}
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < M; i++) {
			int next = Integer.parseInt(st.nextToken());
			sb.append(map.get(next) == null ? 0 : map.get(next)).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
