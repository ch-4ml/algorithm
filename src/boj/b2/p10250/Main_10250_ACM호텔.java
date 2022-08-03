package boj.b2.p10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10250_ACM호텔 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t < T + 1; t++) {
			String[] data = in.readLine().split(" ");
			int h = Integer.parseInt(data[0]);
			int n = Integer.parseInt(data[2]);
			int floor = n % h == 0 ? h : n % h;
			int room = n % h == 0 ? n / h : n / h + 1;
			sb.append(floor).append(String.format("%02d", room)).append("\n");
		}
		System.out.print(sb);
	}
}
