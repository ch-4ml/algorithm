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
			// 연산자가 나오면 현재까지 쌓인 문자열을 숫자로 변환해서 피연산자 스택에 넣기
			if(exp[i] == '+' || exp[i] == '-') {
				operand.push(Integer.valueOf(sb.toString()));
				sb.delete(0, sb.length());
				
				// 현재 연산자 스택의 top에 '+'가 있다면 먼저 계산하기
				if(!operator.isEmpty() && operator.peek() == '+') {
					operator.pop();
					operand.push(operand.pop() + operand.pop());
				}
				
				// 다음 연산자를 집어넣기
				operator.push(exp[i]);
			} else sb.append(String.valueOf(exp[i]));
		}
		
		// 마지막에는 항상 숫자가 오기 때문에 마찬가지로 쌓인 문자열을 숫자로 변환해서 피연산자 스택에 넣기
		operand.push(Integer.valueOf(sb.toString()));
		
		// 마지막에 나온 연산자가 '+'인 경우 미리 더해주기
		if(!operator.isEmpty() && operator.peek() == '+') {
			operator.pop();
			operand.push(operand.pop() + operand.pop());
		} 
			
		// '-'만 들어있는 연산자 스택을 차례로 비우면서 연산, 피연산자가 한 개 남을 때까지 반복 
		while(operand.size() > 1) {
			result -= operand.pop();
		}
		
		// 가장 처음 들어온 숫자는 그대로 결과에 더해주기
		if(!operand.isEmpty()) result += operand.pop();
		
		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
}
