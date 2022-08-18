package swea.test.p5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
			for (int i = 1; i <= M + 1; i++) {

				// Calculate (시작 위치의 경우를 포함해야 하기 때문에 계산을 먼저 수행함)
				for (int j = 0; j < C; j++) {
					if (bcs[j].isCovered(A.row, A.col)) {
						bcs[j].isCoveredA = 1;
					}

					if (bcs[j].isCovered(B.row, B.col)) {
						bcs[j].isCoveredB = 1;
					}
				}

				int tmp = 0, max = 0;
				tmp += getMaxPerformanceOfA(bcs);
				tmp += getMaxPerformanceOfB(bcs);

				max = tmp;

				tmp = 0;
				for (int j = 0; j < C; j++) {
					bcs[j].useCount = 1;
				}

				tmp += getMaxPerformanceOfB(bcs);
				tmp += getMaxPerformanceOfA(bcs);

				max = Math.max(max, tmp);
				sum += max;

				// Break
				if (i == M + 1)
					break;

				// Move
				A.move(moveA[i]);
				B.move(moveB[i]);

				// Initialize isUsed field
				for (int j = 0; j < C; j++) {
					bcs[j].isCoveredA = 0;
					bcs[j].isCoveredB = 0;
					bcs[j].useCount = 1;
				}
			}
			sb.append(sum).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static int getMaxPerformanceOfA(BatteryCharger[] bcs) {

		int result = 0;
		Comparator<BatteryCharger> comparatorA = new Comparator<BatteryCharger>() {
			@Override
			public int compare(BatteryCharger o1, BatteryCharger o2) {
				return o1.isCoveredA == o2.isCoveredA
						? o1.useCount == o2.useCount ? o2.performance - o1.performance : o1.useCount - o2.useCount
						: o2.isCoveredA - o1.isCoveredA;
			}
		};

		Arrays.sort(bcs, comparatorA);
		if (bcs[0].isCoveredA == 1 && bcs[0].useCount == 1) {
			result = bcs[0].getPerformance();
			bcs[0].useCount++;
		}

		return result;
	}

	static int getMaxPerformanceOfB(BatteryCharger[] bcs) {

		int result = 0;
		Comparator<BatteryCharger> comparatorB = new Comparator<BatteryCharger>() {
			@Override
			public int compare(BatteryCharger o1, BatteryCharger o2) {
				return o1.isCoveredB == o2.isCoveredB
						? o1.useCount == o2.useCount ? o2.performance - o1.performance : o1.useCount - o2.useCount
						: o2.isCoveredB - o1.isCoveredB;
			}
		};

		Arrays.sort(bcs, comparatorB);
		if (bcs[0].isCoveredB == 1 && bcs[0].useCount == 1) {
			result = bcs[0].getPerformance();
			bcs[0].useCount++;
		}

		return result;
	}
}

class BatteryCharger {
	int isCoveredA;
	int isCoveredB;
	int row;
	int col;
	int coverage;
	int performance;
	int useCount;
	List<Integer> coverageAreaRow = new ArrayList<>();
	List<Integer> coverageAreaCol = new ArrayList<>();

	public BatteryCharger(int col, int row, int coverage, int performance) {
		super();
		this.col = col;
		this.row = row;
		this.coverage = coverage;
		this.performance = performance;
		this.useCount = 1;

		int weight = 0;
		for (int i = row - coverage; i <= row + coverage; i++) {
			for (int j = col - weight; j <= col + weight; j++) { // trouble shooting #1
				if (i < 1 || i > 10 || j < 1 || j > 10)
					continue; // trouble shooting #2
				coverageAreaRow.add(i);
				coverageAreaCol.add(j);
			}
			weight = i < row ? weight + 1 : weight - 1;
		}
	}

	int getPerformance() {
		return performance / useCount;
	}

	boolean isCovered(int row, int col) {
		for (int i = 0; i < coverageAreaRow.size(); i++) {
			if (coverageAreaRow.get(i) == row && coverageAreaCol.get(i) == col)
				return true;
		}
		return false;
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