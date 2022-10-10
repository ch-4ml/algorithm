package boj.s4.p10866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_10866_덱 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String op = st.nextToken();
			if (op.equals("push_front")) {
				deque.offerFirst(Integer.parseInt(st.nextToken()));
			} else if (op.equals("push_back")) {
				deque.offerLast(Integer.parseInt(st.nextToken()));
			} else if (op.equals("pop_front")) {
				sb.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append("\n");
			} else if (op.equals("pop_back")) {
				sb.append(deque.isEmpty() ? "-1" : deque.pollLast()).append("\n");
			} else if (op.equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if (op.equals("empty")) {
				sb.append(deque.isEmpty() ? "1" : "0").append("\n");
			} else if (op.equals("front")) {
				sb.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
			} else if (op.equals("back")) {
				sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
