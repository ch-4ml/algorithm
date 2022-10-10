package boj.s4.P4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack;
		while(true) {
			stack = new Stack<>();
			String str = in.readLine();
			if(str.equals(".")) break;
			
			boolean result = true;
			for(int i = 0, size = str.length(); i < size; i++) {
				Character c = str.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				} else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else {
						result = false;
						break;
					}
				} else if(c == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
					else {
						result = false;
						break;
					}
				}
			}
			if(stack.size() > 0) result = false;
			sb.append(result ? "yes" : "no").append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
