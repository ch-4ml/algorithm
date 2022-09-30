package boj.s3.p1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int X = Integer.parseInt(in.readLine());
		// 정수가 X일 때 연산의 최소 횟수를 저장하는 동적 테이블
		int[] minCounts = new int[X + 1];

		for(int i = 2; i <= X; i++) {
			minCounts[i] = minCounts[i - 1] + 1;
			if(i % 2 == 0) minCounts[i] = Math.min(minCounts[i], minCounts[i / 2] + 1);
			if(i % 3 == 0) minCounts[i] = Math.min(minCounts[i], minCounts[i / 3] + 1);
		}

		out.write(minCounts[X] + "");
		out.flush();
		out.close();
	}
}
