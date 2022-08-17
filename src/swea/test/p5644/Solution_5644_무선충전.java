package swea.test.p5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());

		int[] moveA, moveB, posA, posB;
		int[] dr = { 0, -1, 0, 1, 0 };
		int[] dc = { 0, 0, 1, 0, -1 };
		int sum;

		for(int t = 1; t < 2; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			
			
			pos = new int[2][2];  // 현재 위치
			sum = 0;  // 시간별 최대 충전량
			for(int i = 0; i < 2; i++) {				
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < M; j++) {
					move[j][i] = Integer.parseInt(st.nextToken());
				}

			}

			sb.append(sum).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}


class BatteryCharger {
	int row;
	int col;
	int coverage;
	int performance;
	List<Integer> coverageAreaRow = new ArrayList<>();
	List<Integer> coverageAreaCol = new ArrayList<>();
	
	public BatteryCharger(int row, int col, int coverage, int performance) {
		super();
		this.row = row;
		this.col = col;
		this.coverage = coverage;
		this.performance = performance;
		
		int weight = 0;
		for(int i = row - coverage; i <= row + coverage; i++) {
			for(int j = coverage - weight; j <= coverage + weight; j++) {
				coverageAreaRow.add(i);
				coverageAreaCol.add(i);
			}
			weight = i < row ? weight + 1 : weight - 1;
		}
	}
}

class Person {
	int row;
	int col;
	
}