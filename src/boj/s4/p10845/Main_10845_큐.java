package boj.s4.p10845;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_10845_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String op = st.nextToken();
			if (op.equals("push")) {
				queue.offer(Integer.parseInt(st.nextToken()));
			} else if (op.equals("pop")) {
				sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
			} else if (op.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (op.equals("empty")) {
				sb.append(queue.isEmpty() ? "1" : "0").append("\n");
			} else if (op.equals("front")) {
				sb.append(queue.isEmpty() ? "-1" : queue.peek()).append("\n");
			} else if (op.equals("back")) {
				sb.append(queue.isEmpty() ? "-1" : queue.peekLast()).append("\n");
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}
}
