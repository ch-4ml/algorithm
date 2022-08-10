package boj.g5.p2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		int[] result = new int[N + 1];
		int next;
		
		// 담으면서 비교
		for (int i = 1; i <= N; i++) {
			next = Integer.parseInt(st.nextToken());
			
			while(stack.size() > 0) {
				if(stack.peek() < next) {
					result[index.pop()] = index.size() > 0 ? index.peek() : 0;
					stack.pop();
				}
				else break;				
			}
				
			index.push(i);
			stack.push(next);
		}
		
		while(index.size() > 1) {
			result[index.pop()] = index.peek();
		}

		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
