package boj.s5.p9012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			char[] input = in.readLine().toCharArray();
			boolean result = true;
			for(int j = 0, size = input.length; j < size; j++) {
				char c = input[j];
				if(c == '(') {
					stack.push(c);
				} else {
					if(!stack.isEmpty()) {
						stack.pop();
					} else {
						result = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) result = false;
			sb.append(result ? "YES" : "NO").append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
