package boj.s3.p11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] params = in.readLine().split(" ");
		int N = Integer.parseInt(params[0]);
		int M = Integer.parseInt(params[1]);

		// 숫자 배열 만들기
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 현재 Index까지의 합을 저장하는 배열 만들기
		int[] accumulation = new int[N];
		accumulation[0] = nums[0];
		for (int i = 1; i < N; i++) {
			accumulation[i] = nums[i] + accumulation[i - 1];
		}

		String[] range;
		for (int i = 0; i < M; i++) {
			range = in.readLine().split(" ");
			int s = Integer.parseInt(range[0]) - 1;
			int e = Integer.parseInt(range[1]) - 1;
			sb.append(s == 0 ? accumulation[e] : accumulation[e] - accumulation[s-1]).append("\n");
		}

		System.out.println(sb);
	}
}
