package boj.s4.p10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_Stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String op = st.nextToken();
			if("push".equals(op)) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if("pop".equals(op)) {
				sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
			} else if("size".equals(op)) {
				sb.append(stack.size()).append("\n");
			} else if("empty".equals(op)) {
				sb.append(stack.isEmpty() ? "1" : "0").append("\n");
			} else if("top".equals(op)) {
				sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
