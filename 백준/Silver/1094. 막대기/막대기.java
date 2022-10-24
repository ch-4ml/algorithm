import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	// 초기값 64
	static final int INIT = 64;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
			// 나무 막대를 저장할 stack
			Stack<Integer> stack = new Stack<>();
			
			// 목표 길이 X 입력
			int X = Integer.parseInt(in.readLine());
			
			// 현재 확정된 나무 막대의 길이를 저장하는 변수
			int total = 0;
			
			// 스택에 처음 상태의 나무 막대를 push
			stack.push(INIT);
			
			// 스택의 마지막에 포함된 나무 막대의 길이가 0일때 까지 반복
			// 목표하는 길이를 찾았을 때 나무 막대의 길이가 0으로 포함됨
			while (stack.peek() != 0) {
				
				// 초기값이 목표값인 경우
				if (X == INIT) {
					break;
				}
				
				// 가장 작은 나무 막대를 스택에서 pop
				int min = stack.pop();
				
				// 스택에서 pop한 나무 막대를 절반으로 나눴을 때 길이 저장
				int half = min / 2;
				
				// 현재까지 확정된 나무 길이 + 가장 짧은 나무 막대를 절반으로 나눈 길이가 목표치보다 큰 경우
				if (total + half > X) {
					// 절반으로 나눈 나무 막대만 스택에 포함
					stack.push(half);
				
				// 현재까지 확정된 나무 길이 + 가장 짧은 나무 막대를 절반으로 나눈 길이가 목표치보다 작은 경우
				} else if (total + half < X) {
					// 절반으로 나눈 두 개의 나무 조각을 모두 스택에 포함
					stack.push(half);
					stack.push(half);
					// 절반으로 나눈 만큼만 확정 길이에 누적
					total += half;
				
				// 현재까지 확정된 나무 길이 + 가장 짧은 나무 막대를 절반으로 나눈 길이가 목표치인 경우
				} else {
					// 스택에 마지막 나무 길이를 포함
					stack.push(half);
					
					// 절반으로 나눈 길이를 확정 길이에 누적
					total += half;
				}
			}
			
			// 테스트케이스별 출력 문자열을 한꺼번에 만들기
			sb.append(stack.size());

		// 출력
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}