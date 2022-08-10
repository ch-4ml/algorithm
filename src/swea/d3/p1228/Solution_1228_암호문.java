package swea.d3.p1228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1228_암호문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, st2;
		int len = 10;
		int[] arr = new int[len];
		int O, idx, cnt;

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			in.readLine(); // n
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			O = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), "I");
			for (int i = 0; i < O; i++) {
				st2 = new StringTokenizer(st.nextToken());
				idx = Integer.parseInt(st2.nextToken());
				cnt = Integer.parseInt(st2.nextToken());
				
				// 밀기
				for (int j = len - cnt - 1; j >= idx; j--) {
					if(j < 0 || j + cnt > 9) break;
					arr[j + cnt] = arr[j];
				}
				
				for (int j = 0; j < cnt; j++) {
					if (idx + j > 9) break;
					arr[idx + j] = Integer.parseInt(st2.nextToken());
				}
			}

			for (int i = 0; i < 10; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
