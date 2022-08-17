package boj.g5.p15686;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int[]> home = new ArrayList<>();
		List<int[]> chicken = new ArrayList<>();
		
		int val = 0;
		int[] pos;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				val = Integer.parseInt(st.nextToken());
				if (val > 0) {
					pos = new int[2];
					pos[0] = j; pos[1] = i;
					if (val == 1) home.add(pos);
					else if (val == 2) chicken.add(pos);
				}
			}
		}
		
		// 집에서 치킨집 사이의 거리를 저장하는 이차원 배열 만들기
		int distance = 0;
		int homeSize = home.size();
		int chickenSize = chicken.size();
		int[][] distances = new int[homeSize][chickenSize];
		for (int i = 0; i < homeSize; i++) {
			for (int j = 0; j < chickenSize; j++) {
				distance = Math.abs(home.get(i)[0] - chicken.get(j)[0]) + Math.abs(home.get(i)[1] - chicken.get(j)[1]);
				distances[i][j] = distance;
			}
		}
		
		combination(M, 0, M, new int[M], homeSize, chickenSize, distances);
		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
	
	// comb: 치킨집의 index를 M개만큼 저장하고 있는 배열
	static void combination(int left, int startIdx, int M, int[] comb, int homeSize, int chickenSize, int[][] distances) {
		if(left == 0) {
			// 모든 집에 대해 각 치킨집까지의 거리 중 최솟값을 구해서 더하기
			int min, d, sum = 0;
			for(int i = 0; i < homeSize; i++) {
				min = Integer.MAX_VALUE;
				for(int j = 0; j < M; j++) {
					d = distances[i][comb[j]];
					min = d < min ? d : min;
				}
				sum += min;
			}
			
			result = sum < result ? sum : result;
			return;
		}
		
		for(int i = startIdx; i < chickenSize; i++) {
			comb[M - left] = i;
			combination(left - 1, i + 1, M, comb, homeSize, chickenSize, distances);			
		}
	}
}
