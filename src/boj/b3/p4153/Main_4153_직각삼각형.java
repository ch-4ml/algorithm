package boj.b3.p4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strLines = new String[3];
		int[] lines = new int[] { 1, 1, 1 };
		int max, idx, a, b;

		while (lines[0] > 0 || lines[1] > 0 || lines[2] > 0) {
			a = 0;
			b = 0;
			max = -1;
			idx = 0;
			strLines = in.readLine().split(" ");
			if(strLines[0].equals("0") && strLines[1].equals("0") && strLines[2].equals("0")) break;
			for (int i = 0; i < 3; i++) {
				lines[i] = Integer.valueOf(strLines[i]);
				if (lines[i] > max) {
					max = lines[i];
					idx = i;
				}
			}

			for (int i = 0; i < 3; i++) {
				if (i == idx)
					a = (int) Math.pow(lines[i], 2);
				else
					b += (int) Math.pow(lines[i], 2);
			}

			sb.append(a == b ? "right\n" : "wrong\n");
		}
		System.out.println(sb);
	}
}
