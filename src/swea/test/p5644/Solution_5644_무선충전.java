package swea.test.p5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		int sum;
		int[] moveA, moveB;
		BatteryCharger[] bcs;

		for (int t = 1; t < T + 1; t++) {
			sum = 0;
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			moveA = new int[M + 1]; // 1-based
			moveB = new int[M + 1];
			Person A = new Person(1, 1);
			Person B = new Person(10, 10);
			bcs = new BatteryCharger[C];

			// Input A's movement info
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			// Input B's movement info
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			// Input battery chargers info
			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(in.readLine());
				BatteryCharger bc = new BatteryCharger(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				bcs[i] = bc;
			}

			// Logic
			// 매 시간마다 각 충전소의 영역에 포함되어있는 사람의 수를 저장하는 배열
			int[] pFlag;
			int sumFlag;
			for (int i = 1; i <= M + 1; i++) {
				pFlag = new int[C];
				sumFlag = 0;
				// Calculate (시작 위치의 경우를 포함해야 하기 때문에 계산을 먼저 수행함)
				// BC를 반복해서 탐색하며 A와 B의 포함 여부를 검사
				for (int j = 0; j < C; j++) {
					if (bcs[j].isCovered(A.row, A.col)) {
						pFlag[j] = pFlag[j] | 1;
						bcs[j].isUsed = 1;
					}

					if (bcs[j].isCovered(B.row, B.col)) {
						pFlag[j] = pFlag[j] | 1;
						bcs[j].isUsed = 1;
					}
				}

				// 모든 flag 값 더하기
				for (int j = 0; j < C; j++) {
					sumFlag += pFlag[j];
				}

				// Sort by performance desc
				Arrays.sort(bcs);

				int tmp = 0;

				// 가장 큰 두 개 선택
				if (sumFlag >= 2) {
					tmp = bcs[0].performance + bcs[1].performance;
					sum += tmp;
				}

				// 가장 큰 한 개 선택
				else if (sumFlag == 1) {
					tmp = bcs[0].performance;
					sum += tmp;
				}

				System.out.println(i - 1 + ": " + tmp);
				System.out.println(i - 1 + ". A: " + A.row + " " + A.col);
				System.out.println(i - 1 + ". B: " + B.row + " " + B.col);

				// Break
				if (i == M + 1)
					break;

				// Move
				A.move(moveA[i]);
				B.move(moveB[i]);

				// Initialize isUsed field
				for (int j = 0; j < C; j++) {
					bcs[j].isUsed = 0;
				}
			}
			sb.append(sum).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

class BatteryCharger implements Comparable<BatteryCharger> {
	int isUsed;
	int row;
	int col;
	int coverage;
	int performance;
	List<Integer> coverageAreaRow = new ArrayList<>();
	List<Integer> coverageAreaCol = new ArrayList<>();

	public BatteryCharger(int col, int row, int coverage, int performance) {
		super();
		this.col = col;
		this.row = row;
		this.coverage = coverage;
		this.performance = performance;

//		System.out.println();
//		System.out.println("Row: " + row + " Col: " + col);
		
		int weight = 0;
		for (int i = row - coverage; i <= row + coverage; i++) {
			if(i < 1 || i > 10) continue;
			for (int j = col - weight; j <= col + weight; j++) {
				if(j < 1 || j > 10) continue;
				coverageAreaRow.add(i);
				coverageAreaCol.add(j);
			}
			weight = i < row ? weight + 1 : weight - 1;
		}
		
//		System.out.println();
//		System.out.println(coverageAreaRow.toString());
//		System.out.println(coverageAreaCol.toString());
	}

	boolean isCovered(int row, int col) {
		for (int i = 0; i < coverageAreaRow.size(); i++) {
			if (coverageAreaRow.get(i) == row && coverageAreaCol.get(i) == col)
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(BatteryCharger o) {
		return o.isUsed == this.isUsed ? o.performance - this.performance : o.isUsed - this.isUsed;
	}

}

class Person {

	int[] dr = { 0, -1, 0, 1, 0 };
	int[] dc = { 0, 0, 1, 0, -1 };

	int row;
	int col;

	public Person(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	void move(int move) {
		row += dr[move];
		col += dc[move];
	}
}