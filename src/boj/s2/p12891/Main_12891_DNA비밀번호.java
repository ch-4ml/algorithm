package boj.s2.p12891;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main_12891_DNA비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] characters = in.readLine().toCharArray();
		st = new StringTokenizer(in.readLine());
		int minA = Integer.parseInt(st.nextToken());
		int minC = Integer.parseInt(st.nextToken());
		int minG = Integer.parseInt(st.nextToken());
		int minT = Integer.parseInt(st.nextToken());

		Queue<Character> queue = new ArrayDeque<>();
		Map<Character, Integer> count = new HashMap<>();
		count.put('A', 0);
		count.put('C', 0);
		count.put('G', 0);
		count.put('T', 0);
		int result = 0;
		// Initialize
		char c;
		for (int i = 0; i < P; i++) {
			c = characters[i];
			queue.offer(c);
			count.put(c, count.get(c) + 1);
		}
		if (count.get('A') >= minA && count.get('C') >= minC && count.get('G') >= minG && count.get('T') >= minT)
			result++;

		// Search
		for (int i = P; i < S; i++) {
			c = queue.poll();
			count.put(c, count.get(c) - 1);
			c = characters[i];
			queue.offer(c);
			count.put(c, count.get(c) + 1);
			if (count.get('A') >= minA && count.get('C') >= minC && count.get('G') >= minG && count.get('T') >= minT)
				result++;
		}

		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}
}
