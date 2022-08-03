package boj.s3.p1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		String[] sw = new String[N];

		int idx = 0;
		for (int i = 0; i < N / 20 + 1; i++) {
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) sw[idx++] = st.nextToken();
		}

		int weight;
		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			String[] student = in.readLine().split(" ");
			if (student[0].equals("1")) {
				int basis = Integer.parseInt(student[1]);
				weight = 0;
				while (basis * (weight + 1) - 1 < N) {
					weight++;
					toggle(sw, basis * weight - 1);
				}
			} else {
				int basis = Integer.parseInt(student[1]) - 1;
				weight = 0;
				while (basis - weight > 0 && basis + weight < N - 1) {
					if(sw[basis - weight - 1].equals(sw[basis + weight + 1])) weight++;	
					else break;
				}
				
				toggle(sw, basis);
				for (int j = 1; j <= weight; j++) {
					toggle(sw, basis - j);
					toggle(sw, basis + j);
				}
			}
		}

		for (int i = 0; i < sw.length; i++) {
			System.out.print(sw[i] + " ");
		}
	}

	static void toggle(String[] sw, int idx) {
		sw[idx] = sw[idx].equals("0") ? "1" : "0";
	}
}
