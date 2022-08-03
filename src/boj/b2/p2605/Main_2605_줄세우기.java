package boj.b2.p2605;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		List<Integer> students = new ArrayList<>();
		int student = 0;
		students.add(++student);
		st.nextToken();
		for(int i = 1; i < N; i++) {
			students.add(students.size() - Integer.parseInt(st.nextToken()), ++student);
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(students.get(i)).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
