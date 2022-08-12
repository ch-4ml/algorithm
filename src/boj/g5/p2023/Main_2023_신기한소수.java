package boj.g5.p2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2023_신기한소수 {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		int[] nums = new int[N];
		int[] primes = { 2, 3, 5, 7 };
		
		for (int i = 0; i < primes.length; i++) {
			nums[0] = primes[i];
			findPrimeNumber(1, nums);
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static void findPrimeNumber(int index, int[] nums) {
		// 소수 검사를 위해 숫자 합치기
		int n = 0;
		for (int i = 0; i < index; i++) {
			n += nums[i] * (int) Math.pow(10, index - i - 1);
		}
		
		// 제곱근까지 나누어 떨어지는 수가 있는지 검사
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i < sqrt; i++) {
			if (n % i == 0)
				return;
		}
		
		if (index == N) {
			for (int i = 0; i < N; i++)
				sb.append(nums[i]);
			sb.append("\n");
			return;
		}

		// 다음 숫자 선택
		for (int i = 0; i <= 9; i++) {
			if (i % 2 == 0 || i % 5 == 0)
				continue;
			nums[index] = i;
			findPrimeNumber(index + 1, nums);
		}
	}
}
