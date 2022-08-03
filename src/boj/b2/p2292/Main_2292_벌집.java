package boj.b2.p2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2292_벌집 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(in.readLine());
		int offset = 1;
		int count = 1;
		while(target > offset) {
			offset += count * 6;
			count++;
		}
		System.out.println(count);
	}
}
