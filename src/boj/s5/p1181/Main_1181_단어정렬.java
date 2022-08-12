package boj.s5.p1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main_1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		String[] words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = in.readLine();
		}
		
		List<String> list = Arrays.asList(words);
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int result = o1.length() - o2.length();
				if(result == 0) {
					result = o1.compareTo(o2);
				}
				return result;
			}
		});
		
		String tmp = "";
		for(String s: list) {
			if(s.equals(tmp)) continue;
			sb.append(s).append("\n");
			tmp = s;
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
