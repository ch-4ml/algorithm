package boj.s5.p11866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int i = 0;
		sb.append("<");
		while(!queue.isEmpty()) {
			if(++i % K == 0) {
				sb.append(queue.removeFirst());
				if(queue.size() > 0) sb.append(", ");
			} else {
				queue.offer(queue.removeFirst());
			}
		}
		sb.append(">");
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

}
