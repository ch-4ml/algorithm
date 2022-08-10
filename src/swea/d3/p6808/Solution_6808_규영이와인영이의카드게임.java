package swea.d3.p6808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	static int[] ky = new int[9];
	static int[] iy = new int[9];
	static int win;
	static int lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		boolean[] isUsed;
		int count, num;
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t < T + 1; t++) {
			isUsed = new boolean[19];
			sb.append("#").append(t).append(" ");
			win = 0;
			lose = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 9; i++) {
				num = Integer.parseInt(st.nextToken());
				ky[i] = num;
				isUsed[num] = true;
			}
			count = 0;
			for (int i = 1; i <= 18; i++) {
				if (!isUsed[i])
					iy[count++] = i;
			}
			
			permutation(9, new int[9], new boolean[9]);
			sb.append(win).append(" ").append(lose).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static void permutation(int left, int[] permutation, boolean[] isSelected) {
		if (left == 0) {
			int w = 0, l = 0;
			for(int i = 0; i < 9; i++) {
				if(ky[i] > permutation[i]) w += ky[i] + permutation[i];
				else l += ky[i] + permutation[i];
			}
			
			if(w > l) win++;
			else if(w < l) lose++;
			
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;

			isSelected[i] = true;
			permutation[permutation.length - left] = iy[i];
			permutation(left - 1, permutation, isSelected);
			isSelected[i] = false;
		}
	}
}
