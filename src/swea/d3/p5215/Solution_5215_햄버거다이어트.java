package swea.d3.p5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	
	static List<int[]> list;
	static int max;
	static int L;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int N;
		
		int[] data;
		for(int t = 1; t < T + 1; t++) {
			max = 0;
			list = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				data = new int[2];
				data[0] = Integer.parseInt(st.nextToken());
				data[1] = Integer.parseInt(st.nextToken());
				list.add(data);
			}
			
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			
			powerset(N, new boolean[N]);
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	private static void powerset(int left, boolean[] isSelected) {
		if(left == 0) {
			int score = 0;
			int kcal = 0;
			for(int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					score += list.get(i)[0];
					kcal += list.get(i)[1];
				}
			}

			if(kcal <= L) max = Math.max(score, max);
			return;
		}

		isSelected[isSelected.length - left] = true;
		powerset(left - 1, isSelected);
		
		isSelected[isSelected.length - left] = false;
		powerset(left - 1, isSelected);
	}
}
