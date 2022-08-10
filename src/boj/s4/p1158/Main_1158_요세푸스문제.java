package boj.s4.p1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int count = 0;
		sb.append("<");
		while(queue.size() > 0) {
			count++;
			if(count % K != 0) queue.offer(queue.poll());
			else {
				sb.append(queue.poll());
				if(queue.size() > 0) sb.append(", ");
			}
		}
		sb.append(">");
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
