package boj.s3.p1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		char[] sw = new char[N];
		int idx = 0;

		// 입력 받아서 배열에 넣기
		while (st.hasMoreTokens())
			sw[idx++] = st.nextToken().charAt(0);

		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			String[] student = in.readLine().split(" ");
			int basis = Integer.parseInt(student[1]);
			if (student[0].equals("1")) {
				int weight = 1;
				while (basis * weight - 1 < N) {
					toggle(sw, basis * weight - 1);
					weight++;
				}
			} else {
				basis -= 1;
				int weight = 0;
				while (basis - weight - 1 > -1 && basis + weight + 1 < N) {
					if (sw[basis - weight - 1] == sw[basis + weight + 1])
						weight++;
					else
						break;
				}

				toggle(sw, basis);
				for (int j = 1; j <= weight; j++) {
					toggle(sw, basis - j);
					toggle(sw, basis + j);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sw.length; i++) {
			sb.append(sw[i]).append(" ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}

		System.out.println(sb);
	}

	static void toggle(char[] sw, int index) {
		sw[index] = Integer.toString(Math.abs(sw[index] - 49)).charAt(0);
	}
}
