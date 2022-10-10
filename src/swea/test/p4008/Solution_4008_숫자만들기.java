package swea.test.p4008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	
	static int N, max, min;
	static int[] operand;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			operand = new int[N];
			st = new StringTokenizer(in.readLine());
			int add = Integer.parseInt(st.nextToken());
			int sub = Integer.parseInt(st.nextToken());
			int mul = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++) {
				operand[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			dfs(add, sub, mul, div, 0, operand[0]);
			
			sb.append("#").append(t).append(" ").append(max - min).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void dfs(int add, int sub, int mul, int div, int depth, int result) {
		if(depth == N - 1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		} else {
			if(add > 0) dfs(add - 1, sub, mul, div, depth + 1, result + operand[depth + 1]);
			if(sub > 0) dfs(add, sub - 1, mul, div, depth + 1, result - operand[depth + 1]);
			if(mul > 0) dfs(add, sub, mul - 1, div, depth + 1, result * operand[depth + 1]);
			if(div > 0) dfs(add, sub, mul, div - 1, depth + 1, result / operand[depth + 1]);
		}
	}
}
