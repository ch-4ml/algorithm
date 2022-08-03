package boj.b1.p2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] heights = new int[9];
		for(int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(heights);
		
		int sum, a = 0, b = 0;
		find:
		for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				sum = 0;
				for(int k = 0; k < 9; k++) {
					if(k == i || k == j) continue;
					sum += heights[k];
				}
				if(sum == 100) {
					a = i;
					b = j;
					break find;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			if(i == a || i == b) continue;
			sb.append(heights[i]).append("\n");
		}

		System.out.println(sb);
	}
}
