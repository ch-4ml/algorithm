package swea.d4.p1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int idx, N;
		char[] nodes;
		char node;
		
		testcase:
		for(int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(in.readLine());
			
			// 자식 노드가 1개인 경우
			if(N % 2 == 0) {
				sb.append(0).append("\n");
				for(int i = 0; i < N; i++) in.readLine();
				continue;
			}
			
			nodes = new char[N + 1]; 
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				idx = Integer.parseInt(st.nextToken());
				node = st.nextToken().charAt(0);
				
				// 리프 노드가 연산자인 경우
				if(node < '0' && node > '9' && !st.hasMoreTokens()) {
					sb.append(0).append("\n");
					continue testcase;
				}
				nodes[idx] = node;
			}
			
			// 피연산자 노드를 루트로 하는 서브 트리가 존재하는 경우
			for(int i = 1; i <= N; i++) {
				node = nodes[i];
				if(node >= '0' && node <= '9') {
					if(i * 2 <= N || i * 2 + 1 <= N) {						
						sb.append(0).append("\n");
						continue testcase;
					}
				}
			}
			
			sb.append(1).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
