package jungol.p1828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[][] materials = new int[N][2]; 
		for (int i = 0; i < N; i++) { 
			st = new StringTokenizer(in.readLine());
			// 이차원 배열에 저장 (0: 최저온도, 1: 최고온도)
			materials[i][0] = Integer.parseInt(st.nextToken()); 
			materials[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(materials, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1]; 
			}
		});
		
		int max = Integer.MIN_VALUE;
		int result = 0;
		for (int i = 0; i < N; i++) {
			if(materials[i][0] > max) {
				result++;
				max = materials[i][1];
			}
		}
		
		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
}
