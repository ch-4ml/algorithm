package swea.test.p15170;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_15170_낚시터자리잡기 {

	static int min;
	static int[] entrances;
	static int[] fishermen;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			
			int N = Integer.parseInt(in.readLine());

			entrances = new int[4];
			fishermen = new int[4];

			for (int i = 1; i <= 3; i++) {
				st = new StringTokenizer(in.readLine());
				entrances[i] = Integer.parseInt(st.nextToken());
				fishermen[i] = Integer.parseInt(st.nextToken());
			}

			int[] order = { 1, 2, 3 };
			do {
				calc(order, 0, 0, new boolean[N + 1]);
			} while (nextPermutation(order, order.length));
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static void calc(int[] order, int count, int sum, boolean[] isUsed) {
		
		if (count == order.length) {
			min = min > sum ? sum : min;
			return;
		}
		
		int dist = 1;
		int entrance = entrances[order[count]];
		int fishers = fishermen[order[count]];

		int left = entrance;
		int right = entrance;
		
		while (fishers > 0) {
			
			if (fishers == 1 && left > 0 && right < isUsed.length && !isUsed[left] && !isUsed[right]) {
				break;
			}
			
			
			if (left > 0 && !isUsed[left]) {
				isUsed[left] = true;
				sum += dist;
				fishers--;
			}

			if (right < isUsed.length && !isUsed[right]) {
				isUsed[right] = true;
				sum += dist;
				fishers--;
			}
			
			dist++;
			left--;
			right++;
		}
		
		if(fishers == 1) {
			boolean[] leftUsed = new boolean[isUsed.length];
			boolean[] rightUsed = new boolean[isUsed.length];
			for(int i = 1; i < isUsed.length; i++) {
				leftUsed[i] = isUsed[i];
				rightUsed[i] = isUsed[i];
			}
			
			leftUsed[left] = true;
			calc(order, count + 1, sum + dist, leftUsed);
			
			rightUsed[right] = true;
			calc(order, count + 1, sum + dist, rightUsed);
		} else {
			calc(order, count + 1, sum, isUsed);
		}
	}

	static boolean nextPermutation(int[] order, int N) {
		int i = N - 1;
		while (i > 0 && order[i - 1] > order[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (order[i - 1] > order[j])
			--j;

		swap(order, i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(order, i++, k--);

		return true;
	}

	static void swap(int[] order, int i, int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}
}
