package boj.b2.p2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int len = str.length();
		int target = Integer.parseInt(str);
		int result = 0;
		for(int i = target - len * 9; i < target; i++) {
			int num = i;
			int sum = num;
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			if(sum == target) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
