package boj.s2.p1541;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> operator = new Stack<>();
		Stack<Integer> operand = new Stack<>();
		char[] exp = in.readLine().toCharArray();
		int result = 0;
		for(int i = 0, size = exp.length; i < size; i++) {
			if(exp[i] == '+' || exp[i] == '-') {
				operand.push(Integer.valueOf(sb.toString()));
				sb.delete(0, sb.length());
				if(!operator.isEmpty() && operator.pop() == '+') operand.push(operand.pop() + operand.pop());
				operator.push(exp[i]);
			} else sb.append(String.valueOf(exp[i]));
		}
		operand.push(Integer.valueOf(sb.toString()));
		
		if(operator.peek() == '+') {
			operator.pop();
			operand.push(operand.pop() + operand.pop());
		} 
			
		while(operand.size() > 1) {
			result -= operand.pop();
		}
		
		if(!operand.isEmpty()) result += operand.pop();
		
		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
}
