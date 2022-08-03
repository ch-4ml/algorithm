package swea.d3.p1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc < T+1; tc++) {
			char[] num = in.readLine().toCharArray();
			int count = 0, sw = 0;
			for(char n: num) {
				if(n - 48 != sw) {
					sw = sw == 0 ? 1 : 0;
					count++;
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}
