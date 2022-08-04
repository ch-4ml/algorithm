package swea.d4.p1218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N, result;
		char[] characters;
		Stack<Character> stack = new Stack<>();
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(in.readLine());
			characters = in.readLine().toCharArray();
			result = 1;
			for (int i = 0; i < N; i++) {
				// 여는 괄호
				if (characters[i] == '(' || characters[i] == '[' || characters[i] == '{' || characters[i] == '<') {
					stack.push(characters[i]);					
				} else if (characters[i] == ')') {
					if (stack.pop() != '(') {
						result = 0;
						break;
					}
				} else if (characters[i] == ']') {
					if (stack.pop() != '[') {
						result = 0;
						break;
					}
				} else if (characters[i] == '}') {
					if (stack.pop() != '{') {
						result = 0;
						break;
					}
				} else if (characters[i] == '>') {
					if (stack.pop() != '<') {
						result = 0;
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
