package swea.d3.p1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1208_Flattern {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			// 입력
			int[] heights = new int[100];
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 100; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}			
			
			int max = 0, min = 0, maxIdx = -1, minIdx = -1;
			for (int i = 0; i < N + 1; i++) {
				max = -1;
				min = Integer.MAX_VALUE;
				maxIdx = -1;
				minIdx = -1;
				for (int j = 0; j < 100; j++) {
					if (max < heights[j]) {
						max = heights[j];
						maxIdx = j;
					}
					if (min > heights[j]) {
						min = heights[j];
						minIdx = j;
					}
				}
				if (i == N)
					break;
				heights[maxIdx] -= 1;
				heights[minIdx] += 1;
			}

			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
	}
}
