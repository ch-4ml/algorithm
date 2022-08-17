package boj.b1.p10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main_10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int n;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			n = Integer.parseInt(in.readLine());
			if(map.get(n) != null) map.put(n, map.get(n) + 1);
			else map.put(n, 1);
		}
		
		for(int key: map.keySet()) {
			sb.append(map.get(key)).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
