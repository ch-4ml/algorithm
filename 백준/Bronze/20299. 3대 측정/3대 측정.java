import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 표준 입력을 Line 단위로 처리하기 위해 Reader 객체 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 동아리 신청 가능한 학생을 차례로 문자열에 누적하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// Line 단위로 받은 입력을 공백을 기준으로 분리하기 위해 StringTokenizer 사용
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 정수 N, S, M 입력
		int N = Integer.parseInt(st.nextToken()); // 신청한 동아리 수
		int S = Integer.parseInt(st.nextToken()); // 팀원 3명의 능력 합(가입 조건 1)
		int M = Integer.parseInt(st.nextToken()); // 팀원 개인의 최소 능력 제한(가입 조건 2)
		
		// 신청 가능한 동아리의 수를 누적할 변수
		int cnt = 0;
		
		// 동아리 신청별 학생을 검사
		for (int i = 0; i < N; i++) {
			// 입력 받은 Line을 공백을 기준으로 각 학생의 능력치로 분리
			st = new StringTokenizer(in.readLine());
			
			// 각 학생의 능력치를 변수에 할당
			int x1 = Integer.parseInt(st.nextToken()); // 1번 학생의 능력치
			int x2 = Integer.parseInt(st.nextToken()); // 2번 학생의 능력치
			int x3 = Integer.parseInt(st.nextToken()); // 3번 학생의 능력치
			// 각 학생이 개인 최소 능력치를 만족하고, 동아리를 구성하는 학생들의 능력치 합이 스마트클럽 가입 조건에 부합한지 검사 
			if (x1 >= M && x2 >= M && x3 >= M && x1 + x2 + x3 >= S) {
				// 가능한 경우 동아리 수 추가
				cnt++;
				// 동아리 구성원을 문자열에 추가
				sb.append(x1).append(" ").append(x2).append(" ").append(x3).append(" ");
			}
		}
		
		// 동아리 수를 출력
		System.out.println(cnt);
		// 다음 줄에 동아리 구성원을 순서대로 공백으로 분리해서 출력
		System.out.println(sb.toString());
	}
}