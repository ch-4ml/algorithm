import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		// 현재 검사하는 집(N번째 집)을 (R / G / B)로 칠했을 때의 누적 최소 비용을 저장할 동적 테이블
		// 각 요소는 해당하는 집을 (R / G / B)로 칠하는 데 필요한 비용으로 초기화
		int[][] cost = new int[N + 1][3]; 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); // R
			cost[i][1] = Integer.parseInt(st.nextToken()); // G
			cost[i][2] = Integer.parseInt(st.nextToken()); // B
		}

		// 동적 테이블 연산
		for (int i = 1; i <= N; i++) { 
			for(int j = 0; j < 3; j++) {
				int rgb = j - 1;
				cost[i][++rgb % 3] = Math.min(cost[i - 1][++rgb % 3], cost[i - 1][++rgb % 3]) + cost[i][++rgb % 3];
			}
		}
		
		// N번째 집을 (R / G / B)로 칠했을 때 누적 최소 비용을 조회해서 최소값을 답으로 구하기 
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, cost[N][i]);
		}
		
		out.write(min + "");
		out.flush();
		out.close();
	}
}
